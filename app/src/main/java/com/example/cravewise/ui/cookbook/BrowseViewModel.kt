package com.example.cravewise.ui.cookbook

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cravewise.data.repository.ProfileGateSource
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
import kotlin.random.Random

data class BrowseUiState(
    val isLoading: Boolean = true,
    val filter: BrowseFilter = BrowseFilter(),
    val results: List<RecipeSummary> = emptyList(),
    /** Filter options that have at least one recipe in the catalog. */
    val mealTypes: List<MealType> = emptyList(),
    val cuisines: List<String> = emptyList(),
    /** Recipes matched the filters but the profile hid all of them. */
    val hiddenByProfile: Boolean = false,
    /**
     * Unfiltered only: a few picks per meal type (plus a quick shelf) instead of one A–Z wall of
     * the whole catalog. Empty once any filter is set; the grid of [results] shows then.
     */
    val shelves: List<BrowseShelf> = emptyList(),
    /** Back clears the filters (returns to the shelves) instead of leaving the screen. */
    val backClearsFilters: Boolean = false,
) {
    val showShelves: Boolean get() = shelves.isNotEmpty()

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

    companion object {
        fun plural(type: MealType): String = when (type) {
            MealType.Breakfast -> "Breakfast"
            else -> "${type.label}s"
        }
    }
}

/** A horizontal row of picks on the unfiltered cookbook; "See all" applies [filter]. */
data class BrowseShelf(
    val key: String,
    val title: String,
    val count: Int,
    val picks: List<RecipeSummary>,
    val filter: BrowseFilter,
)

@HiltViewModel(assistedFactory = BrowseViewModel.Factory::class)
class BrowseViewModel @AssistedInject constructor(
    @Assisted route: BrowseRoute,
    repository: RecipeRepository,
    gateSource: ProfileGateSource,
) : ViewModel() {

    private val initialFilter = BrowseFilter(mealType = route.mealType, cuisine = route.cuisine)
    private val filter = MutableStateFlow(initialFilter)

    val uiState: StateFlow<BrowseUiState> = combine(
        repository.observeRecipeSummaries(),
        filter,
        gateSource.observe(),
    ) { all, f, gate ->
        val matched = Cookbook.filter(all, f)
        val results = gate.recipes(matched) // profile hard filters last
        val allowed = gate.recipes(all)
        BrowseUiState(
            isLoading = false,
            filter = f,
            results = results,
            // Keep the active selection visible even if the profile hides all of its recipes.
            mealTypes = (Cookbook.mealTypes(allowed).map { it.value } + listOfNotNull(f.mealType))
                .distinct().sortedBy { it.ordinal },
            cuisines = Cookbook.cuisines(allowed).map { it.value }
                .let { if (f.cuisine != null && f.cuisine !in it) listOf(f.cuisine) + it else it },
            hiddenByProfile = results.isEmpty() && matched.isNotEmpty(),
            shelves = if (f.isEmpty) shelves(allowed) else emptyList(),
            backClearsFilters = initialFilter.isEmpty && !f.isEmpty,
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

    fun applyShelf(shelf: BrowseShelf) = filter.update { shelf.filter }

    /**
     * Picks rotate once a day (seeded by the day number) so the shelves feel fresh without
     * reshuffling while you scroll. Already profile-gated: built from the allowed recipes.
     */
    private fun shelves(allowed: List<RecipeSummary>): List<BrowseShelf> {
        val day = System.currentTimeMillis() / DAY_MS
        fun pick(key: String, title: String, f: BrowseFilter, salt: Int): BrowseShelf? {
            val all = Cookbook.filter(allowed, f)
            if (all.isEmpty()) return null
            return BrowseShelf(key, title, all.size, all.shuffled(Random(day * 31 + salt)).take(SHELF_SIZE), f)
        }
        val quick = pick("quick", "Ready in ${BrowseFilter.QUICK_MINUTES} minutes", BrowseFilter(maxMinutes = BrowseFilter.QUICK_MINUTES), -1)
        val byMeal = Cookbook.mealTypes(allowed).mapNotNull { (type, _) ->
            pick("meal-${type.name}", BrowseUiState.plural(type), BrowseFilter(mealType = type), type.ordinal)
        }
        return listOfNotNull(quick) + byMeal
    }

    @AssistedFactory
    interface Factory {
        fun create(route: BrowseRoute): BrowseViewModel
    }

    private companion object {
        const val SHELF_SIZE = 10
        const val DAY_MS = 86_400_000L
    }
}
