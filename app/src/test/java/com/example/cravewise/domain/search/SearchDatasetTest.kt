package com.example.cravewise.domain.search

import com.example.cravewise.data.local.TagType
import com.example.cravewise.data.seed.SeedDataset
import com.example.cravewise.data.seed.SeedManifest
import com.example.cravewise.data.seed.SeedMapper
import com.example.cravewise.data.seed.fromSerialName
import com.example.cravewise.domain.model.Allergen
import com.example.cravewise.domain.model.Diet
import com.example.cravewise.domain.model.FlavorScores
import com.example.cravewise.domain.model.Ingredient
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.model.Mood
import com.example.cravewise.domain.model.Pantry
import com.example.cravewise.domain.model.Protein
import com.example.cravewise.domain.model.RecipeSummary
import com.example.cravewise.domain.model.Texture
import com.example.cravewise.ui.search.SearchViewModel
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * Runs the parser and ranker over the real bundled dataset, so lexicon/ingredient collisions and
 * safety regressions show up in CI. Full-text hits are empty here (that part is Room).
 */
class SearchDatasetTest {

    private val json = Json { ignoreUnknownKeys = true }
    private val dir = File("src/main/assets/seed")
    private val dataset by lazy {
        val manifest = json.decodeFromString<SeedManifest>(File(dir, "manifest.json").readText())
        json.decodeFromString<SeedDataset>(File(dir, manifest.file).readText())
    }
    private val rows by lazy { SeedMapper.map(dataset) }

    private val ingredients by lazy {
        dataset.ingredients.map {
            Ingredient(it.id, it.name, it.aisle, it.allergens, it.isPantryStaple, (it.synonyms + it.name).map(SeedMapper::normalize).toSet())
        }
    }
    private val recipeIngredients by lazy { rows.lines.groupBy({ it.recipeId }, { it.ingredientId }) }

    private val recipes by lazy {
        val tagsById = rows.tags.groupBy { it.recipeId }
        rows.recipes.map { r ->
            val tags = tagsById[r.id].orEmpty()
            fun <T : Enum<T>> values(type: TagType, s: KSerializer<T>, entries: List<T>) =
                tags.filter { it.type == type }.mapNotNullTo(mutableSetOf()) { s.fromSerialName(it.value, entries) }
            RecipeSummary(
                id = r.id, title = r.title, cuisine = r.cuisine, totalMinutes = r.prepMinutes + r.cookMinutes,
                difficulty = r.difficulty, flavor = FlavorScores(r.salty, r.sweet, r.sour, r.bitter, r.umami, r.spicy),
                mealTypes = values(TagType.MealType, MealType.serializer(), MealType.entries),
                proteins = values(TagType.Protein, Protein.serializer(), Protein.entries),
                diets = values(TagType.Diet, Diet.serializer(), Diet.entries),
                allergens = values(TagType.Allergen, Allergen.serializer(), Allergen.entries),
                moods = values(TagType.Mood, Mood.serializer(), Mood.entries),
                textures = values(TagType.Texture, Texture.serializer(), Texture.entries),
            )
        }.sortedBy { it.title.lowercase() }
    }

    private val parser by lazy { QueryParser(ingredients, recipes.map { it.cuisine }.distinct()) }

    private fun search(q: String, pantry: Pantry = Pantry()) =
        SmartSearch.search(parser.parse(q), recipes, recipeIngredients, ingredients.associateBy { it.id }, pantry, emptyMap())

    @Test fun `every suggestion chip is fully understood and finds recipes`() {
        val pantry = Pantry(listOf(recipeIngredients.values.first().first()))
        SearchViewModel.SUGGESTIONS.forEach { suggestion ->
            val q = parser.parse(suggestion)
            assertTrue("“$suggestion” left words unparsed: ${q.textTerms}", q.wants.none { it is Want.Text })
            assertFalse("“$suggestion” found nothing", search(suggestion, pantry).isEmpty)
        }
    }

    @Test fun `no onions leaves out every kind of onion`() {
        // Head-noun family: "spring onions", "red onion"... but not "onion powder".
        val onionIds = ingredients.filter { it.name.lowercase().trimEnd('s').endsWith("onion") }.map { it.id }.toSet()
        assertTrue("dataset has no onions to test with", onionIds.isNotEmpty())
        val all = search("dinner")
        val results = search("dinner, no onions")
        assertFalse(results.isEmpty)
        assertTrue("nothing was excluded", results.total < all.total)
        (results.best + results.close).forEach { r ->
            assertTrue("${r.recipe.title} uses onions", recipeIngredients[r.recipe.id].orEmpty().none { it in onionIds })
        }
    }

    @Test fun `dairy and nut exclusions hold on real data`() {
        val results = search("sweet dessert, no dairy, nut-free")
        (results.best + results.close).forEach { r ->
            assertTrue(r.recipe.title, Allergen.Milk !in r.recipe.allergens)
            assertTrue(r.recipe.title, Allergen.TreeNuts !in r.recipe.allergens && Allergen.Peanuts !in r.recipe.allergens)
        }
    }

    @Test fun `protein words beat ingredient families`() {
        val chicken = search("chicken")
        assertFalse(chicken.isEmpty)
        chicken.best.forEach { assertTrue(it.recipe.title, Protein.Chicken in it.recipe.proteins) }
    }
}
