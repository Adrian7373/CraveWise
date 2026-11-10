package com.example.cravewise.ui.cookbook

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cravewise.data.repository.FavoritesRepository
import com.example.cravewise.data.repository.RecipeRepository
import com.example.cravewise.domain.Cookbook
import com.example.cravewise.domain.model.RecipeSummary
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

data class FavoritesUiState(
    val isLoading: Boolean = true,
    /** Newest first. */
    val favorites: List<RecipeSummary> = emptyList(),
)

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    recipes: RecipeRepository,
    favorites: FavoritesRepository,
) : ViewModel() {

    val uiState: StateFlow<FavoritesUiState> =
        combine(recipes.observeRecipeSummaries(), favorites.observeFavoriteIds()) { all, ids ->
            FavoritesUiState(isLoading = false, favorites = Cookbook.favorites(all, ids))
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), FavoritesUiState())
}
