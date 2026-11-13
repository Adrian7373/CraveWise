package com.example.cravewise.domain

import com.example.cravewise.domain.model.Aisle
import com.example.cravewise.domain.model.Ingredient
import com.example.cravewise.domain.model.NutritionPer100g
import com.example.cravewise.domain.model.Protein
import com.example.cravewise.domain.model.RecipeIngredientLine
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class NutritionTest {

    private fun per100(kcal: Double, protein: Double = 0.0, carbs: Double = 0.0, fat: Double = 0.0, sodium: Double = 0.0) =
        NutritionPer100g(fdcId = 1, kcal = kcal, protein = protein, carbs = carbs, fat = fat, fiber = 0.0, sugar = 0.0, sodium = sodium)

    private fun line(id: String, grams: Double?, nutrition: NutritionPer100g?, protein: Protein? = null) =
        RecipeIngredientLine(
            ingredient = Ingredient(id, id, Aisle.Other, emptySet(), isPantryStaple = false, protein = protein, nutrition = nutrition),
            rawName = id, rawMeasure = "", amount = null, amountMax = null, unit = null, note = null, grams = grams,
        )

    private val rice = line("rice", 400.0, per100(360.0, protein = 7.0, carbs = 80.0))
    private val chicken = line("chicken", 600.0, per100(120.0, protein = 23.0, fat = 2.6, sodium = 50.0), Protein.Chicken)
    private val salt = line("salt", 0.0, per100(0.0, sodium = 38758.0)) // "to taste"

    @Test fun sumsGramsTimesPer100AndDividesByServings() {
        val e = Nutrition.estimate(listOf(rice, chicken, salt), recipeServings = 4)
        assertEquals((4 * 360.0 + 6 * 120.0) / 4, e.perServing.kcal, 1e-9)
        assertEquals((4 * 7.0 + 6 * 23.0) / 4, e.perServing.protein, 1e-9)
        assertEquals(6 * 50.0 / 4, e.perServing.sodium, 1e-9) // negligible salt adds nothing
        assertEquals(3, e.coveredLines)
        assertTrue(e.available)
    }

    @Test fun perServingIsInvariantUnderScalingAndTotalFollowsServings() {
        val base = Nutrition.estimate(listOf(rice, chicken), recipeServings = 4)
        val scaled = Nutrition.estimate(listOf(rice, chicken), recipeServings = 4, servings = 6)
        assertEquals(base.perServing, scaled.perServing)
        assertEquals(base.perServing.kcal * 6, scaled.total.kcal, 1e-9)
        assertEquals(6, scaled.servings)
    }

    @Test fun belowCoverageThresholdIsUnavailable() {
        val unknown = (1..2).map { line("x$it", null, null) }
        val e = Nutrition.estimate(listOf(rice, salt) + unknown, recipeServings = 2) // 2 of 4 = 50%
        assertEquals(0.5, e.coverage, 1e-9)
        assertFalse(e.available)
    }

    @Test fun exactlyAtThresholdIsAvailable() {
        val lines = List(7) { line("r$it", 10.0, per100(100.0)) } + List(3) { line("u$it", null, null) }
        assertTrue(Nutrition.estimate(lines, recipeServings = 1).available)
    }

    @Test fun anUnweighedProteinLineHidesTheEstimate() {
        val brisket = line("brisket", null, per100(250.0), Protein.Beef)
        val lines = List(9) { line("s$it", 2.0, per100(300.0)) } + brisket
        val e = Nutrition.estimate(lines, recipeServings = 6)
        assertEquals(0.9, e.coverage, 1e-9)
        assertTrue(e.missingProtein)
        assertFalse(e.available)
    }

    @Test fun weightWithoutNutritionDataIsNotCovered() {
        val e = Nutrition.estimate(listOf(line("paste", 50.0, null)), recipeServings = 1)
        assertEquals(0, e.coveredLines)
        assertFalse(e.available)
    }

    @Test fun emptyRecipeIsUnavailable() {
        assertFalse(Nutrition.estimate(emptyList(), recipeServings = 4).available)
    }
}
