package com.example.cravewise.ui.recipe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cravewise.data.repository.FavoritesRepository
import com.example.cravewise.data.repository.PantryRepository
import com.example.cravewise.data.repository.ProfileRepository
import com.example.cravewise.data.repository.RecipeRepository
import com.example.cravewise.domain.ProfileConflict
import com.example.cravewise.domain.ProfileFilter
import com.example.cravewise.domain.model.Pantry
import com.example.cravewise.domain.model.Recipe
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class RecipeDetailUiState(
    val isLoading: Boolean = true,
    /** Null once loaded means the id isn't in the catalog (e.g. removed by a dataset update). */
    val recipe: Recipe? = null,
    val isFavorite: Boolean = false,
    /** Drives the have/missing marks on ingredients. Marks are hidden while the pantry is empty. */
    val pantry: Pantry = Pantry(),
    /** Why this recipe breaks the food profile; empty if it fits. */
    val conflicts: List<ProfileConflict> = emptyList(),
)

@HiltViewModel(assistedFactory = RecipeDetailViewModel.Factory::class)
class RecipeDetailViewModel @AssistedInject constructor(
    @Assisted private val recipeId: String,
    recipes: RecipeRepository,
    private val favorites: FavoritesRepository,
    pantry: PantryRepository,
    profiles: ProfileRepository,
) : ViewModel() {

    val uiState: StateFlow<RecipeDetailUiState> = combine(
        recipes.observeRecipe(recipeId),
        favorites.observeFavoriteIds().map { recipeId in it }.distinctUntilChanged(),
        pantry.observePantry(),
        profiles.observeProfile(),
    ) { recipe, isFavorite, pantryState, profile ->
        RecipeDetailUiState(
            isLoading = false,
            recipe = recipe,
            isFavorite = isFavorite,
            pantry = pantryState,
            conflicts = recipe?.let { r ->
                ProfileFilter.conflicts(r.summary, r.ingredients.map { it.ingredient.id }, profile)
            }.orEmpty(),
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), RecipeDetailUiState())

    fun toggleFavorite() {
        val makeFavorite = !uiState.value.isFavorite
        viewModelScope.launch { favorites.setFavorite(recipeId, makeFavorite) }
    }

    @AssistedFactory
    interface Factory {
        fun create(recipeId: String): RecipeDetailViewModel
    }
}
