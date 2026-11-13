package com.example.cravewise.domain

import com.example.cravewise.domain.model.RecipeIngredientLine

/** Nutrient amounts: energy in kcal, sodium in mg, the rest in grams. */
data class NutrientAmounts(
    val kcal: Double = 0.0,
    val protein: Double = 0.0,
    val carbs: Double = 0.0,
    val fat: Double = 0.0,
    val fiber: Double = 0.0,
    val sugar: Double = 0.0,
    val sodium: Double = 0.0,
) {
    operator fun plus(o: NutrientAmounts) = NutrientAmounts(
        kcal + o.kcal, protein + o.protein, carbs + o.carbs, fat + o.fat,
        fiber + o.fiber, sugar + o.sugar, sodium + o.sodium,
    )

    operator fun times(k: Double) = NutrientAmounts(
        kcal * k, protein * k, carbs * k, fat * k, fiber * k, sugar * k, sodium * k,
    )

    operator fun div(k: Double) = times(1.0 / k)
}

/**
 * A recipe's estimated nutrition. [perServing] doesn't change with scaling; [total] is for the
 * servings asked for. Only show numbers when [available].
 */
data class NutritionEstimate(
    val perServing: NutrientAmounts,
    val total: NutrientAmounts,
    val servings: Int,
    /** Lines that were weighed and have nutrition data ("to taste" lines count as covered). */
    val coveredLines: Int,
    val totalLines: Int,
    /** A meat/fish/egg/legume line couldn't be weighed, so the estimate would miss the main thing. */
    val missingProtein: Boolean,
) {
    val coverage: Double get() = if (totalLines == 0) 0.0 else coveredLines.toDouble() / totalLines

    val available: Boolean
        get() = totalLines > 0 && coverage >= Nutrition.COVERAGE_THRESHOLD && !missingProtein
}

/**
 * Nutrition from per-line grams (worked out by tools/seedgen) × each ingredient's USDA values per
 * 100 g. Pure. Uncovered lines are left out, so the result is a lower bound; [NutritionEstimate.available]
 * hides it when too much is missing.
 */
object Nutrition {
    /** Share of ingredient lines that must be covered before we show numbers. */
    const val COVERAGE_THRESHOLD = 0.70

    fun estimate(lines: List<RecipeIngredientLine>, recipeServings: Int, servings: Int = recipeServings): NutritionEstimate {
        var covered = 0
        var missingProtein = false
        var sum = NutrientAmounts()
        for (line in lines) {
            val grams = line.grams
            val per100 = line.ingredient.nutrition
            when {
                grams != null && grams == 0.0 -> covered++
                grams != null && per100 != null -> {
                    covered++
                    val k = grams / 100.0
                    sum += NutrientAmounts(
                        per100.kcal * k, per100.protein * k, per100.carbs * k, per100.fat * k,
                        per100.fiber * k, per100.sugar * k, per100.sodium * k,
                    )
                }
                line.ingredient.protein != null -> missingProtein = true
            }
        }
        val perServing = sum / recipeServings.coerceAtLeast(1).toDouble()
        val target = servings.coerceAtLeast(1)
        return NutritionEstimate(
            perServing = perServing,
            total = perServing * target.toDouble(),
            servings = target,
            coveredLines = covered,
            totalLines = lines.size,
            missingProtein = missingProtein,
        )
    }
}
