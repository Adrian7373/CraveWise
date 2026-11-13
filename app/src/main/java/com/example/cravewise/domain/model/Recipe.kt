package com.example.cravewise.domain.model

/** Six flavor axes, each 0–5. `spicy` doubles as the recipe's heat level (SpiceMeter). */
data class FlavorScores(
    val salty: Int,
    val sweet: Int,
    val sour: Int,
    val bitter: Int,
    val umami: Int,
    val spicy: Int,
)

/**
 * Nutrients per 100 g from USDA FoodData Central (SR Legacy), matched at build time by
 * tools/seedgen. Energy in kcal, sodium in mg, the rest in grams.
 */
data class NutritionPer100g(
    val fdcId: Int,
    val kcal: Double,
    val protein: Double,
    val carbs: Double,
    val fat: Double,
    val fiber: Double,
    val sugar: Double,
    val sodium: Double,
)

data class Ingredient(
    val id: String,
    val name: String,
    val aisle: Aisle,
    val allergens: Set<Allergen>,
    val isPantryStaple: Boolean,
    /** Normalized (lower-case) name + synonyms, for the pantry picker. Empty where not loaded. */
    val synonyms: Set<String> = emptySet(),
    /** Main protein this ingredient provides (meat, fish, egg, legumes...), if any. */
    val protein: Protein? = null,
    /** Null when the ingredient has no sensible FDC match. */
    val nutrition: NutritionPer100g? = null,
)

/**
 * What the user says they have. [ingredientIds] is newest first. With [assumeStaples] on,
 * ingredients flagged `isPantryStaple` (salt, oil, ...) count as owned without being listed.
 */
data class Pantry(
    val ingredientIds: List<String> = emptyList(),
    val assumeStaples: Boolean = true,
) {
    private val idSet: Set<String> = ingredientIds.toHashSet()

    /** Explicitly listed by the user (staples not included). */
    fun contains(ingredientId: String): Boolean = ingredientId in idSet

    fun owns(ingredient: Ingredient): Boolean =
        ingredient.id in idSet || (assumeStaples && ingredient.isPantryStaple)

    val isEmpty: Boolean get() = ingredientIds.isEmpty()
}

/**
 * One ingredient line. Show [rawMeasure] (original units); [amount]/[unit] are the parsed form
 * for scaling and shopping-list merging and may be null when the source text isn't numeric.
 */
data class RecipeIngredientLine(
    val ingredient: Ingredient,
    val rawName: String,
    val rawMeasure: String,
    val amount: Double?,
    val amountMax: Double?,
    val unit: MeasureUnit?,
    val note: String?,
    /**
     * Weight of this line at the recipe's own servings, worked out at build time. 0 for
     * "to taste"/garnish lines, null when it couldn't be weighed (then it doesn't count towards
     * nutrition coverage).
     */
    val grams: Double? = null,
)

/** Lightweight row for lists (browse, pantry results, search). */
data class RecipeSummary(
    val id: String,
    val title: String,
    val cuisine: String,
    val totalMinutes: Int,
    val difficulty: Difficulty,
    val flavor: FlavorScores,
    val mealTypes: Set<MealType>,
    val proteins: Set<Protein>,
    /** Derived from ingredients at import (DietRules). Safe to use as a hard filter. */
    val diets: Set<Diet>,
    /**
     * Derived from ingredients at import (DietRules). Safe to use as a hard filter. Required on
     * purpose: a summary built without allergens must not silently pass the profile filter.
     */
    val allergens: Set<Allergen>,
    val moods: Set<Mood> = emptySet(),
    val textures: Set<Texture> = emptySet(),
) {
    val spiceLevel: Int get() = flavor.spicy
}

data class Recipe(
    val summary: RecipeSummary,
    val servings: Int,
    val prepMinutes: Int,
    val cookMinutes: Int,
    val textures: Set<Texture>,
    val ingredients: List<RecipeIngredientLine>,
    val steps: List<String>,
    val imageUrl: String?,
    val sourceName: String,
    val sourceUrl: String,
) {
    val id: String get() = summary.id
    val title: String get() = summary.title
    val diets: Set<Diet> get() = summary.diets
    val allergens: Set<Allergen> get() = summary.allergens
    val moods: Set<Mood> get() = summary.moods
}
