package com.example.cravewise.data.local

import androidx.room.Dao
import androidx.room.Embedded
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Relation
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

data class RecipeWithTags(
    @Embedded val recipe: RecipeEntity,
    @Relation(parentColumn = "id", entityColumn = "recipeId")
    val tags: List<RecipeTagEntity>,
)

data class IngredientLineWithIngredient(
    @Embedded val line: RecipeIngredientEntity,
    @Relation(parentColumn = "ingredientId", entityColumn = "id")
    val ingredient: IngredientEntity,
)

data class RecipeDetailRow(
    @Embedded val recipe: RecipeEntity,
    @Relation(parentColumn = "id", entityColumn = "recipeId")
    val tags: List<RecipeTagEntity>,
    @Relation(entity = RecipeIngredientEntity::class, parentColumn = "id", entityColumn = "recipeId")
    val lines: List<IngredientLineWithIngredient>,
)

data class IngredientWithSynonyms(
    @Embedded val ingredient: IngredientEntity,
    @Relation(parentColumn = "id", entityColumn = "ingredientId")
    val synonyms: List<IngredientSynonymEntity>,
)

/** One (recipe, ingredient) pair, for pantry matching without loading full recipes. */
data class RecipeIngredientRef(val recipeId: String, val ingredientId: String)

@Dao
abstract class CatalogDao {

    @Transaction
    @Query("SELECT * FROM recipes ORDER BY title COLLATE NOCASE")
    abstract fun observeRecipesWithTags(): Flow<List<RecipeWithTags>>

    @Transaction
    @Query("SELECT * FROM recipes WHERE id = :id")
    abstract fun observeRecipeDetail(id: String): Flow<RecipeDetailRow?>

    @Transaction
    @Query("SELECT * FROM ingredients ORDER BY name COLLATE NOCASE")
    abstract fun observeIngredientsWithSynonyms(): Flow<List<IngredientWithSynonyms>>

    /** Every recipe's ingredient ids, in recipe order. */
    @Query("SELECT recipeId, ingredientId FROM recipe_ingredients ORDER BY recipeId, position")
    abstract fun observeRecipeIngredientRefs(): Flow<List<RecipeIngredientRef>>

    @Query("SELECT ingredientId FROM ingredient_synonyms WHERE synonym = :normalized")
    abstract suspend fun findIngredientIdBySynonym(normalized: String): String?

    @Query("SELECT COUNT(*) FROM recipes")
    abstract suspend fun recipeCount(): Int

    /** Recipe ids whose FTS row matches [match] (FTS4 MATCH syntax, e.g. `title:curr*`). */
    @Query("SELECT recipeId FROM recipe_fts WHERE recipe_fts MATCH :match")
    abstract suspend fun searchRecipeIds(match: String): List<String>

    @Query("SELECT COUNT(*) FROM recipe_fts")
    abstract suspend fun searchIndexCount(): Int

    /** Rebuilds the full-text index from the catalog tables. */
    @Transaction
    open suspend fun rebuildSearchIndex() {
        clearSearchIndex()
        fillSearchIndex()
    }

    @Query("DELETE FROM recipe_fts")
    protected abstract suspend fun clearSearchIndex()

    // Ingredient text = canonical name + the recipe's own wording ("spring onions"), so both match.
    @Query(
        """
        INSERT INTO recipe_fts (recipeId, title, cuisine, ingredients)
        SELECT r.id, r.title, r.cuisine, COALESCE(
            (SELECT group_concat(i.name || ' ' || ri.rawName, ' ')
             FROM recipe_ingredients ri JOIN ingredients i ON i.id = ri.ingredientId
             WHERE ri.recipeId = r.id), '')
        FROM recipes r
        """,
    )
    protected abstract suspend fun fillSearchIndex()

    @Query("SELECT * FROM dataset_meta WHERE id = 0")
    abstract suspend fun datasetMeta(): DatasetMetaEntity?

    /** Atomically swaps the whole catalog for a new dataset version. Observers see old or new, never half. */
    @Transaction
    open suspend fun replaceCatalog(
        recipes: List<RecipeEntity>,
        ingredients: List<IngredientEntity>,
        synonyms: List<IngredientSynonymEntity>,
        lines: List<RecipeIngredientEntity>,
        tags: List<RecipeTagEntity>,
        meta: DatasetMetaEntity,
    ) {
        // Children first: recipe_ingredients references ingredients without a cascade.
        clearRecipes()
        clearIngredients()
        insertIngredients(ingredients)
        insertSynonyms(synonyms)
        insertRecipes(recipes)
        insertLines(lines)
        insertTags(tags)
        upsertMeta(meta)
        rebuildSearchIndex()
    }

    @Query("DELETE FROM recipes") // cascades to recipe_ingredients and recipe_tags
    protected abstract suspend fun clearRecipes()

    @Query("DELETE FROM ingredients") // cascades to ingredient_synonyms
    protected abstract suspend fun clearIngredients()

    @Insert
    protected abstract suspend fun insertRecipes(items: List<RecipeEntity>)

    @Insert
    protected abstract suspend fun insertIngredients(items: List<IngredientEntity>)

    @Insert
    protected abstract suspend fun insertSynonyms(items: List<IngredientSynonymEntity>)

    @Insert
    protected abstract suspend fun insertLines(items: List<RecipeIngredientEntity>)

    @Insert
    protected abstract suspend fun insertTags(items: List<RecipeTagEntity>)

    @Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    protected abstract suspend fun upsertMeta(meta: DatasetMetaEntity)
}
