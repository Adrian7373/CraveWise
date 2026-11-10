package com.example.cravewise.domain

import com.example.cravewise.domain.model.Aisle
import com.example.cravewise.domain.model.Difficulty
import com.example.cravewise.domain.model.FlavorScores
import com.example.cravewise.domain.model.Ingredient
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.model.Pantry
import com.example.cravewise.domain.model.RecipeSummary
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class PantryMatcherTest {

    private fun ing(id: String, staple: Boolean = false) =
        Ingredient(id, id.replaceFirstChar { it.uppercase() }, Aisle.Other, emptySet(), isPantryStaple = staple)

    private fun recipe(id: String) = RecipeSummary(
        id = id, title = id, cuisine = "Any", totalMinutes = 10, difficulty = Difficulty.Easy,
        flavor = FlavorScores(0, 0, 0, 0, 0, 0), mealTypes = setOf(MealType.Main), proteins = emptySet(), diets = emptySet(),
        allergens = emptySet(),
    )

    private val catalog = listOf(
        ing("salt", staple = true), ing("oil", staple = true),
        ing("egg"), ing("rice"), ing("chicken"), ing("lemon"), ing("basil"), ing("tomato"), ing("cheese"),
    ).associateBy { it.id }

    private val recipeIngredients = mapOf(
        "fried-rice" to listOf("rice", "egg", "oil", "salt"),
        "lemon-chicken" to listOf("chicken", "lemon", "salt"),
        "caprese" to listOf("tomato", "basil", "cheese", "oil"),
        "chicken-rice" to listOf("chicken", "rice", "salt", "salt"),
        "big-dish" to listOf("rice", "chicken", "lemon", "basil", "tomato", "cheese"),
    )
    private val recipes = recipeIngredients.keys.map(::recipe)

    private fun match(vararg have: String, assumeStaples: Boolean = true) =
        PantryMatcher.match(recipes, recipeIngredients, catalog, Pantry(have.toList(), assumeStaples))

    private fun List<PantryMatch>.ids() = map { it.recipe.id }

    @Test fun emptyPantryGivesNoResults() {
        assertTrue(match().isEmpty)
    }

    @Test fun assumedStaplesCompleteARecipe() {
        val r = match("rice", "egg")
        assertEquals(listOf("fried-rice"), r.cookNow.ids())
    }

    @Test fun withoutAssumedStaplesTheyCountAsMissing() {
        val r = match("rice", "egg", assumeStaples = false)
        assertTrue(r.cookNow.isEmpty())
        val friedRice = r.almostThere.single { it.recipe.id == "fried-rice" }
        assertEquals(listOf("oil", "salt"), friedRice.missing.map { it.id })
    }

    @Test fun bucketsSplitByMissingCount() {
        val r = match("chicken", "rice")
        assertEquals(listOf("chicken-rice"), r.cookNow.ids())
        // fried-rice misses egg, lemon-chicken misses lemon: both one away.
        assertEquals(setOf("fried-rice", "lemon-chicken"), r.almostThere.ids().toSet())
        // big-dish misses 4.
        assertEquals(listOf("big-dish"), r.needsShopping.ids())
    }

    @Test fun recipesUsingNothingFromThePantryAreDropped() {
        // Caprese only shares oil, which is an assumed staple, not something the user listed.
        val r = match("chicken")
        assertTrue("caprese" !in (r.cookNow + r.almostThere + r.needsShopping).ids())
    }

    @Test fun duplicateIngredientLinesCountOnce() {
        val m = match("chicken", "rice").cookNow.single()
        assertEquals("chicken-rice", m.recipe.id)
        assertEquals(3, m.total)
        assertEquals(100, m.matchPercent)
    }

    @Test fun haveAndMissingKeepRecipeOrder() {
        val m = match("lemon", "rice").needsShopping.single { it.recipe.id == "big-dish" }
        assertEquals(listOf("rice", "lemon"), m.have.map { it.id })
        assertEquals(listOf("chicken", "basil", "tomato", "cheese"), m.missing.map { it.id })
        assertEquals(2, m.usesFromPantry)
    }

    @Test fun matchPercentIsFloored() {
        // fried-rice with only rice and staples: 3 of 4 = 75; lemon-chicken 2 of 3 = 66, not 67.
        val r = match("rice", "lemon")
        assertEquals(75, r.almostThere.single { it.recipe.id == "fried-rice" }.matchPercent)
        assertEquals(66, r.almostThere.single { it.recipe.id == "lemon-chicken" }.matchPercent)
    }

    @Test fun rankingPrefersMoreOfYourIngredientsThenCoverage() {
        // All three miss exactly one. caprese uses 2 listed items; fried-rice (75%) and
        // chicken-rice (66%) use 1 each, so coverage breaks that tie.
        val r = match("basil", "tomato", "rice")
        assertEquals(listOf("caprese", "fried-rice", "chicken-rice"), r.almostThere.ids())
        assertEquals(listOf("big-dish"), r.needsShopping.ids())
    }

    @Test fun tiesFallBackToTitle() {
        val r = match("chicken", "lemon", "rice")
        assertEquals(listOf("chicken-rice", "lemon-chicken"), r.cookNow.ids())
    }

    @Test fun unknownIngredientIdsAreIgnored() {
        val withGhost = recipeIngredients + ("ghost" to listOf("rice", "unicorn"))
        val r = PantryMatcher.match(recipes + recipe("ghost"), withGhost, catalog, Pantry(listOf("rice")))
        val ghost = r.cookNow.single { it.recipe.id == "ghost" }
        assertEquals(1, ghost.total)
    }

    @Test fun stalePantryIdsMatchNothing() {
        assertTrue(match("removed-from-dataset").isEmpty)
    }

    @Test fun popularIngredientsSkipStaplesAndPantry() {
        val popular = PantryMatcher.popularIngredients(recipeIngredients, catalog, Pantry(listOf("chicken")), limit = 3)
        // rice: 3 recipes; then basil, cheese, lemon, tomato with 2 each, by name.
        assertEquals(listOf("rice", "basil", "cheese"), popular.map { it.id })
    }
}
