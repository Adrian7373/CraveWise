package com.example.cravewise.ui.cookbook

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cravewise.data.repository.RecipeRepository
import com.example.cravewise.domain.BrowseFilter
import com.example.cravewise.domain.Cookbook
import com.example.cravewise.domain.model.Diet
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.model.RecipeSummary
import com.example.cravewise.navigation.BrowseRoute
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

data class BrowseUiState(
    val isLoading: Boolean = true,
    val filter: BrowseFilter = BrowseFilter(),
    val results: List<RecipeSummary> = emptyList(),
    /** Filter options that have at least one recipe in the catalog. */
    val mealTypes: List<MealType> = emptyList(),
    val cuisines: List<String> = emptyList(),
) {
    /** "Italian mains", "Desserts", "Thai", or "Cookbook" when unfiltered by category. */
    val title: String
        get() {
            val meal = filter.mealType?.let(::plural)
            val cuisine = filter.cuisine
            return when {
                cuisine != null && meal != null -> "$cuisine ${meal.lowercase()}"
                cuisine != null -> cuisine
                meal != null -> meal
                else -> "Cookbook"
            }
        }

    private fun plural(type: MealType): String = when (type) {
        MealType.Breakfast -> "Breakfast"
        else -> "${type.label}s"
    }
}

@HiltViewModel(assistedFactory = BrowseViewModel.Factory::class)
class BrowseViewModel @AssistedInject constructor(
    @Assisted route: BrowseRoute,
    repository: RecipeRepository,
) : ViewModel() {

    private val filter = MutableStateFlow(BrowseFilter(mealType = route.mealType, cuisine = route.cuisine))

    val uiState: StateFlow<BrowseUiState> = combine(repository.observeRecipeSummaries(), filter) { all, f ->
        BrowseUiState(
            isLoading = false,
            filter = f,
            results = Cookbook.filter(all, f),
            mealTypes = Cookbook.mealTypes(all).map { it.value },
            cuisines = Cookbook.cuisines(all).map { it.value },
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), BrowseUiState(filter = filter.value))

    fun setMealType(type: MealType?) = filter.update { it.copy(mealType = type) }

    fun setCuisine(cuisine: String?) = filter.update { it.copy(cuisine = cuisine) }

    fun toggleDiet(diet: Diet) = filter.update {
        it.copy(diets = if (diet in it.diets) it.diets - diet else it.diets + diet)
    }

    fun toggleQuick() = filter.update {
        it.copy(maxMinutes = if (it.maxMinutes == null) BrowseFilter.QUICK_MINUTES else null)
    }

    fun clearFilters() = filter.update { BrowseFilter() }

    @AssistedFactory
    interface Factory {
        fun create(route: BrowseRoute): BrowseViewModel
    }
}
