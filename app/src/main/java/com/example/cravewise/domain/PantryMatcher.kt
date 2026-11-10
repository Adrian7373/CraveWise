package com.example.cravewise.domain

import com.example.cravewise.domain.model.Ingredient
import com.example.cravewise.domain.model.Pantry
import com.example.cravewise.domain.model.RecipeSummary

/** Where a pantry match lands in the results. */
enum class MatchBucket {
    /** Nothing missing. */
    CookNow,

    /** 1..[PantryMatcher.ALMOST_THERE_MAX_MISSING] ingredients missing. */
    AlmostThere,

    /** More missing than that, but still uses something from the pantry. */
    NeedsShopping,
}

/**
 * One recipe scored against the pantry. [have] and [missing] follow the recipe's ingredient order,
 * one entry per distinct ingredient (a recipe listing salt twice counts it once).
 */
data class PantryMatch(
    val recipe: RecipeSummary,
    val have: List<Ingredient>,
    val missing: List<Ingredient>,
    /** How many of the user's explicitly listed ingredients the recipe uses. Assumed staples don't count. */
    val usesFromPantry: Int,
) {
    val total: Int get() = have.size + missing.size

    /** Floored, so a recipe with anything missing never reads as 100%. */
    val matchPercent: Int get() = if (total == 0) 0 else have.size * 100 / total

    val bucket: MatchBucket
        get() = when {
            missing.isEmpty() -> MatchBucket.CookNow
            missing.size <= PantryMatcher.ALMOST_THERE_MAX_MISSING -> MatchBucket.AlmostThere
            else -> MatchBucket.NeedsShopping
        }
}

data class PantryResults(
    val cookNow: List<PantryMatch> = emptyList(),
    val almostThere: List<PantryMatch> = emptyList(),
    val needsShopping: List<PantryMatch> = emptyList(),
) {
    val total: Int get() = cookNow.size + almostThere.size + needsShopping.size
    val isEmpty: Boolean get() = total == 0
}

/**
 * Pantry matching. Compares canonical ingredient ids only, never free text.
 *
 * Profile hard filters (allergies, diets, hated ingredients; Phase 4) must be applied to the
 * output of [match], after ranking, never folded into the score.
 */
object PantryMatcher {

    const val ALMOST_THERE_MAX_MISSING = 2

    /**
     * Scores every recipe that uses at least one ingredient the user listed and splits them into
     * buckets. An empty pantry gives empty results: with only assumed staples nothing is "yours".
     *
     * @param recipeIngredients recipe id → ingredient ids in recipe order (duplicates allowed).
     * @param ingredients the ingredient catalog by id. Unknown ids are ignored.
     */
    fun match(
        recipes: List<RecipeSummary>,
        recipeIngredients: Map<String, List<String>>,
        ingredients: Map<String, Ingredient>,
        pantry: Pantry,
    ): PantryResults {
        if (pantry.isEmpty) return PantryResults()
        val matches = recipes.mapNotNull { recipe ->
            val ids = recipeIngredients[recipe.id] ?: return@mapNotNull null
            matchRecipe(recipe, ids, ingredients, pantry).takeIf { it.usesFromPantry > 0 && it.total > 0 }
        }
        val byBucket = matches.groupBy { it.bucket }
        fun ranked(bucket: MatchBucket) = byBucket[bucket].orEmpty().sortedWith(RANKING)
        return PantryResults(
            cookNow = ranked(MatchBucket.CookNow),
            almostThere = ranked(MatchBucket.AlmostThere),
            needsShopping = ranked(MatchBucket.NeedsShopping),
        )
    }

    /** Scores a single recipe, whether or not it uses anything from the pantry. */
    fun matchRecipe(
        recipe: RecipeSummary,
        ingredientIds: List<String>,
        ingredients: Map<String, Ingredient>,
        pantry: Pantry,
    ): PantryMatch {
        val distinct = ingredientIds.distinct().mapNotNull(ingredients::get)
        val (have, missing) = distinct.partition(pantry::owns)
        return PantryMatch(
            recipe = recipe,
            have = have,
            missing = missing,
            usesFromPantry = distinct.count { pantry.contains(it.id) },
        )
    }

    /**
     * Quick-add suggestions: the non-staple ingredients used by the most recipes, skipping what
     * the pantry already lists. Ties sort by name.
     */
    fun popularIngredients(
        recipeIngredients: Map<String, List<String>>,
        ingredients: Map<String, Ingredient>,
        pantry: Pantry,
        limit: Int,
    ): List<Ingredient> =
        recipeIngredients.values
            .flatMap { it.distinct() }
            .groupingBy { it }
            .eachCount()
            .mapNotNull { (id, count) -> ingredients[id]?.let { it to count } }
            .filter { (ingredient, _) -> !ingredient.isPantryStaple && !pantry.contains(ingredient.id) }
            .sortedWith(compareByDescending<Pair<Ingredient, Int>> { it.second }.thenBy { it.first.name.lowercase() })
            .take(limit)
            .map { it.first }

    /** Fewest missing, then uses the most of your stuff, then best coverage, then title. */
    private val RANKING: Comparator<PantryMatch> =
        compareBy<PantryMatch> { it.missing.size }
            .thenByDescending { it.usesFromPantry }
            .thenByDescending { it.matchPercent }
            .thenBy { it.recipe.title.lowercase() }
}
