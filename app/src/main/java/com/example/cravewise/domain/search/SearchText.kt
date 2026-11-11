package com.example.cravewise.domain.search

import java.text.Normalizer

/** Tokenizing and word normalization shared by the lexicon, the parser and the ingredient index. */
internal object SearchText {

    /** One query token: [raw] is lower-case as typed (minus punctuation), [word] is normalized. */
    data class Token(val raw: String, val word: String)

    /**
     * Lower-cases, strips accents and apostrophes, splits on anything that isn't a letter or digit
     * and between digits and letters ("30min" → "30", "min"). Commas and "&" survive as their own
     * tokens so they can act as connectors.
     */
    fun tokenize(text: String): List<Token> {
        val cleaned = stripAccents(text.lowercase())
            // "1.5 hours" → "90 min" (the splitter would otherwise read "1" and "5 hours")
            .replace(HALF_HOURS) { "${it.groupValues[1].toInt() * 60 + 30} min" }
            .replace("'", "")
            .replace("’", "")
            .replace(",", " , ")
            .replace("&", " & ")
        return SPLIT.split(cleaned)
            .flatMap { DIGIT_LETTER.split(it) }
            .filter { it.isNotEmpty() }
            .map { Token(raw = it, word = normalizeWord(it)) }
    }

    /** A phrase normalized word by word and joined with single spaces (lexicon / index keys). */
    fun normalizePhrase(phrase: String): String = tokenize(phrase).joinToString(" ") { it.word }

    /**
     * Crude singular form, only needs to be consistent: the same function runs over the query
     * and over every ingredient name. "tomatoes" → "tomato", "berries" → "berry",
     * "dishes" → "dish", "eggs" → "egg"; "hummus", "glass" and "is" are left alone.
     */
    fun normalizeWord(word: String): String {
        val w = word.lowercase()
        if (w.length <= 3 || w.any(Char::isDigit)) return w
        return when {
            w.endsWith("ies") -> w.dropLast(3) + "y"
            w.endsWith("oes") -> w.dropLast(2)
            w.endsWith("ches") || w.endsWith("shes") || w.endsWith("sses") || w.endsWith("xes") -> w.dropLast(2)
            w.endsWith("ss") || w.endsWith("us") || w.endsWith("is") -> w
            w.endsWith("s") -> w.dropLast(1)
            else -> w
        }
    }

    private fun stripAccents(text: String): String =
        Normalizer.normalize(text, Normalizer.Form.NFD).replace(COMBINING, "")

    private val SPLIT = Regex("[^\\p{L}\\p{N},&]+")
    private val DIGIT_LETTER = Regex("(?<=\\d)(?=\\p{L})|(?<=\\p{L})(?=\\d)")
    private val COMBINING = Regex("\\p{Mn}+")
    private val HALF_HOURS = Regex("(\\d+)[.,]5\\s*(?:hours?|hrs?|h)\\b")
}
