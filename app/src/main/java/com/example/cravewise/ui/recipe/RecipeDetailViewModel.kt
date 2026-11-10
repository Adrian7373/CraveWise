package com.example.cravewise.ui.recipe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cravewise.data.repository.FavoritesRepository
import com.example.cravewise.data.repository.RecipeRepository
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
)

@HiltViewModel(assistedFactory = RecipeDetailViewModel.Factory::class)
class RecipeDetailViewModel @AssistedInject constructor(
    @Assisted private val recipeId: String,
    recipes: RecipeRepository,
    private val favorites: FavoritesRepository,
) : ViewModel() {

    val uiState: StateFlow<RecipeDetailUiState> = combine(
        recipes.observeRecipe(recipeId),
        favorites.observeFavoriteIds().map { recipeId in it }.distinctUntilChanged(),
    ) { recipe, isFavorite ->
        RecipeDetailUiState(isLoading = false, recipe = recipe, isFavorite = isFavorite)
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
