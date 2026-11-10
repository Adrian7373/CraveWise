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

    fun observeIngredients(): Flow<List<Ingredient>>

    /** Resolves typed text ("Scallions") to a canonical ingredient id via synonyms, or null. */
    suspend fun resolveIngredientId(text: String): String?
}
