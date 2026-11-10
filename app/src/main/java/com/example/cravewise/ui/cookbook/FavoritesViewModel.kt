package com.example.cravewise.ui.cookbook

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cravewise.data.repository.FavoritesRepository
import com.example.cravewise.data.repository.ProfileGateSource
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
    /** Newest first, profile hard filters applied. */
    val favorites: List<RecipeSummary> = emptyList(),
    /** There are favorites, but the profile hides every one of them. */
    val hiddenByProfile: Boolean = false,
)

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    recipes: RecipeRepository,
    favorites: FavoritesRepository,
    gateSource: ProfileGateSource,
) : ViewModel() {

    val uiState: StateFlow<FavoritesUiState> =
        combine(recipes.observeRecipeSummaries(), favorites.observeFavoriteIds(), gateSource.observe()) { all, ids, gate ->
            val saved = Cookbook.favorites(all, ids)
            val visible = gate.recipes(saved)
            FavoritesUiState(
                isLoading = false,
                favorites = visible,
                hiddenByProfile = visible.isEmpty() && saved.isNotEmpty(),
            )
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), FavoritesUiState())
}
