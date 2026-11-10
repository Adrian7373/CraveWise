package com.example.cravewise.domain

import com.example.cravewise.domain.model.Allergen
import com.example.cravewise.domain.model.ContainsFlag
import com.example.cravewise.domain.model.Diet
import com.example.cravewise.domain.model.Protein
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class DietRulesTest {

    private fun facts(
        vararg contains: ContainsFlag,
        allergens: Set<Allergen> = emptySet(),
        protein: Protein? = null,
    ) = IngredientFacts(allergens, contains.toSet(), protein)

    private val tomato = facts()
    private val egg = facts(ContainsFlag.Egg, allergens = setOf(Allergen.Eggs), protein = Protein.Egg)
    private val butter = facts(ContainsFlag.Dairy, allergens = setOf(Allergen.Milk))
    private val bacon = facts(ContainsFlag.Pork, protein = Protein.Pork)
    private val prawn = facts(ContainsFlag.Shellfish, allergens = setOf(Allergen.Crustaceans), protein = Protein.Shellfish)
    private val gelatin = facts(ContainsFlag.Gelatin)
    private val wine = facts(ContainsFlag.Alcohol, allergens = setOf(Allergen.Sulphites))
    private val flour = facts(allergens = setOf(Allergen.Gluten))

    @Test fun `plant-only recipe gets every diet`() {
        assertEquals(Diet.entries.toSet(), DietRules.derive(listOf(tomato)).diets)
    }

    @Test fun `egg keeps vegetarian but not vegan`() {
        val diets = DietRules.derive(listOf(tomato, egg)).diets
        assertTrue(Diet.Vegetarian in diets)
        assertFalse(Diet.Vegan in diets)
    }

    @Test fun `dairy removes vegan and dairy-free`() {
        val diets = DietRules.derive(listOf(butter)).diets
        assertFalse(Diet.Vegan in diets)
        assertFalse(Diet.DairyFree in diets)
        assertTrue(Diet.Vegetarian in diets)
    }

    @Test fun `shellfish is pescatarian but not vegetarian`() {
        val diets = DietRules.derive(listOf(prawn)).diets
        assertTrue(Diet.Pescatarian in diets)
        assertFalse(Diet.Vegetarian in diets)
    }

    @Test fun `pork removes vegetarian, pescatarian and no-pork`() {
        val diets = DietRules.derive(listOf(bacon)).diets
        assertFalse(Diet.Vegetarian in diets)
        assertFalse(Diet.Pescatarian in diets)
        assertFalse(Diet.NoPorkNoAlcohol in diets)
    }

    @Test fun `gelatin is treated conservatively as land-animal and pork`() {
        val diets = DietRules.derive(listOf(gelatin)).diets
        assertFalse(Diet.Vegetarian in diets)
        assertFalse(Diet.Pescatarian in diets)
        assertFalse(Diet.NoPorkNoAlcohol in diets)
    }

    @Test fun `alcohol removes only no-pork-no-alcohol`() {
        val diets = DietRules.derive(listOf(wine)).diets
        assertFalse(Diet.NoPorkNoAlcohol in diets)
        assertTrue(Diet.Vegan in diets)
    }

    @Test fun `gluten allergen removes gluten-free`() {
        assertFalse(Diet.GlutenFree in DietRules.derive(listOf(flour)).diets)
    }

    @Test fun `allergens and proteins are the union over all lines`() {
        val derived = DietRules.derive(listOf(egg, butter, prawn, flour))
        assertEquals(setOf(Allergen.Eggs, Allergen.Milk, Allergen.Crustaceans, Allergen.Gluten), derived.allergens)
        assertEquals(setOf(Protein.Egg, Protein.Shellfish), derived.proteins)
    }
}
