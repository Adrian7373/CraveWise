package com.example.cravewise.data.seed

import com.example.cravewise.data.local.TagType
import com.example.cravewise.domain.model.Allergen
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * Guards the bundled dataset (output of tools/seedgen/build.py) so a bad export fails CI instead
 * of crashing the import on a tester's phone.
 */
class SeedAssetTest {

    private val dir = File("src/main/assets/seed")
    private val json = Json { ignoreUnknownKeys = true }

    private val manifest by lazy { json.decodeFromString<SeedManifest>(File(dir, "manifest.json").readText()) }
    private val dataset by lazy { json.decodeFromString<SeedDataset>(File(dir, manifest.file).readText()) }

    @Test fun `manifest and dataset versions match`() {
        assertEquals(manifest.version, dataset.version)
    }

    @Test fun `dataset maps to rows without errors`() {
        val rows = SeedMapper.map(dataset) // throws on unknown ingredient ids / synonym clashes
        assertEquals(dataset.recipes.size, rows.recipes.size)
        assertEquals(dataset.recipes.sumOf { it.ingredients.size }, rows.lines.size)
    }

    @Test fun `recipe ids are unique and every recipe is complete`() {
        assertEquals(dataset.recipes.size, dataset.recipes.map { it.id }.toSet().size)
        dataset.recipes.forEach { r ->
            assertTrue("${r.id} has no ingredients", r.ingredients.isNotEmpty())
            assertTrue("${r.id} has no steps", r.steps.isNotEmpty())
            assertTrue("${r.id} has no meal type", r.mealTypes.isNotEmpty())
            assertTrue("${r.id} servings", r.servings > 0)
            with(r.flavor) {
                listOf(salty, sweet, sour, bitter, umami, spicy).forEach {
                    assertTrue("${r.id} flavor out of range", it in 0..5)
                }
            }
        }
    }

    @Test fun `every recipe gets derived diet and allergen tags from its ingredients`() {
        val rows = SeedMapper.map(dataset)
        val byId = dataset.ingredients.associateBy { it.id }
        dataset.recipes.forEach { r ->
            val expected = r.ingredients.flatMap { byId.getValue(it.ingredientId).allergens }.toSet()
            val stored = rows.tags.filter { it.recipeId == r.id && it.type == TagType.Allergen }.map { it.value }.toSet()
            assertEquals("${r.id} allergens", expected.map { Allergen.serializer().serialNameOf(it) }.toSet(), stored)
        }
    }
}
