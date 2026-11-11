package com.example.cravewise.domain.search

import com.example.cravewise.domain.model.Aisle
import com.example.cravewise.domain.model.Allergen
import com.example.cravewise.domain.model.Diet
import com.example.cravewise.domain.model.Difficulty
import com.example.cravewise.domain.model.FlavorScores
import com.example.cravewise.domain.model.Ingredient
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.model.Mood
import com.example.cravewise.domain.model.Pantry
import com.example.cravewise.domain.model.Protein
import com.example.cravewise.domain.model.RecipeSummary
import com.example.cravewise.domain.model.Texture
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class SmartSearchTest {

    private fun ing(id: String) = Ingredient(id, id.replaceFirstChar { it.uppercase() }, Aisle.Produce, emptySet(), false, setOf(id))

    private val ingredients = listOf("noodle", "pork", "mushroom", "chicken", "coconut", "lettuce", "lemon", "walnut", "butter", "egg")
        .map(::ing)

    private fun recipe(
        id: String,
        title: String,
        minutes: Int,
        flavor: FlavorScores = FlavorScores(0, 0, 0, 0, 0, 0),
        meal: MealType = MealType.Main,
        proteins: Set<Protein> = emptySet(),
        textures: Set<Texture> = emptySet(),
        moods: Set<Mood> = emptySet(),
        diets: Set<Diet> = emptySet(),
        allergens: Set<Allergen> = emptySet(),
    ) = RecipeSummary(
        id = id, title = title, cuisine = "Any", totalMinutes = minutes, difficulty = Difficulty.Easy,
        flavor = flavor, mealTypes = setOf(meal), proteins = proteins, diets = diets,
        allergens = allergens, moods = moods, textures = textures,
    )

    private val ramen = recipe(
        "ramen", "Pork Ramen", 40, FlavorScores(4, 0, 0, 0, 5, 1),
        proteins = setOf(Protein.Pork), textures = setOf(Texture.Brothy), moods = setOf(Mood.Comfort),
    )
    private val curry = recipe(
        "curry", "Green Curry", 30, FlavorScores(2, 1, 0, 0, 3, 4),
        proteins = setOf(Protein.Chicken), textures = setOf(Texture.Creamy),
    )
    private val salad = recipe(
        "salad", "Lemon Salad", 10, FlavorScores(1, 0, 3, 1, 0, 0),
        moods = setOf(Mood.Fresh, Mood.Light), diets = setOf(Diet.Vegan, Diet.Vegetarian),
    )
    private val brownie = recipe(
        "brownie", "Walnut Brownie", 45, FlavorScores(0, 5, 0, 1, 0, 0), MealType.Dessert,
        allergens = setOf(Allergen.TreeNuts, Allergen.Milk, Allergen.Eggs),
    )
    private val recipes = listOf(brownie, curry, ramen, salad) // title order, as the repository gives

    private val recipeIngredients = mapOf(
        "ramen" to listOf("noodle", "pork", "mushroom"),
        "curry" to listOf("chicken", "coconut"),
        "salad" to listOf("lettuce", "lemon"),
        "brownie" to listOf("walnut", "butter", "egg"),
    )

    private val parser = QueryParser(ingredients, listOf("Any"))

    private fun search(
        q: String,
        pantry: Pantry = Pantry(),
        hits: Map<String, TextHits> = emptyMap(),
    ) = SmartSearch.search(parser.parse(q), recipes, recipeIngredients, ingredients.associateBy { it.id }, pantry, hits)

    private fun SearchResults.ids(): List<String> = (best + close).map { it.recipe.id }

    @Test fun `empty query gives nothing`() {
        assertTrue(search("").isEmpty)
    }

    @Test fun `a want must match`() {
        val r = search("something salty")
        assertEquals(listOf("ramen"), r.ids())
        assertEquals(listOf("Salty 4/5"), r.best.single().reasons)
    }

    @Test fun `several wants split into best and close matches`() {
        val r = search("spicy creamy brothy")
        assertTrue(r.best.isEmpty())
        assertEquals(listOf("curry", "ramen"), r.close.map { it.recipe.id }) // 2 of 3 beats 1 of 3
        assertEquals(listOf("Spicy 4/5", "Creamy"), r.close.first().reasons)
    }

    @Test fun `all wants matched is a best match`() {
        val r = search("spicy chicken")
        assertEquals(listOf("curry"), r.best.map { it.recipe.id })
        assertTrue(r.close.isEmpty())
    }

    @Test fun `exclusions alone filter the whole cookbook, by title`() {
        // Green Curry, Lemon Salad, Walnut Brownie
        assertEquals(listOf("curry", "salad", "brownie"), search("no mushrooms").ids())
    }

    @Test fun `allergen exclusions use derived tags`() {
        assertTrue(search("dessert, nut free").isEmpty)
        assertEquals(listOf("curry", "salad", "ramen"), search("no eggs").ids())
    }

    @Test fun `diets and meal types are hard filters`() {
        assertEquals(listOf("salad"), search("vegan").ids())
        assertEquals(listOf("brownie"), search("dessert").ids())
    }

    @Test fun `time-boxed results sort quickest first`() {
        assertEquals(listOf("salad", "curry"), search("quick").ids())
    }

    @Test fun `text terms use full-text hits and report unknown words`() {
        val hits = mapOf("curry" to TextHits(inTitle = setOf("curry"), anywhere = setOf("curry")))
        val r = search("curry", hits = hits)
        assertEquals(listOf("curry"), r.ids())
        assertEquals(listOf("“curry”"), r.best.single().reasons)

        val unknown = search("zorbo")
        assertTrue(unknown.isEmpty)
        assertEquals(listOf("zorbo"), unknown.unmatchedTerms)
    }

    @Test fun `ingredient wants match by id`() {
        assertEquals(listOf("ramen"), search("mushroom").ids())
    }

    @Test fun `pantry search keeps recipes that use the pantry, fewest missing first`() {
        val r = search("what can I make with what I have", pantry = Pantry(listOf("lemon", "lettuce", "pork")))
        assertEquals(listOf("salad", "ramen"), r.ids())
        assertEquals("You have everything", r.best.first().reasons.last())
        assertEquals(100, r.best.first().pantry?.matchPercent)
    }

    @Test fun `pantry search with an empty pantry says so and searches everything`() {
        val r = search("with what I have")
        assertTrue(r.pantryEmpty)
        assertEquals(4, r.total)
    }
}
