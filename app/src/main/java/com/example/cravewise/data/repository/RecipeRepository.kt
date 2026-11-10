package com.example.cravewise.data.repository

import com.example.cravewise.domain.model.Ingredient
import com.example.cravewise.domain.model.Recipe
import com.example.cravewise.domain.model.RecipeSummary
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    /** All recipes, title-sorted. Seeds the catalog on first collection if needed. */
    fun observeRecipeSummaries(): Flow<List<RecipeSummary>>

    /** One recipe with ingredients and steps; emits null if the id is unknown. */
    fun observeRecipe(id: String): Flow<Recipe?>

    /** The ingredient catalog, name-sorted, with normalized synonyms filled in. */
    fun observeIngredients(): Flow<List<Ingredient>>

    /** Recipe id → its ingredient ids in recipe order, for pantry matching. */
    fun observeRecipeIngredientIds(): Flow<Map<String, List<String>>>

    /** Resolves typed text ("Scallions") to a canonical ingredient id via synonyms, or null. */
    suspend fun resolveIngredientId(text: String): String?
}
