package com.example.cravewise.domain

import com.example.cravewise.domain.model.Diet
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.model.RecipeSummary

/**
 * Cookbook browse filters. Every set field is a hard filter: a recipe must satisfy all of them.
 * Diets come from rule-derived tags (DietRules), so they are safe to filter on.
 */
data class BrowseFilter(
    val mealType: MealType? = null,
    val cuisine: String? = null,
    val diets: Set<Diet> = emptySet(),
    val maxMinutes: Int? = null,
) {
    val isEmpty: Boolean get() = this == BrowseFilter()

    companion object {
        const val QUICK_MINUTES = 30
    }
}

/** A browse category with how many recipes it holds, for Home's "browse by" chips. */
data class CategoryCount<T>(val value: T, val count: Int)

object Cookbook {

    /** Applies [filter], keeping the input order (title-sorted from the repository). */
    fun filter(recipes: List<RecipeSummary>, filter: BrowseFilter): List<RecipeSummary> =
        recipes.filter { r ->
            (filter.mealType == null || filter.mealType in r.mealTypes) &&
                (filter.cuisine == null || r.cuisine.equals(filter.cuisine, ignoreCase = true)) &&
                r.diets.containsAll(filter.diets) &&
                (filter.maxMinutes == null || r.totalMinutes <= filter.maxMinutes)
        }

    /** Cuisines by recipe count (desc), ties by name. */
    fun cuisines(recipes: List<RecipeSummary>): List<CategoryCount<String>> =
        recipes.groupingBy { it.cuisine }.eachCount()
            .map { (cuisine, count) -> CategoryCount(cuisine, count) }
            .sortedWith(compareByDescending<CategoryCount<String>> { it.count }.thenBy { it.value })

    /** Meal types that have at least one recipe, in declaration order. */
    fun mealTypes(recipes: List<RecipeSummary>): List<CategoryCount<MealType>> =
        MealType.entries.mapNotNull { type ->
            recipes.count { type in it.mealTypes }.takeIf { it > 0 }?.let { CategoryCount(type, it) }
        }

    /** Quick, non-dessert picks for Home. */
    fun quickPicks(recipes: List<RecipeSummary>, count: Int): List<RecipeSummary> =
        recipes.filter { MealType.Dessert !in it.mealTypes }
            .sortedWith(compareBy({ it.totalMinutes }, { it.title }))
            .take(count)

    /** Resolves favorite ids (newest first) against the catalog, dropping ids no longer in it. */
    fun favorites(recipes: List<RecipeSummary>, favoriteIds: List<String>): List<RecipeSummary> {
        val byId = recipes.associateBy { it.id }
        return favoriteIds.mapNotNull(byId::get)
    }
}
