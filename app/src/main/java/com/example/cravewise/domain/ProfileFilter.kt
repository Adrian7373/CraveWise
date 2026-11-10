package com.example.cravewise.domain

import com.example.cravewise.domain.model.Allergen
import com.example.cravewise.domain.model.Diet
import com.example.cravewise.domain.model.FoodProfile
import com.example.cravewise.domain.model.RecipeSummary

/** Why a recipe doesn't fit the profile. */
sealed interface ProfileConflict {
    data class ContainsAllergen(val allergen: Allergen) : ProfileConflict
    data class NotDiet(val diet: Diet) : ProfileConflict
    data class HatedIngredient(val ingredientId: String) : ProfileConflict
    data class TooSpicy(val level: Int, val max: Int) : ProfileConflict
}

/**
 * Profile hard filters (safety rule): allergens, diets, hated ingredients and max spice.
 *
 * Apply these in code as the LAST step, after any filtering, ranking, matching or search, and
 * never fold them into a score. Allergens and diets come from rule-derived tags (DietRules) and
 * hated ingredients are compared by canonical id, so no heuristics are involved.
 */
object ProfileFilter {

    /** Every conflict, in a stable order (allergens, diets, hated ingredients, spice). */
    fun conflicts(
        recipe: RecipeSummary,
        ingredientIds: Collection<String>,
        profile: FoodProfile,
    ): List<ProfileConflict> = buildList {
        recipe.allergens.filter { it in profile.allergens }.sortedBy { it.ordinal }
            .forEach { add(ProfileConflict.ContainsAllergen(it)) }
        profile.diets.filter { it !in recipe.diets }.sortedBy { it.ordinal }
            .forEach { add(ProfileConflict.NotDiet(it)) }
        ingredientIds.distinct().filter { it in profile.hatedIngredientIds }
            .forEach { add(ProfileConflict.HatedIngredient(it)) }
        val max = profile.maxSpice
        if (max != null && recipe.spiceLevel > max) add(ProfileConflict.TooSpicy(recipe.spiceLevel, max))
    }

    fun allows(recipe: RecipeSummary, ingredientIds: Collection<String>, profile: FoodProfile): Boolean =
        conflicts(recipe, ingredientIds, profile).isEmpty()

    /**
     * Keeps the items whose recipe fits [profile], preserving order. A recipe with no entry in
     * [recipeIngredients] is hidden when the profile has hated ingredients: we can't prove it's safe.
     */
    fun <T> apply(
        items: List<T>,
        recipeIngredients: Map<String, List<String>>,
        profile: FoodProfile,
        recipeOf: (T) -> RecipeSummary,
    ): List<T> {
        if (!profile.hasHardFilters) return items
        return items.filter { item ->
            val recipe = recipeOf(item)
            val ids = recipeIngredients[recipe.id]
            if (ids == null && profile.hatedIngredientIds.isNotEmpty()) return@filter false
            allows(recipe, ids.orEmpty(), profile)
        }
    }
}

/** A profile plus the data needed to check it, ready to gate any list of recipes. */
data class ProfileGate(
    val profile: FoodProfile = FoodProfile(),
    val recipeIngredients: Map<String, List<String>> = emptyMap(),
) {
    fun recipes(items: List<RecipeSummary>): List<RecipeSummary> =
        ProfileFilter.apply(items, recipeIngredients, profile) { it }

    fun <T> filter(items: List<T>, recipeOf: (T) -> RecipeSummary): List<T> =
        ProfileFilter.apply(items, recipeIngredients, profile, recipeOf)
}
