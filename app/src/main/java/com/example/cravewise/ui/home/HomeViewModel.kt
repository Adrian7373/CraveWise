package com.example.cravewise.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cravewise.data.repository.RecipeRepository
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.model.RecipeSummary
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

data class HomeUiState(
    val isLoading: Boolean = true,
    val featured: List<RecipeSummary> = emptyList(),
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: RecipeRepository,
) : ViewModel() {

    val uiState: StateFlow<HomeUiState> = repository.observeRecipeSummaries()
        .map { recipes -> HomeUiState(isLoading = false, featured = pickFeatured(recipes)) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), HomeUiState())

    private companion object {
        const val FEATURED_COUNT = 6

        /** Quick, non-dessert picks first. Full browsing arrives in Phase 2. */
        fun pickFeatured(recipes: List<RecipeSummary>): List<RecipeSummary> =
            recipes.filter { MealType.Dessert !in it.mealTypes }
                .sortedWith(compareBy({ it.totalMinutes }, { it.title }))
                .take(FEATURED_COUNT)
    }
}
