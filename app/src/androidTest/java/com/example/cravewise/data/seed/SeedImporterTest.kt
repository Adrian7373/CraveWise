package com.example.cravewise.data.seed

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.cravewise.data.local.CraveDatabase
import com.example.cravewise.data.repository.OfflineRecipeRepository
import com.example.cravewise.domain.model.Allergen
import com.example.cravewise.domain.model.Diet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SeedImporterTest {

    private lateinit var db: CraveDatabase

    @Before fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, CraveDatabase::class.java).build()
    }

    @After fun tearDown() = db.close()

    private fun files(version: Int, title: String) = mapOf(
        "manifest.json" to """{"version":$version,"file":"dataset.json"}""",
        "dataset.json" to """
            {"version":$version,
             "ingredients":[
               {"id":"butter","name":"Butter","synonyms":["Unsalted Butter"],"aisle":"dairy_eggs",
                "allergens":["milk"],"contains":["dairy"],"isPantryStaple":true},
               {"id":"egg","name":"Egg","aisle":"dairy_eggs","allergens":["eggs"],"contains":["egg"],
                "protein":"egg","isPantryStaple":true}],
             "recipes":[
               {"id":"r1","title":"$title","cuisine":"French","mealTypes":["breakfast"],
                "flavor":{"salty":2,"sweet":0,"sour":0,"bitter":0,"umami":2,"spicy":0},
                "servings":1,"prepMinutes":2,"cookMinutes":5,"difficulty":"easy",
                "ingredients":[
                  {"ingredientId":"egg","rawName":"Eggs","rawMeasure":"2","amount":2.0},
                  {"ingredientId":"butter","rawName":"Butter","rawMeasure":"1 tbsp","amount":1.0,"unit":"tbsp"}],
                "steps":["Melt butter.","Cook eggs."],
                "source":{"name":"Test","sourceId":"1","url":"https://example.com"}}]}
        """.trimIndent(),
    )

    private fun importer(files: Map<String, String>) =
        SeedImporter(db.catalogDao(), { name -> files.getValue(name) }, Dispatchers.IO)

    @Test fun firstRunSeedsAndDerivesSafetyTags() = runBlocking {
        val seeder = importer(files(1, "Omelette"))
        assertTrue(seeder.ensureSeeded())

        val recipe = OfflineRecipeRepository(db.catalogDao(), seeder).observeRecipe("r1").first()
        assertNotNull(recipe)
        assertEquals(setOf(Allergen.Eggs, Allergen.Milk), recipe!!.allergens)
        assertTrue(Diet.Vegetarian in recipe.diets)
        assertFalse(Diet.Vegan in recipe.diets)
        assertFalse(Diet.DairyFree in recipe.diets)
        assertEquals(listOf("Eggs", "Butter"), recipe.ingredients.map { it.rawName })
    }

    @Test fun sameVersionDoesNotReseed() = runBlocking {
        assertTrue(importer(files(1, "Omelette")).ensureSeeded())
        assertFalse(importer(files(1, "Changed")).ensureSeeded())
        assertEquals("Omelette", db.catalogDao().observeRecipesWithTags().first().single().recipe.title)
    }

    @Test fun versionBumpReplacesCatalog() = runBlocking {
        importer(files(1, "Omelette")).ensureSeeded()
        assertTrue(importer(files(2, "Better Omelette")).ensureSeeded())
        assertEquals("Better Omelette", db.catalogDao().observeRecipesWithTags().first().single().recipe.title)
        assertEquals(2, db.catalogDao().datasetMeta()?.version)
    }

    @Test fun synonymsResolveToCanonicalId() = runBlocking {
        val seeder = importer(files(1, "Omelette"))
        val repo = OfflineRecipeRepository(db.catalogDao(), seeder)
        assertEquals("butter", repo.resolveIngredientId("  unsalted   BUTTER "))
        assertEquals(null, repo.resolveIngredientId("margarine"))
    }
}
