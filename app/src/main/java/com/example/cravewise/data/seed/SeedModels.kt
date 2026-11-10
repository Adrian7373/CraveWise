package com.example.cravewise.data.seed

import com.example.cravewise.domain.model.Aisle
import com.example.cravewise.domain.model.Allergen
import com.example.cravewise.domain.model.ContainsFlag
import com.example.cravewise.domain.model.Difficulty
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.model.MeasureUnit
import com.example.cravewise.domain.model.Mood
import com.example.cravewise.domain.model.Protein
import com.example.cravewise.domain.model.Texture
import kotlinx.serialization.Serializable

/*
 * Wire format of the JSON files in assets/seed, produced by tools/dataset.py `build`. Holds raw facts only:
 * derived tags (allergens, diets, proteins) are computed on import by DietRules.
 */

/** Small file read on every launch to decide whether the catalog needs re-seeding. */
@Serializable
data class SeedManifest(val version: Int, val file: String)

@Serializable
data class SeedDataset(
    val version: Int,
    val ingredients: List<SeedIngredient>,
    val recipes: List<SeedRecipe>,
)

@Serializable
data class SeedIngredient(
    val id: String,
    val name: String,
    val synonyms: List<String> = emptyList(),
    val aisle: Aisle,
    val allergens: Set<Allergen> = emptySet(),
    val contains: Set<ContainsFlag> = emptySet(),
    val protein: Protein? = null,
    val isPantryStaple: Boolean,
)

@Serializable
data class SeedFlavor(
    val salty: Int,
    val sweet: Int,
    val sour: Int,
    val bitter: Int,
    val umami: Int,
    val spicy: Int,
)

@Serializable
data class SeedRecipeIngredient(
    val ingredientId: String,
    val rawName: String,
    val rawMeasure: String,
    val amount: Double? = null,
    val amountMax: Double? = null,
    val unit: MeasureUnit? = null,
    val note: String? = null,
)

@Serializable
data class SeedSource(
    val name: String,
    val sourceId: String,
    val url: String,
    val originalUrl: String? = null,
)

@Serializable
data class SeedRecipe(
    val id: String,
    val title: String,
    val cuisine: String,
    val mealTypes: Set<MealType>,
    val flavor: SeedFlavor,
    val textures: Set<Texture> = emptySet(),
    val moods: Set<Mood> = emptySet(),
    val servings: Int,
    val prepMinutes: Int,
    val cookMinutes: Int,
    val difficulty: Difficulty,
    val ingredients: List<SeedRecipeIngredient>,
    val steps: List<String>,
    val imageUrl: String? = null,
    val source: SeedSource,
)
