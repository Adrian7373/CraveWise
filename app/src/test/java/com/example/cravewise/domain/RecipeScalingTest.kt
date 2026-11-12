package com.example.cravewise.domain

import com.example.cravewise.domain.model.Aisle
import com.example.cravewise.domain.model.Ingredient
import com.example.cravewise.domain.model.MeasureUnit
import com.example.cravewise.domain.model.RecipeIngredientLine
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class RecipeScalingTest {

    private val ingredient = Ingredient("x", "X", Aisle.Other, emptySet(), isPantryStaple = false)

    private fun line(raw: String, amount: Double?, unit: MeasureUnit? = null, max: Double? = null) =
        RecipeIngredientLine(ingredient, "x", raw, amount, max, unit, note = null)

    @Test fun factorIsTargetOverBase() {
        assertEquals(2.0, RecipeScaling.factor(2, 4), 1e-9)
        assertEquals(0.5, RecipeScaling.factor(4, 2), 1e-9)
        assertEquals(1.0, RecipeScaling.factor(0, 4), 1e-9) // bad data never scales
        assertFalse(RecipeScaling.isScaled(1.0))
        assertTrue(RecipeScaling.isScaled(1.5))
    }

    @Test fun clampsServings() {
        assertEquals(1, RecipeScaling.clampServings(0))
        assertEquals(RecipeScaling.MAX_SERVINGS, RecipeScaling.clampServings(99))
    }

    @Test fun unscaledKeepsOriginalText() {
        assertEquals("5 tablespoons", RecipeScaling.measure(line("5 tablespoons", 5.0, MeasureUnit.Tbsp), 1.0))
    }

    @Test fun unparsedNeverScales() {
        assertEquals("To taste", RecipeScaling.measure(line("To taste", null), 2.0))
    }

    @Test fun keepsWordingAndSwapsNumber() {
        assertEquals("900 grams Boneless skin", RecipeScaling.measure(line("450 grams Boneless skin", 450.0, MeasureUnit.G), 2.0))
        assertEquals("600g", RecipeScaling.measure(line("400g", 400.0, MeasureUnit.G), 1.5))
        assertEquals("8 sliced", RecipeScaling.measure(line("4 sliced", 4.0), 2.0))
        assertEquals("6 x 7.5cm", RecipeScaling.measure(line("3 x 7.5cm", 3.0), 2.0))
    }

    @Test fun usesKitchenFractions() {
        assertEquals("⅔ cup", RecipeScaling.measure(line("1/3 cup", 0.333, MeasureUnit.Cup), 2.0))
        assertEquals("1½", RecipeScaling.measure(line("1", 1.0), 1.5))
        assertEquals("¼ tsp", RecipeScaling.measure(line("½ tsp", 0.5, MeasureUnit.Tsp), 0.5))
    }

    @Test fun repluralizesKnownUnitWords() {
        assertEquals("2 cloves", RecipeScaling.measure(line("1 clove", 1.0, MeasureUnit.Clove), 2.0))
        assertEquals("1 clove", RecipeScaling.measure(line("2 cloves", 2.0, MeasureUnit.Clove), 0.5))
        assertEquals("3 Tablespoons", RecipeScaling.measure(line("1 Tablespoon", 1.0, MeasureUnit.Tbsp), 3.0))
        assertEquals("2 tbsp", RecipeScaling.measure(line("1 tbsp", 1.0, MeasureUnit.Tbsp), 2.0))
    }

    @Test fun scalesRanges() {
        assertEquals("4–6 cups", RecipeScaling.measure(line("2-3 cups", 2.0, MeasureUnit.Cup, max = 3.0), 2.0))
    }

    @Test fun impliedAmountBecomesMultiplier() {
        assertEquals("2 × Handful", RecipeScaling.measure(line("Handful", 1.0, MeasureUnit.Handful), 2.0))
    }
}
