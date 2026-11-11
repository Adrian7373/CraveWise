package com.example.cravewise.domain

import com.example.cravewise.domain.model.MeasureUnit
import com.example.cravewise.domain.model.ShoppingShare
import java.util.Locale
import kotlin.math.abs
import kotlin.math.floor
import kotlin.math.roundToLong

/**
 * Merges the amounts of one shopping item across recipes into a single display string.
 *
 * Mass (g, kg, oz, lb) and volume (ml, l, tsp, tbsp, cup, fl oz) are converted and summed. Any
 * other unit only sums with itself, and plain counts ("2 eggs") sum with plain counts. What can't
 * be combined is joined with " + " ("2 cloves + 1 tbsp"); unparsed text ("to taste") is appended.
 */
object ShoppingQuantities {

    fun format(shares: List<ShoppingShare>): String? {
        val parts = LinkedHashMap<Group, Total>()
        val texts = LinkedHashSet<String>()
        for (share in shares) {
            val amount = share.amount
            if (amount == null) {
                share.rawMeasure.trim().takeIf { it.isNotEmpty() }?.let { texts += it.lowercase() }
                continue
            }
            val group = groupOf(share.unit)
            val factor = group.factorOf(share.unit)
            val total = parts.getOrPut(group) { Total() }
            total.min += amount * factor
            total.max += (share.amountMax ?: amount) * factor
            share.unit?.let { total.units += it }
        }
        val rendered = parts.map { (group, total) -> group.render(total) } + texts
        return rendered.takeIf { it.isNotEmpty() }?.joinToString(" + ")
    }

    // -----------------------------------------------------------------------------------------

    private class Total(var min: Double = 0.0, var max: Double = 0.0, val units: MutableSet<MeasureUnit> = mutableSetOf())

    private sealed interface Group {
        fun factorOf(unit: MeasureUnit?): Double
        fun render(total: Total): String

        data object Mass : Group {
            override fun factorOf(unit: MeasureUnit?) = MASS_GRAMS.getValue(unit!!)
            override fun render(total: Total): String {
                val imperial = total.units.all { it == MeasureUnit.Oz || it == MeasureUnit.Lb }
                return if (imperial) {
                    val oz = GRAMS_PER_OZ
                    if (total.min >= 16 * oz) amount(total, 16 * oz, MeasureUnit.Lb) else amount(total, oz, MeasureUnit.Oz)
                } else {
                    if (total.min >= 1000) amount(total, 1000.0, MeasureUnit.Kg) else amount(total, 1.0, MeasureUnit.G)
                }
            }
        }

        data object Volume : Group {
            override fun factorOf(unit: MeasureUnit?) = VOLUME_ML.getValue(unit!!)
            override fun render(total: Total): String {
                val kitchen = total.units.all { it in KITCHEN_VOLUME }
                return if (kitchen) {
                    val tsp = VOLUME_ML.getValue(MeasureUnit.Tsp)
                    val tbsp = VOLUME_ML.getValue(MeasureUnit.Tbsp)
                    val cup = VOLUME_ML.getValue(MeasureUnit.Cup)
                    when {
                        total.min < tbsp - EPS -> amount(total, tsp, MeasureUnit.Tsp)
                        total.min < cup / 4 - EPS -> amount(total, tbsp, MeasureUnit.Tbsp)
                        else -> amount(total, cup, MeasureUnit.Cup)
                    }
                } else {
                    if (total.min >= 1000) amount(total, 1000.0, MeasureUnit.L) else amount(total, 1.0, MeasureUnit.Ml)
                }
            }
        }

        /** A unit that only sums with itself; `null` = plain count. */
        data class Same(val unit: MeasureUnit?) : Group {
            override fun factorOf(unit: MeasureUnit?) = 1.0
            override fun render(total: Total) = amount(total, 1.0, unit)
        }
    }

    private fun groupOf(unit: MeasureUnit?): Group = when (unit) {
        in MASS_GRAMS -> Group.Mass
        in VOLUME_ML -> Group.Volume
        else -> Group.Same(unit)
    }

