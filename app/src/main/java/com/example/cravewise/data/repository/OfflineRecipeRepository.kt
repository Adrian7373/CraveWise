package com.example.cravewise.data.repository

import com.example.cravewise.data.local.CatalogDao
import com.example.cravewise.data.local.IngredientEntity
import com.example.cravewise.data.local.RecipeDetailRow
import com.example.cravewise.data.local.RecipeEntity
import com.example.cravewise.data.local.RecipeTagEntity
import com.example.cravewise.data.local.RecipeWithTags
import com.example.cravewise.data.local.TagType
import com.example.cravewise.data.seed.SeedImporter
import com.example.cravewise.data.seed.SeedMapper
import com.example.cravewise.data.seed.fromSerialName
import com.example.cravewise.domain.model.Allergen
import com.example.cravewise.domain.model.Diet
import com.example.cravewise.domain.model.FlavorScores
import com.example.cravewise.domain.model.Ingredient
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.model.Mood
import com.example.cravewise.domain.model.Protein
import com.example.cravewise.domain.model.Recipe
import com.example.cravewise.domain.model.RecipeIngredientLine
import com.example.cravewise.domain.model.RecipeSummary
import com.example.cravewise.domain.model.Texture
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.serialization.KSerializer
import javax.inject.Inject

/**
 * Room-backed repository over the bundled catalog. Fully offline: the app has no network source
 * (and no INTERNET permission). Seeding failures surface through [SeedImporter.status].
 */
class OfflineRecipeRepository @Inject constructor(
    private val dao: CatalogDao,
    private val seeder: SeedImporter,
) : RecipeRepository {

    override fun observeRecipeSummaries(): Flow<List<RecipeSummary>> =
        dao.observeRecipesWithTags()
            .onStart { seeder.ensureSeededSafely() }
            .map { rows -> rows.map(RecipeWithTags::toSummary) }

    override fun observeRecipe(id: String): Flow<Recipe?> =
        dao.observeRecipeDetail(id)
            .onStart { seeder.ensureSeededSafely() }
            .map { it?.toDomain() }

    override fun observeIngredients(): Flow<List<Ingredient>> =
        dao.observeIngredientsWithSynonyms()
            .onStart { seeder.ensureSeededSafely() }
            .map { list ->
                list.map { row -> row.ingredient.toDomain(row.synonyms.mapTo(mutableSetOf()) { it.synonym }) }
            }

    override fun observeRecipeIngredientIds(): Flow<Map<String, List<String>>> =
        dao.observeRecipeIngredientRefs()
            .onStart { seeder.ensureSeededSafely() }
            .map { refs -> refs.groupBy({ it.recipeId }, { it.ingredientId }) }

    override suspend fun resolveIngredientId(text: String): String? {
        seeder.ensureSeededSafely()
        return dao.findIngredientIdBySynonym(SeedMapper.normalize(text))
    }
}

private fun <T : Enum<T>> List<RecipeTagEntity>.values(
    type: TagType,
    serializer: KSerializer<T>,
    entries: List<T>,
): Set<T> = filter { it.type == type }.mapNotNullTo(mutableSetOf()) { serializer.fromSerialName(it.value, entries) }

private fun RecipeEntity.flavor() = FlavorScores(salty, sweet, sour, bitter, umami, spicy)

private fun summaryOf(recipe: RecipeEntity, tags: List<RecipeTagEntity>) = RecipeSummary(
    id = recipe.id,
    title = recipe.title,
    cuisine = recipe.cuisine,
    totalMinutes = recipe.prepMinutes + recipe.cookMinutes,
    difficulty = recipe.difficulty,
    flavor = recipe.flavor(),
    mealTypes = tags.values(TagType.MealType, MealType.serializer(), MealType.entries),
    proteins = tags.values(TagType.Protein, Protein.serializer(), Protein.entries),
    diets = tags.values(TagType.Diet, Diet.serializer(), Diet.entries),
    allergens = tags.values(TagType.Allergen, Allergen.serializer(), Allergen.entries),
    moods = tags.values(TagType.Mood, Mood.serializer(), Mood.entries),
    textures = tags.values(TagType.Texture, Texture.serializer(), Texture.entries),
)

private fun RecipeWithTags.toSummary() = summaryOf(recipe, tags)

private fun IngredientEntity.toDomain(synonyms: Set<String> = emptySet()) = Ingredient(
    id = id, name = name, aisle = aisle, allergens = allergens, isPantryStaple = isPantryStaple,
    synonyms = synonyms, protein = protein, nutrition = per100g,
)

private fun RecipeDetailRow.toDomain() = Recipe(
    summary = summaryOf(recipe, tags),
    servings = recipe.servings,
    prepMinutes = recipe.prepMinutes,
    cookMinutes = recipe.cookMinutes,
    textures = tags.values(TagType.Texture, Texture.serializer(), Texture.entries),
    ingredients = lines.sortedBy { it.line.position }.map { (line, ingredient) ->
        RecipeIngredientLine(
            ingredient = ingredient.toDomain(),
            rawName = line.rawName,
            rawMeasure = line.rawMeasure,
            amount = line.amount,
            amountMax = line.amountMax,
            unit = line.unit,
            note = line.note,
            grams = line.grams,
        )
    },
    steps = recipe.steps,
    imageUrl = recipe.imageUrl,
    sourceName = recipe.sourceName,
    sourceUrl = recipe.sourceUrl,
)
