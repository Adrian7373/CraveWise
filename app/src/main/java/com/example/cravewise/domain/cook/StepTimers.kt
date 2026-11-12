package com.example.cravewise.domain.cook

/** A duration mentioned in a step ("simmer for 10-15 minutes"). [range] is its span in the text. */
data class StepTimer(
    /** Lower bound for ranges: start the timer, then check. */
    val seconds: Int,
    val label: String,
    val range: IntRange,
)

/**
 * Finds timer-worthy durations in a method step. Handles digits, decimals, ½-style fractions,
 * number words ("ten minutes", "an hour", "half an hour"), ranges ("10-15 mins", "2 to 3 hours")
 * and compound durations ("1 hour 30 minutes"). Durations over a day are ignored.
 */
object StepTimers {

    fun find(text: String): List<StepTimer> {
        val found = mutableListOf<StepTimer>()
        for (m in PATTERN.findAll(text)) {
            // Numbered groups: named-group lookup needs API 26.
            val unit = unitSeconds(m.groupValues[3]) ?: continue
            val low = parse(m.groupValues[1]) ?: continue
            val high = m.groupValues[2].takeIf { it.isNotEmpty() }?.let(::parse)
            val extraMinutes = m.groupValues[4].takeIf { it.isNotEmpty() }?.let(::parse)
            var seconds = low * unit
            if (extraMinutes != null && unit == HOUR) seconds += extraMinutes * MINUTE
            val total = seconds.toInt()
            if (total <= 0 || total > MAX_SECONDS) continue
            val label = if (high != null && high > low && extraMinutes == null) {
                "${number(low)}–${number(high)} ${shortUnit(unit)}"
            } else {
                formatDuration(total)
            }
            if (found.none { it.seconds == total }) found += StepTimer(total, label, m.range)
        }
        return found
    }

    /** "45 sec", "20 min", "1 hr", "1 hr 30 min". */
    fun formatDuration(seconds: Int): String {
        val h = seconds / 3600
        val m = (seconds % 3600) / 60
        val s = seconds % 60
        return buildList {
            if (h > 0) add("$h hr")
            if (m > 0) add("$m min")
            if (s > 0 && h == 0) add("$s sec")
        }.joinToString(" ").ifEmpty { "0 sec" }
    }

    // -----------------------------------------------------------------------------------------

    private const val MINUTE = 60.0
    private const val HOUR = 3600.0
    private const val MAX_SECONDS = 24 * 3600

    private val WORDS = mapOf(
        "a" to 1.0, "an" to 1.0, "one" to 1.0, "two" to 2.0, "three" to 3.0, "four" to 4.0,
        "five" to 5.0, "six" to 6.0, "seven" to 7.0, "eight" to 8.0, "nine" to 9.0, "ten" to 10.0,
        "eleven" to 11.0, "twelve" to 12.0, "fifteen" to 15.0, "twenty" to 20.0, "thirty" to 30.0,
        "forty" to 40.0, "forty-five" to 45.0, "fifty" to 50.0, "sixty" to 60.0,
        "half a" to 0.5, "half an" to 0.5, "a half" to 0.5, "a couple of" to 2.0, "a couple" to 2.0,
    )
    private val GLYPHS = mapOf('¼' to 0.25, '½' to 0.5, '¾' to 0.75, '⅓' to 1.0 / 3, '⅔' to 2.0 / 3)

    private val WORD_ALT = WORDS.keys.sortedByDescending { it.length }.joinToString("|") { Regex.escape(it) }
    private val NUM = """(?:\d+(?:\.\d+)?(?:\s*[¼½¾⅓⅔])?|[¼½¾⅓⅔]|$WORD_ALT)"""
    private val PATTERN = Regex(
        """(?<![\w.])($NUM)(?:\s*(?:-|–|to|or)\s*($NUM))?\s*""" +
            """(hours?|hrs?|minutes?|mins?|seconds?|secs?)\b""" +
            """(?:\s*(?:and\s*)?(\d+)\s*(?:minutes?|mins?)\b)?""",
        RegexOption.IGNORE_CASE,
    )

    private fun unitSeconds(unit: String): Double? = when (unit.lowercase().trimEnd('s')) {
        "hour", "hr" -> HOUR
        "minute", "min" -> MINUTE
        "second", "sec" -> 1.0
        else -> null
    }

    private fun shortUnit(unitSeconds: Double): String = when (unitSeconds) {
        HOUR -> "hr"
        MINUTE -> "min"
        else -> "sec"
    }

    private fun parse(text: String): Double? {
        val t = text.trim().lowercase()
        WORDS[t]?.let { return it }
        val glyph = t.lastOrNull()?.let(GLYPHS::get)
        val digits = if (glyph != null) t.dropLast(1).trim() else t
        val whole = if (digits.isEmpty()) 0.0 else digits.toDoubleOrNull() ?: return null
        return whole + (glyph ?: 0.0)
    }

    private fun number(value: Double): String =
        if (value == Math.floor(value)) value.toLong().toString() else value.toString()
}
