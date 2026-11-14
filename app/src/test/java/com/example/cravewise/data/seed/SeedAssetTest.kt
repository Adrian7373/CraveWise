package com.example.cravewise.data.seed

import com.example.cravewise.data.local.TagType
import com.example.cravewise.domain.model.Allergen
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.boolean
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File
import java.security.MessageDigest

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

    @Test fun `manifest is a shippable build and its hash matches the dataset`() {
        val raw = json.parseToJsonElement(File(dir, "manifest.json").readText()).jsonObject
        assertFalse(
            "dataset was built with --allow-unreviewed; rebuild after the allergen review",
            raw["unreviewed"]?.jsonPrimitive?.boolean == true,
        )
        raw["sha256"]?.jsonPrimitive?.content?.let { expected ->
            val actual = MessageDigest.getInstance("SHA-256").digest(File(dir, manifest.file).readBytes())
                .joinToString("") { "%02x".format(it) }
            assertEquals("dataset.json changed without re-running build.py", expected, actual)
        }
    }

    @Test fun `nutrition and line grams survive the mapping`() {
        val rows = SeedMapper.map(dataset)
        assertEquals(
            dataset.ingredients.count { it.nutrition != null },
            rows.ingredients.count { it.per100g != null },
        )
        assertEquals(
            dataset.recipes.sumOf { r -> r.ingredients.count { it.grams != null } },
            rows.lines.count { it.grams != null },
        )
        assertTrue("no ingredient has nutrition", rows.ingredients.any { it.per100g != null })
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