    private fun amount(total: Total, perUnit: Double, unit: MeasureUnit?): String {
        val min = total.min / perUnit
        val max = total.max / perUnit
        val number = if (max - min > EPS) "${number(min, unit)}–${number(max, unit)}" else number(min, unit)
        // Loose tolerance: unit conversions leave float noise (½ cup + 8 tbsp = 1.0000017 cups).
        val label = unit?.let { label(it, plural = max > 1 + PLURAL_TOLERANCE) } ?: return number
        return "$number $label"
    }

    /** Metric units get decimals; spoons, cups, imperial and counts get kitchen fractions. */
    internal fun number(value: Double, unit: MeasureUnit?): String =
        if (unit in METRIC) decimal(value) else fraction(value)

    private fun decimal(value: Double): String {
        if (value >= 10) return value.roundToLong().toString()
        val rounded = (value * 100).roundToLong() / 100.0
        return if (rounded == floor(rounded)) {
            rounded.toLong().toString()
        } else {
            String.format(Locale.ROOT, "%.2f", rounded).trimEnd('0').trimEnd('.')
        }
    }

    private fun fraction(value: Double): String {
        val whole = floor(value)
        val rest = value - whole
        val nearest = FRACTIONS.minBy { abs(it.first - rest) }
        if (abs(nearest.first - rest) > FRACTION_TOLERANCE) return decimal(value)
        val w = whole.toLong() + if (nearest.first == 1.0) 1 else 0
        val glyph = nearest.second
        return when {
            glyph.isEmpty() -> w.toString()
            w == 0L -> glyph
            else -> "$w$glyph"
        }
    }

    internal fun label(unit: MeasureUnit, plural: Boolean): String {
        val (one, many) = LABELS.getValue(unit)
        return if (plural) many else one
    }

    private const val EPS = 1e-6
    private const val FRACTION_TOLERANCE = 0.04
    private const val PLURAL_TOLERANCE = 0.01
    private const val GRAMS_PER_OZ = 28.3495

    private val MASS_GRAMS = mapOf(
        MeasureUnit.G to 1.0,
        MeasureUnit.Kg to 1000.0,
        MeasureUnit.Oz to GRAMS_PER_OZ,
        MeasureUnit.Lb to 453.592,
    )

    private val VOLUME_ML = mapOf(
        MeasureUnit.Ml to 1.0,
        MeasureUnit.L to 1000.0,
        MeasureUnit.Tsp to 4.92892,
        MeasureUnit.Tbsp to 14.7868,
        MeasureUnit.Cup to 236.588,
        MeasureUnit.FlOz to 29.5735,
    )

    private val KITCHEN_VOLUME = setOf(MeasureUnit.Tsp, MeasureUnit.Tbsp, MeasureUnit.Cup, MeasureUnit.FlOz)
    private val METRIC = setOf(MeasureUnit.G, MeasureUnit.Kg, MeasureUnit.Ml, MeasureUnit.L, MeasureUnit.Cm)

    private val FRACTIONS = listOf(
        0.0 to "", 0.25 to "¼", 1.0 / 3 to "⅓", 0.5 to "½", 2.0 / 3 to "⅔", 0.75 to "¾", 1.0 to "",
    )

    private val LABELS: Map<MeasureUnit, Pair<String, String>> = MeasureUnit.entries.associateWith { unit ->
        when (unit) {
            MeasureUnit.G -> "g" to "g"
            MeasureUnit.Kg -> "kg" to "kg"
            MeasureUnit.Ml -> "ml" to "ml"
            MeasureUnit.L -> "l" to "l"
            MeasureUnit.Tsp -> "tsp" to "tsp"
            MeasureUnit.Tbsp -> "tbsp" to "tbsp"
            MeasureUnit.Cup -> "cup" to "cups"
            MeasureUnit.Oz -> "oz" to "oz"
            MeasureUnit.FlOz -> "fl oz" to "fl oz"
            MeasureUnit.Lb -> "lb" to "lb"
            MeasureUnit.Cm -> "cm" to "cm"
            MeasureUnit.Pinch -> "pinch" to "pinches"
            MeasureUnit.Dash -> "dash" to "dashes"
            MeasureUnit.Splash -> "splash" to "splashes"
            MeasureUnit.Bunch -> "bunch" to "bunches"
            MeasureUnit.Leaf -> "leaf" to "leaves"
            else -> unit.name.lowercase().let { it to "${it}s" }
        }
    }
}
