package com.example.cravewise.ui.profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cravewise.data.repository.ProfileRepository
import com.example.cravewise.data.repository.RecipeRepository
import com.example.cravewise.domain.IngredientSearch
import com.example.cravewise.domain.model.Allergen
import com.example.cravewise.domain.model.Diet
import com.example.cravewise.domain.model.FoodProfile
import com.example.cravewise.domain.model.Ingredient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ProfileUiState(
    val isLoading: Boolean = true,
    val profile: FoodProfile = FoodProfile(),
    /** Hated ingredients still in the catalog, newest first. */
    val hated: List<Ingredient> = emptyList(),
    val query: String = "",
    /** Type-ahead matches for [query], excluding ones already hated. */
    val suggestions: List<Ingredient> = emptyList(),
)

/** Edits the food profile. Shared by onboarding and the Profile tab; every change saves at once. */
@HiltViewModel
class ProfileViewModel @Inject constructor(
    recipes: RecipeRepository,
    private val profiles: ProfileRepository,
    private val savedState: SavedStateHandle,
) : ViewModel() {

    private val query = savedState.getStateFlow(KEY_QUERY, "")

    val uiState: StateFlow<ProfileUiState> = combine(
        recipes.observeIngredients(),
        profiles.observeProfile(),
        profiles.observeHatedIngredientIds(),
        query,
    ) { ingredients, profile, hatedIds, q ->
        val byId = ingredients.associateBy { it.id }
        ProfileUiState(
            isLoading = false,
            profile = profile,
            hated = hatedIds.mapNotNull(byId::get),
            query = q,
            suggestions = IngredientSearch.suggest(q, ingredients, exclude = profile.hatedIngredientIds),
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), ProfileUiState())

    fun toggleAllergen(allergen: Allergen) {
        val avoid = allergen !in uiState.value.profile.allergens
        viewModelScope.launch { profiles.setAllergen(allergen, avoid) }
    }

    fun toggleDiet(diet: Diet) {
        val follow = diet !in uiState.value.profile.diets
        viewModelScope.launch { profiles.setDiet(diet, follow) }
    }

    fun setMaxSpice(level: Int) {
        viewModelScope.launch { profiles.setMaxSpice(level) }
    }

    fun onQueryChange(text: String) {
        savedState[KEY_QUERY] = text
    }

    /** Keyboard "Done": add the exact name/synonym match, else the top suggestion. */
    fun submitQuery() {
        val state = uiState.value
        val pick = IngredientSearch.exactMatch(state.query, state.suggestions) ?: state.suggestions.firstOrNull() ?: return
        addHated(pick.id)
    }

    fun addHated(ingredientId: String) {
        savedState[KEY_QUERY] = ""
        viewModelScope.launch { profiles.addHatedIngredient(ingredientId) }
    }

    fun removeHated(ingredientId: String) {
        viewModelScope.launch { profiles.removeHatedIngredient(ingredientId) }
    }

    /** Finish or skip onboarding. Whatever was set so far is already saved. */
    fun completeOnboarding() {
        viewModelScope.launch { profiles.setOnboardingComplete() }
    }

    private companion object {
        const val KEY_QUERY = "hated_query"
    }
}
