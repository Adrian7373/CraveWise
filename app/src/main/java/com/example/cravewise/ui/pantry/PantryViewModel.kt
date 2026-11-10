package com.example.cravewise.ui.pantry

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cravewise.data.repository.PantryRepository
import com.example.cravewise.data.repository.ProfileGateSource
import com.example.cravewise.data.repository.RecipeRepository
import com.example.cravewise.domain.IngredientSearch
import com.example.cravewise.domain.PantryMatcher
import com.example.cravewise.domain.PantryResults
import com.example.cravewise.domain.model.Ingredient
import com.example.cravewise.domain.model.Pantry
import com.example.cravewise.domain.model.RecipeSummary
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PantryUiState(
    val isLoading: Boolean = true,
    val query: String = "",
    /** Type-ahead matches for [query], excluding what's already listed. */
    val suggestions: List<Ingredient> = emptyList(),
    /** Listed ingredients that still exist in the catalog, newest first. */
    val pantryItems: List<Ingredient> = emptyList(),
    val assumeStaples: Boolean = true,
    /** Catalog staples (salt, oil, ...), shown next to the "assume basics" switch. */
    val staples: List<Ingredient> = emptyList(),
    /** Popular non-staples not yet listed. */
    val quickAdd: List<Ingredient> = emptyList(),
    val results: PantryResults = PantryResults(),
    /** Recipes matched the pantry but the profile hid all of them. */
    val hiddenByProfile: Boolean = false,
) {
    val hasPantry: Boolean get() = pantryItems.isNotEmpty()
}

/** Catalog inputs to matching; changes only on a re-seed. */
private data class PantryCatalog(
    val recipes: List<RecipeSummary>,
    val recipeIngredients: Map<String, List<String>>,
    val ingredients: List<Ingredient>,
) {
    val byId: Map<String, Ingredient> = ingredients.associateBy { it.id }
    val staples: List<Ingredient> = ingredients.filter { it.isPantryStaple }
}

@HiltViewModel
class PantryViewModel @Inject constructor(
    recipes: RecipeRepository,
    private val pantry: PantryRepository,
    private val savedState: SavedStateHandle,
    gateSource: ProfileGateSource,
) : ViewModel() {

    private val query = savedState.getStateFlow(KEY_QUERY, "")

    private val catalog = combine(
        recipes.observeRecipeSummaries(),
        recipes.observeRecipeIngredientIds(),
        recipes.observeIngredients(),
        ::PantryCatalog,
    )

    private val pantryState = pantry.observePantry()

    /**
     * Matching doesn't depend on the query, so typing never re-runs it. Profile hard filters are
     * applied to the ranked buckets afterwards (never folded into the score).
     */
    private val results = combine(catalog, pantryState, gateSource.observe()) { c, p, gate ->
        val ranked = PantryMatcher.match(c.recipes, c.recipeIngredients, c.byId, p)
        val safe = PantryResults(
            cookNow = gate.filter(ranked.cookNow) { it.recipe },
            almostThere = gate.filter(ranked.almostThere) { it.recipe },
            needsShopping = gate.filter(ranked.needsShopping) { it.recipe },
        )
        safe to (safe.isEmpty && !ranked.isEmpty)
    }

    val uiState: StateFlow<PantryUiState> =
        combine(catalog, pantryState, results, query) { c, p, (results, hidden), q ->
            buildState(c, p, results, q).copy(hiddenByProfile = hidden)
        }
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), PantryUiState())

    fun onQueryChange(text: String) {
        savedState[KEY_QUERY] = text
    }

    /** Keyboard "Done": add the exact name/synonym match, else the top suggestion. */
    fun submitQuery() {
        val state = uiState.value
        val listed = state.pantryItems.mapTo(HashSet()) { it.id }
        val pick = state.suggestions
            .let { IngredientSearch.exactMatch(state.query, it) ?: it.firstOrNull() }
            ?.takeIf { it.id !in listed }
            ?: return
        add(pick.id)
    }

    fun add(ingredientId: String) {
        savedState[KEY_QUERY] = ""
        viewModelScope.launch { pantry.add(ingredientId) }
    }

    fun remove(ingredientId: String) {
        viewModelScope.launch { pantry.remove(ingredientId) }
    }

    fun clearPantry() {
        viewModelScope.launch { pantry.clear() }
    }

    fun setAssumeStaples(assume: Boolean) {
        viewModelScope.launch { pantry.setAssumeStaples(assume) }
    }

    private fun buildState(c: PantryCatalog, p: Pantry, results: PantryResults, q: String): PantryUiState {
        val listed = p.ingredientIds.mapNotNull(c.byId::get)
        val listedIds = listed.mapTo(HashSet()) { it.id }
        return PantryUiState(
            isLoading = false,
            query = q,
            suggestions = IngredientSearch.suggest(q, c.ingredients, exclude = listedIds),
            pantryItems = listed,
            assumeStaples = p.assumeStaples,
            staples = c.staples,
            quickAdd = PantryMatcher.popularIngredients(c.recipeIngredients, c.byId, p, QUICK_ADD_COUNT),
            results = results,
        )
    }

    private companion object {
        const val KEY_QUERY = "query"
        const val QUICK_ADD_COUNT = 12
    }
}
