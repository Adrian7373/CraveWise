package com.example.cravewise.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cravewise.data.repository.FavoritesRepository
import com.example.cravewise.data.repository.ProfileGateSource
import com.example.cravewise.data.repository.RecipeRepository
import com.example.cravewise.domain.Cookbook
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.model.RecipeSummary
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

data class HomeUiState(
    val isLoading: Boolean = true,
    val featured: List<RecipeSummary> = emptyList(),
    /** Newest first, capped for the Home strip. */
    val favorites: List<RecipeSummary> = emptyList(),
    val mealTypes: List<MealType> = emptyList(),
    /** Most-stocked cuisines first, capped for Home. */
    val cuisines: List<String> = emptyList(),
    /** Spice tolerance was never set: Via nudges until it is. */
    val askSpice: Boolean = false,
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    recipes: RecipeRepository,
    favorites: FavoritesRepository,
    gateSource: ProfileGateSource,
) : ViewModel() {

    val uiState: StateFlow<HomeUiState> =
        combine(
            recipes.observeRecipeSummaries(),
            favorites.observeFavoriteIds(),
            gateSource.observe(),
        ) { all, favoriteIds, gate ->
            // Categories come from what the profile allows, so no chip leads to an empty screen.
            val allowed = gate.recipes(all)
            HomeUiState(
                isLoading = false,
                featured = gate.recipes(Cookbook.quickPicks(all, Int.MAX_VALUE)).take(FEATURED_COUNT),
                favorites = gate.recipes(Cookbook.favorites(all, favoriteIds)).take(FAVORITES_COUNT),
                mealTypes = Cookbook.mealTypes(allowed).map { it.value },
                cuisines = Cookbook.cuisines(allowed).take(CUISINE_COUNT).map { it.value },
                askSpice = !gate.profile.isSpiceSet,
            )
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), HomeUiState())

    private companion object {
        const val FEATURED_COUNT = 6
        const val FAVORITES_COUNT = 10
        const val CUISINE_COUNT = 10
    }
}
