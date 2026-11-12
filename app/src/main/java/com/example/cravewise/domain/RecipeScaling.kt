package com.example.cravewise.domain

import com.example.cravewise.domain.model.RecipeIngredientLine
import kotlin.math.abs

/**
 * Servings scaling. Amounts are multiplied by `target / base`; the recipe's own wording is kept
 * ("450 grams Boneless skin" → "900 grams Boneless skin") with only the leading number swapped and
 * a known unit word re-pluralized ("1 clove" → "2 cloves"). Lines without a parsed amount
 * ("To taste") never scale.
 */
object RecipeScaling {

    const val MIN_SERVINGS = 1
    const val MAX_SERVINGS = 24

    fun factor(baseServings: Int, targetServings: Int): Double =
        if (baseServings <= 0 || targetServings <= 0) 1.0 else targetServings.toDouble() / baseServings

    fun clampServings(servings: Int): Int = servings.coerceIn(MIN_SERVINGS, MAX_SERVINGS)

    fun isScaled(factor: Double): Boolean = abs(factor - 1.0) > EPS

    /** The measure to show for [line] at [factor]. Returns the original text when nothing scales. */
    fun measure(line: RecipeIngredientLine, factor: Double): String {
        val raw = line.rawMeasure.trim()
        val amount = line.amount
        if (!isScaled(factor) || amount == null) return raw

        val min = amount * factor
        val max = line.amountMax?.times(factor)
        val number = if (max != null && max - min > EPS) {
            "${ShoppingQuantities.number(min, line.unit)}–${ShoppingQuantities.number(max, line.unit)}"
        } else {
            ShoppingQuantities.number(min, line.unit)
        }
        val match = LEADING_NUMBER.find(raw)
            // "Handful", "sprigs of fresh": the amount is implied, so show it as a multiplier.
            ?: return if (raw.isEmpty()) number else "$number × $raw"
        val rest = raw.substring(match.range.last + 1)
        return number + repluralize(rest, plural = (max ?: min) > 1 + PLURAL_TOLERANCE)
    }

    /** Fixes the first word after the number when it's a unit we know the forms of. */
    private fun repluralize(rest: String, plural: Boolean): String {
        val m = FIRST_WORD.find(rest) ?: return rest
        val (space, word, tail) = m.destructured
        val lower = word.lowercase()
        val replacement = when {
            plural -> PLURALS[lower]
            else -> SINGULARS[lower]
        } ?: return rest
        val cased = if (word.first().isUpperCase()) replacement.replaceFirstChar { it.uppercase() } else replacement
        return space + cased + tail
    }

    private const val EPS = 1e-6
    private const val PLURAL_TOLERANCE = 0.01

    // The optional glyph owns its leading space, so a bare "2 cups" leaves " cups" untouched.
    private const val NUM = """\d+\s+\d+/\d+|\d+/\d+|\d+(?:[.,]\d+)?(?:\s*[¼½¾⅓⅔⅛])?|[¼½¾⅓⅔⅛]"""
    private val LEADING_NUMBER = Regex("""^(?:$NUM)(?:\s*(?:-|–|to)\s*(?:$NUM))?""")
    private val FIRST_WORD = Regex("""^(\s*)([A-Za-z]+)(.*)$""", RegexOption.DOT_MATCHES_ALL)

    private val FORMS: List<Pair<String, String>> = listOf(
        "clove" to "cloves", "cup" to "cups", "tablespoon" to "tablespoons", "teaspoon" to "teaspoons",
        "pinch" to "pinches", "dash" to "dashes", "splash" to "splashes", "bunch" to "bunches",
        "leaf" to "leaves", "sprig" to "sprigs", "slice" to "slices", "can" to "cans", "tin" to "tins",
        "handful" to "handfuls", "stalk" to "stalks", "stick" to "sticks", "piece" to "pieces",
        "packet" to "packets", "sheet" to "sheets", "head" to "heads", "knob" to "knobs",
        "drop" to "drops", "jar" to "jars", "bottle" to "bottles", "pound" to "pounds",
        "ounce" to "ounces", "gram" to "grams", "litre" to "litres", "liter" to "liters",
        "kilogram" to "kilograms", "fillet" to "fillets", "rasher" to "rashers", "strip" to "strips",
        "bag" to "bags", "block" to "blocks", "cube" to "cubes", "pod" to "pods", "scoop" to "scoops",
    )
    private val PLURALS = FORMS.toMap()
    private val SINGULARS = FORMS.associate { (one, many) -> many to one }
}
