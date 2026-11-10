package com.example.cravewise.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.cravewise.domain.model.Aisle
import com.example.cravewise.domain.model.Allergen
import com.example.cravewise.domain.model.ContainsFlag
import com.example.cravewise.domain.model.Difficulty
import com.example.cravewise.domain.model.MeasureUnit
import com.example.cravewise.domain.model.Protein

/*
 * Catalog tables: owned by the seed dataset and wiped + re-inserted on every dataset version bump
 * (SeedImporter). User-owned tables added later (pantry, favorites, shopping list) must reference
 * recipes/ingredients by their stable string ids WITHOUT foreign keys or cascades into these
 * tables, so a re-seed never deletes user data.
 */

@Entity(tableName = "recipes")
data class RecipeEntity(
    @PrimaryKey val id: String,
    val title: String,
    val cuisine: String,
    val servings: Int,
    val prepMinutes: Int,
    val cookMinutes: Int,
    val difficulty: Difficulty,
    val salty: Int,
    val sweet: Int,
    val sour: Int,
    val bitter: Int,
    val umami: Int,
    val spicy: Int,
    val steps: List<String>,
    val imageUrl: String?,
    val sourceName: String,
    val sourceUrl: String,
)

@Entity(tableName = "ingredients")
data class IngredientEntity(
    @PrimaryKey val id: String,
    val name: String,
    val aisle: Aisle,
    val allergens: Set<Allergen>,
    val contains: Set<ContainsFlag>,
    val protein: Protein?,
    val isPantryStaple: Boolean,
)

/** Normalized (lower-case, trimmed) names and synonyms → canonical id, for pantry entry lookup. */
@Entity(
    tableName = "ingredient_synonyms",
    foreignKeys = [
        ForeignKey(IngredientEntity::class, ["id"], ["ingredientId"], onDelete = ForeignKey.CASCADE),
    ],
    indices = [Index("ingredientId")],
)
data class IngredientSynonymEntity(
    @PrimaryKey val synonym: String,
    val ingredientId: String,
)

@Entity(
    tableName = "recipe_ingredients",
    primaryKeys = ["recipeId", "position"],
    foreignKeys = [
        ForeignKey(RecipeEntity::class, ["id"], ["recipeId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(IngredientEntity::class, ["id"], ["ingredientId"]),
    ],
    indices = [Index("ingredientId")],
)
data class RecipeIngredientEntity(
    val recipeId: String,
    val position: Int,
    val ingredientId: String,
    val rawName: String,
    val rawMeasure: String,
    val amount: Double?,
    val amountMax: Double?,
    val unit: MeasureUnit?,
    val note: String?,
)

/** Kinds of multi-valued recipe tags stored in [RecipeTagEntity]. */
enum class TagType { MealType, Texture, Mood, Allergen, Diet, Protein }

/**
 * Multi-valued recipe tags as rows so they can be filtered in SQL. `value` is the enum's
 * serial name (e.g. "gluten", "vegetarian"). Allergen/Diet/Protein rows are derived on import.
 */
@Entity(
    tableName = "recipe_tags",
    primaryKeys = ["recipeId", "type", "value"],
    foreignKeys = [
        ForeignKey(RecipeEntity::class, ["id"], ["recipeId"], onDelete = ForeignKey.CASCADE),
    ],
    indices = [Index("type", "value")],
)
data class RecipeTagEntity(
    val recipeId: String,
    val type: TagType,
    val value: String,
)

/** Single row recording which bundled dataset version the catalog currently holds. */
@Entity(tableName = "dataset_meta")
data class DatasetMetaEntity(
    @PrimaryKey val id: Int = 0,
    val version: Int,
    val importedAtEpochMs: Long,
)
