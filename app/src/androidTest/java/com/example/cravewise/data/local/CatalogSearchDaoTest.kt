package com.example.cravewise.data.local

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.cravewise.domain.model.Aisle
import com.example.cravewise.domain.model.Difficulty
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CatalogSearchDaoTest {

    private lateinit var db: CraveDatabase
    private val dao get() = db.catalogDao()

    @Before fun setUp() = runBlocking {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, CraveDatabase::class.java).build()
        dao.replaceCatalog(
            recipes = listOf(recipe("curry", "Thai Green Curry", "Thai"), recipe("ramen", "Pork Noodles", "Japanese")),
            ingredients = listOf(ingredient("coconut_milk", "Coconut Milk"), ingredient("noodle", "Egg Noodles")),
            synonyms = emptyList(),
            lines = listOf(line("curry", "coconut_milk", "coconut cream"), line("ramen", "noodle", "ramen noodles")),
            tags = emptyList(),
            meta = DatasetMetaEntity(version = 1, importedAtEpochMs = 0),
        )
    }

    @After fun tearDown() = db.close()

    private fun recipe(id: String, title: String, cuisine: String) = RecipeEntity(
        id, title, cuisine, servings = 2, prepMinutes = 5, cookMinutes = 10, difficulty = Difficulty.Easy,
        salty = 0, sweet = 0, sour = 0, bitter = 0, umami = 0, spicy = 0, steps = listOf("Cook."),
        imageUrl = null, sourceName = "", sourceUrl = "",
    )

    private fun ingredient(id: String, name: String) =
        IngredientEntity(id, name, Aisle.Pantry, emptySet(), emptySet(), protein = null, isPantryStaple = false)

    private fun line(recipeId: String, ingredientId: String, raw: String) =
        RecipeIngredientEntity(recipeId, 0, ingredientId, raw, "1", 1.0, null, null, null)

    private fun search(match: String) = runBlocking { dao.searchRecipeIds(match).toSet() }

    @Test fun replaceCatalogBuildsTheIndex() = runBlocking {
        assertEquals(2, dao.searchIndexCount())
    }

    @Test fun prefixAndStemmingMatchTitles() {
        assertEquals(setOf("curry"), search("title:curr*"))
        assertEquals(setOf("ramen"), search("title:noodle*")) // "Noodles" stems to "noodl"
        assertEquals(emptySet<String>(), search("title:coconut*"))
    }

    @Test fun ingredientsAndCuisineAreSearchable() {
        assertEquals(setOf("curry"), search("coconut*")) // canonical name
        assertEquals(setOf("curry"), search("cream*")) // the recipe's own wording
        assertEquals(setOf("ramen"), search("japanese*"))
        assertEquals(setOf("ramen"), search("egg* noodle*")) // words are ANDed
    }

    @Test fun rebuildIsIdempotent() = runBlocking {
        dao.rebuildSearchIndex()
        dao.rebuildSearchIndex()
        assertEquals(2, dao.searchIndexCount())
    }
}
