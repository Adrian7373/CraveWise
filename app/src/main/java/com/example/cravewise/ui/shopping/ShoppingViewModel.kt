package com.example.cravewise.ui.shopping

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cravewise.data.repository.ProfileGateSource
import com.example.cravewise.data.repository.RecipeRepository
import com.example.cravewise.data.repository.ShoppingRepository
import com.example.cravewise.data.repository.ShoppingUndo
import com.example.cravewise.domain.IngredientSearch
import com.example.cravewise.domain.ShoppingList
import com.example.cravewise.domain.ShoppingListView
import com.example.cravewise.domain.model.Ingredient
import com.example.cravewise.domain.model.RecipeSummary
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/** A snackbar offering to undo the last destructive action. [id] tells repeated prompts apart. */
data class UndoPrompt(val id: Long, val message: String)

data class ShoppingUiState(
    val isLoading: Boolean = true,
    val query: String = "",
    /** Catalog matches for [query], skipping what's already on the to-buy list. */
    val suggestions: List<Ingredient> = emptyList(),
    /** Free-text fallback offered when [query] names no catalog ingredient exactly. */
    val customSuggestion: String? = null,
    val list: ShoppingListView = ShoppingListView(),
    /** Recipes on the list that still fit the food profile, in list order. */
    val recipes: List<RecipeSummary> = emptyList(),
    val undo: UndoPrompt? = null,
) {
    val shareText: String get() = ShoppingList.shareText(list)
}

private data class ShoppingCatalog(
    val ingredients: List<Ingredient>,
    val recipes: Map<String, RecipeSummary>,
) {
    val byId: Map<String, Ingredient> = ingredients.associateBy { it.id }
}

@HiltViewModel
class ShoppingViewModel @Inject constructor(
    recipes: RecipeRepository,
    private val shopping: ShoppingRepository,
    private val savedState: SavedStateHandle,
    gateSource: ProfileGateSource,
) : ViewModel() {

    private val query = savedState.getStateFlow(KEY_QUERY, "")
    private val undoPrompt = MutableStateFlow<UndoPrompt?>(null)
    private var pendingUndo: ShoppingUndo? = null
    private var undoCounter = 0L

    private val catalog = combine(recipes.observeIngredients(), recipes.observeRecipeSummaries()) { ingredients, summaries ->
        ShoppingCatalog(ingredients, summaries.associateBy { it.id })
    }

    private val list = combine(shopping.observeEntries(), catalog, gateSource.observe()) { entries, c, gate ->
        val view = ShoppingList.organize(entries, c.byId)
        // Profile hard filter, applied last. The items stay: they're groceries the user chose.
        val onList = view.recipeIds.mapNotNull(c.recipes::get)
        view to gate.recipes(onList)
    }

    val uiState: StateFlow<ShoppingUiState> =
        combine(list, catalog, query, undoPrompt) { (view, visibleRecipes), c, q, undo ->
            val toBuy = view.sections.flatMapTo(HashSet()) { s -> s.rows.mapNotNull { it.ingredientId } }
            val exact = IngredientSearch.exactMatch(q, c.ingredients)
            ShoppingUiState(
                isLoading = false,
                query = q,
                suggestions = IngredientSearch.suggest(q, c.ingredients, exclude = toBuy),
                customSuggestion = q.trim().takeIf { it.isNotEmpty() && exact == null },
                list = view,
                recipes = visibleRecipes,
                undo = undo,
            )
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), ShoppingUiState())

    fun onQueryChange(text: String) {
        savedState[KEY_QUERY] = text
    }

    /** Keyboard "Done": exact name/synonym, else the top suggestion, else a free-text item. */
    fun submitQuery() {
        val state = uiState.value
        val exact = IngredientSearch.exactMatch(state.query, state.suggestions)
        when {
            exact != null -> addIngredient(exact)
            state.suggestions.isNotEmpty() -> addIngredient(state.suggestions.first())
            state.customSuggestion != null -> addCustom(state.customSuggestion)
        }
    }

    fun addIngredient(ingredient: Ingredient) {
        savedState[KEY_QUERY] = ""
        viewModelScope.launch { shopping.addIngredient(ingredient) }
    }

    fun addCustom(name: String) {
        savedState[KEY_QUERY] = ""
        viewModelScope.launch { shopping.addCustom(name) }
    }

    fun setChecked(key: String, checked: Boolean) {
        viewModelScope.launch { shopping.setChecked(key, checked) }
    }

    fun delete(key: String, name: String) = withUndo("Removed $name") { shopping.delete(key) }

    fun removeRecipe(recipe: RecipeSummary) =
        withUndo("Removed ingredients for ${recipe.title}") { shopping.removeRecipe(recipe.id) }

    fun finishShopping() = withUndo({ undo ->
        when (undo.pantryCount) {
            0 -> "Basket cleared. Happy cooking!"
            1 -> "Nice haul! 1 ingredient added to My Kitchen"
            else -> "Nice haul! ${undo.pantryCount} ingredients added to My Kitchen"
        }
    }) { shopping.finishShopping() }

    fun clearList() = withUndo("Shopping list cleared") { shopping.clear() }

    fun undo() {
        val undo = pendingUndo ?: return
        pendingUndo = null
        undoPrompt.value = null
        viewModelScope.launch { shopping.undo(undo) }
    }

    /** The snackbar for [id] went away without Undo. */
    fun undoDismissed(id: Long) {
        if (undoPrompt.value?.id != id) return
        pendingUndo = null
        undoPrompt.value = null
    }

    private fun withUndo(message: String, action: suspend () -> ShoppingUndo) = withUndo({ message }, action)

    private fun withUndo(message: (ShoppingUndo) -> String, action: suspend () -> ShoppingUndo) {
        viewModelScope.launch {
            val undo = action()
            if (undo.isEmpty) return@launch
            pendingUndo = undo
            undoPrompt.value = UndoPrompt(++undoCounter, message(undo))
        }
    }

    private companion object {
        const val KEY_QUERY = "query"
    }
}
