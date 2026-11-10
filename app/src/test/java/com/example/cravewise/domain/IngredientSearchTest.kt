package com.example.cravewise.domain

import com.example.cravewise.domain.model.Aisle
import com.example.cravewise.domain.model.Ingredient
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class IngredientSearchTest {

    private fun ing(id: String, name: String, vararg synonyms: String) = Ingredient(
        id, name, Aisle.Other, emptySet(), isPantryStaple = false,
        synonyms = (synonyms.toList() + name).map(IngredientSearch::normalize).toSet(),
    )

    private val oliveOil = ing("olive_oil", "Olive Oil", "Extra Virgin Olive Oil", "EVOO")
    private val oil = ing("vegetable_oil", "Vegetable Oil", "Oil")
    private val onion = ing("onion", "Onion", "Brown Onion")
    private val scallion = ing("scallion", "Scallion", "Spring Onion", "Green Onion")
    private val soy = ing("soy_sauce", "Soy Sauce", "Light Soy Sauce")
    private val all = listOf(oliveOil, oil, onion, scallion, soy)

    private fun suggest(q: String, exclude: Set<String> = emptySet(), limit: Int = 8) =
        IngredientSearch.suggest(q, all, exclude, limit).map { it.id }

    @Test fun blankQueryGivesNothing() {
        assertTrue(suggest("   ").isEmpty())
    }

    @Test fun exactSynonymBeatsPrefixes() {
        // "oil" is a synonym of vegetable oil; olive oil only matches on a word prefix.
        assertEquals(listOf("vegetable_oil", "olive_oil"), suggest("oil"))
    }

    @Test fun namePrefixBeatsSynonymAndWordMatches() {
        // onion: name prefix. scallion: word prefix inside "spring onion".
        assertEquals(listOf("onion", "scallion"), suggest("oni"))
    }

    @Test fun synonymPrefixFindsIngredient() {
        assertEquals(listOf("olive_oil"), suggest("evo"))
        assertEquals(listOf("scallion"), suggest("spring"))
    }

    @Test fun substringIsTheLastResort() {
        assertEquals(listOf("soy_sauce"), suggest("auc"))
    }

    @Test fun caseAndSpacingAreIgnored() {
        assertEquals(listOf("soy_sauce"), suggest("  SOY   sau "))
    }

    @Test fun excludedIdsAndLimitApply() {
        assertEquals(listOf("olive_oil"), suggest("oil", exclude = setOf("vegetable_oil")))
        assertEquals(listOf("vegetable_oil"), suggest("oil", limit = 1))
    }

    @Test fun exactMatchUsesNameOrSynonym() {
        assertEquals("scallion", IngredientSearch.exactMatch("green onion", all)?.id)
        assertEquals("olive_oil", IngredientSearch.exactMatch("Olive oil", all)?.id)
        assertNull(IngredientSearch.exactMatch("oli", all))
    }
}
