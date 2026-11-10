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

data class Ingredient(
    val id: String,
    val name: String,
    val aisle: Aisle,
    val allergens: Set<Allergen>,
    val isPantryStaple: Boolean,
)

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
) {
    val spiceLevel: Int get() = flavor.spicy
}

data class Recipe(
    val summary: RecipeSummary,
    val servings: Int,
    val prepMinutes: Int,
    val cookMinutes: Int,
    val textures: Set<Texture>,
    val moods: Set<Mood>,
    /** Derived from ingredients at import (DietRules). Safe to use as a hard filter. */
    val allergens: Set<Allergen>,
    val ingredients: List<RecipeIngredientLine>,
    val steps: List<String>,
    val imageUrl: String?,
    val sourceName: String,
    val sourceUrl: String,
) {
    val id: String get() = summary.id
    val title: String get() = summary.title
    val diets: Set<Diet> get() = summary.diets
}
