package com.example.cravewise.domain.search

import com.example.cravewise.domain.model.Aisle
import com.example.cravewise.domain.model.Allergen
import com.example.cravewise.domain.model.Diet
import com.example.cravewise.domain.model.Ingredient
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.model.Protein
import com.example.cravewise.domain.model.Texture
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class QueryParserTest {

    private fun ing(id: String, name: String, vararg synonyms: String) =
        Ingredient(id, name, Aisle.Produce, emptySet(), isPantryStaple = false, synonyms = (synonyms.toSet() + name.lowercase()))

    private val parser = QueryParser(
        ingredients = listOf(
            ing("mushroom", "Mushrooms", "mushroom"),
            ing("shiitake", "Shiitake Mushrooms"),
            ing("sweet_potato", "Sweet Potato"),
            ing("potato", "Potato", "potatoes"),
            ing("rice", "Rice"),
            ing("rice_vinegar", "Rice Vinegar"),
            ing("olive", "Olives"),
            ing("chicken_breast", "Chicken Breast"),
            ing("aubergine", "Aubergine", "eggplant"),
        ),
        cuisines = listOf("Thai", "Italian"),
    )

    private fun parse(q: String) = parser.parse(q)

    @Test fun `blank and filler-only queries are empty`() {
        assertTrue(parse("").isEmpty)
        assertTrue(parse("   ").isEmpty)
        assertTrue(parse("I want something please").isEmpty)
    }

    @Test fun `craving words become flavor wants`() {
        assertEquals(listOf(Want.Flavor(Taste.Salty, 3)), parse("something salty").wants)
        assertEquals(listOf(Want.Flavor(Taste.Sour, 3)), parse("Tangy!").wants)
        assertEquals(listOf(Want.Flavor(Taste.Spicy, 4)), parse("very spicy").wants)
    }

    @Test fun `repeats are not duplicated`() {
        assertEquals(listOf(Want.Flavor(Taste.Spicy, 3)), parse("spicy, hot, fiery").wants)
    }

    @Test fun `texture mood and quick`() {
        val q = parse("creamy comfort food, quick")
        assertEquals(listOf(Want.TextureIs(Texture.Creamy), Want.MoodIs(com.example.cravewise.domain.model.Mood.Comfort)), q.wants)
        assertEquals(30, q.maxMinutes)
    }

    @Test fun `time phrases`() {
        assertEquals(20, parse("under 20 min").maxMinutes)
        assertEquals(60, parse("ready in 1 hour").maxMinutes)
        assertEquals(30, parse("30min").maxMinutes)
        assertEquals(30, parse("half an hour").maxMinutes)
        assertEquals(60, parse("less than an hour").maxMinutes)
        assertEquals(90, parse("1.5 hours").maxMinutes)
        assertEquals(15, parse("quick, under 15 minutes").maxMinutes) // tightest wins
        assertNull(parse("under 5 ingredients").maxMinutes)
    }

    @Test fun `longest phrase wins so sweet potato is an ingredient`() {
        val q = parse("sweet potato")
        assertEquals(1, q.wants.size)
        val uses = q.wants.single() as Want.Uses
        assertEquals(setOf("sweet_potato"), uses.ingredientIds)
    }

    @Test fun `ingredient family follows the head noun`() {
        assertEquals(setOf("mushroom", "shiitake"), (parse("mushrooms").wants.single() as Want.Uses).ingredientIds)
        assertEquals(setOf("rice"), (parse("rice").wants.single() as Want.Uses).ingredientIds)
        assertEquals(setOf("potato", "sweet_potato"), (parse("potatoes").wants.single() as Want.Uses).ingredientIds)
        assertEquals(setOf("aubergine"), (parse("eggplant").wants.single() as Want.Uses).ingredientIds)
    }

    @Test fun `negation carries across food lists but not onto cravings`() {
        val q = parse("no mushrooms or olives, spicy")
        assertEquals(
            listOf(
                Exclusion.Ingredients(setOf("mushroom", "shiitake"), "mushrooms"),
                Exclusion.Ingredients(setOf("olive"), "olives"),
            ),
            q.exclusions,
        )
        assertEquals(listOf(Want.Flavor(Taste.Spicy, 3)), q.wants)
    }

    @Test fun `negation survives filler and other negators`() {
        assertEquals(1, parse("without any mushrooms").exclusions.size)
        assertEquals(1, parse("I hate olives").exclusions.size)
        assertTrue(parse("I hate olives").wants.isEmpty())
    }

    @Test fun `no dairy and quick keeps quick positive`() {
        val q = parse("no dairy and quick")
        assertEquals(listOf(Exclusion.Allergens(setOf(Allergen.Milk), "dairy")), q.exclusions)
        assertEquals(30, q.maxMinutes)
    }

    @Test fun `x-free means without x, but diet phrases are diets`() {
        val q = parse("nut-free dessert")
        assertEquals(listOf(Exclusion.Allergens(setOf(Allergen.TreeNuts, Allergen.Peanuts), "nuts")), q.exclusions)
        assertEquals(setOf(MealType.Dessert), q.mealTypes)

        val gf = parse("gluten free")
        assertEquals(setOf(Diet.GlutenFree), gf.diets)
        assertTrue(gf.exclusions.isEmpty())
    }

    @Test fun `not spicy and mild cap the heat`() {
        val expected = listOf(Exclusion.TasteAbove(Taste.Spicy, 1, "Mild"))
        assertEquals(expected, parse("not spicy").exclusions)
        assertEquals(expected, parse("mild").exclusions)
        assertTrue(parse("not spicy").wants.isEmpty())
    }

    @Test fun `no fish also drops fish allergen`() {
        assertEquals(
            listOf(Exclusion.Proteins(setOf(Protein.Fish), "fish", setOf(Allergen.Fish))),
            parse("no fish").exclusions,
        )
    }

    @Test fun `cuisine and protein`() {
        val q = parse("Thai chicken")
        assertEquals(setOf("Thai"), q.cuisines)
        assertEquals(listOf(Want.ProteinIs(setOf(Protein.Chicken), "Chicken")), q.wants)
        // A longer ingredient phrase beats the protein word.
        assertEquals(setOf("chicken_breast"), (parse("chicken breast").wants.single() as Want.Uses).ingredientIds)
    }

    @Test fun `pantry phrases`() {
        val q = parse("What can I make with what I have?")
        assertTrue(q.usePantry)
        assertTrue(q.wants.isEmpty())
        assertFalse(q.isEmpty)
    }

    @Test fun `unknown words become text terms, accents stripped`() {
        assertEquals(listOf(Want.Text("pad"), Want.Text("krapow")), parse("pad krapow").wants)
        assertEquals(listOf(Want.Text("creme"), Want.Text("brulee")), parse("Crème brûlée").wants)
        assertEquals(setOf("creme", "brulee"), parse("Crème brûlée").textTerms)
    }

    @Test fun `chips list wants, filters, exclusions and pantry`() {
        val labels = parse("salty Italian, no olives, under 20 min, with what I have").chips.map { it.label }
        assertEquals(listOf("Salty", "Italian", "Under 20 min", "No olives", "Using my kitchen"), labels)
    }
}
