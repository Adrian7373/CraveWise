package com.example.cravewise.domain.search

import com.example.cravewise.domain.model.Diet
import com.example.cravewise.domain.model.Difficulty
import com.example.cravewise.domain.model.Ingredient
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.search.SearchText.Token

/**
 * Turns free text ("creamy chicken, no mushrooms, under 30 min") into a [SearchQuery] using the
 * fixed [SearchLexicon] plus the catalog's cuisines and ingredients. Pure and deterministic.
 *
 * Phrases match longest-first, so "sweet potato" is an ingredient, not "sweet". For the same
 * phrase, fixed lexicon entries win over cuisines, which win over ingredients. Words the lexicon
 * doesn't know become full-text terms.
 *
 * Build one per catalog version (it indexes every ingredient name) and reuse it.
 */
class QueryParser(ingredients: List<Ingredient>, cuisines: Collection<String>) {

    private val phrases: Map<String, Concept>
    private val maxSpan: Int

    init {
        val map = HashMap<String, Concept>(SearchLexicon.concepts)
        cuisines.forEach { cuisine ->
            map.putIfAbsent(SearchText.normalizePhrase(cuisine), Concept.CuisineC(cuisine))
        }
        ingredientFamilies(ingredients).forEach { (key, ids) -> map.putIfAbsent(key, Concept.IngredientC(ids)) }
        phrases = map
        maxSpan = map.keys.maxOfOrNull { key -> key.count { it == ' ' } + 1 } ?: 1
    }

    fun parse(raw: String): SearchQuery {
        val tokens = SearchText.tokenize(raw)
        val b = Builder(raw)
        var i = 0
        var negate = false // an explicit "no"/"without" is pending
        var carried = false // the last thing was a negated food...
        var joined = false // ...followed by "or"/"and": the negation carries on to the next food
        var intense = false
        while (i < tokens.size) {
            val time = parseTime(tokens, i)
            if (time != null) {
                b.maxMinutes(time.first)
                i += time.second
                negate = false; carried = false; joined = false
                continue
            }
            val match = longestPhrase(tokens, i)
            val negLen = negatorLength(tokens, i)
            if (negLen > 0 && negLen >= (match?.span ?: 0)) {
                negate = true; carried = false; joined = false
                i += negLen
                continue
            }
            if (match != null) {
                var span = match.span
                val postFree = tokens.getOrNull(i + span)?.word == FREE // "nut free"
                if (postFree) span++
                val neg = negate || postFree || (carried && joined && match.concept.isFoodItem)
                b.add(match.concept, match.text, neg, intense)
                carried = neg && match.concept.isFoodItem
                negate = false; joined = false; intense = false
                i += span
                continue
            }
            val t = tokens[i]
            when (t.raw) {
                in SearchLexicon.connectors -> {
                    joined = carried
                    i++
                }
                in SearchLexicon.intensifiers -> {
                    intense = true
                    i++
                }
                // Filler keeps a pending negation alive: "without any mushrooms".
                in SearchLexicon.stopWords -> i++
                else -> {
                    var span = 1
                    val postFree = tokens.getOrNull(i + 1)?.word == FREE
                    if (postFree) span++
                    val neg = negate || postFree || (carried && joined)
                    if (t.raw.length >= MIN_TERM_LENGTH && t.raw.any(Char::isLetter)) b.text(t.raw, neg)
                    carried = neg
                    negate = false; joined = false; intense = false
                    i += span
                }
            }
        }
        return b.build()
    }

    private data class PhraseMatch(val concept: Concept, val span: Int, val text: String)

    private fun longestPhrase(tokens: List<Token>, start: Int): PhraseMatch? {
        val longest = minOf(maxSpan, tokens.size - start)
        for (span in longest downTo 1) {
            val slice = tokens.subList(start, start + span)
            val concept = phrases[slice.joinToString(" ") { it.word }] ?: continue
            return PhraseMatch(concept, span, slice.joinToString(" ") { it.raw })
        }
        return null
    }

    private fun negatorLength(tokens: List<Token>, start: Int): Int {
        for (span in minOf(MAX_NEGATOR_SPAN, tokens.size - start) downTo 1) {
            val key = tokens.subList(start, start + span).joinToString(" ") { it.word }
            if (key in SearchLexicon.negators) return span
        }
        return 0
    }

    /** "under 20 min", "in 1 hour", "30min", "half an hour", "less than an hour" → (minutes, tokens used). */
    private fun parseTime(tokens: List<Token>, start: Int): Pair<Int, Int>? {
        fun raw(k: Int) = tokens.getOrNull(k)?.raw
        var j = start
        val lead = TIME_LEADS.firstOrNull { words -> words.indices.all { raw(start + it) == words[it] } }
        if (lead != null) j += lead.size

        // "half an hour" / "half hour"
        if (raw(j) == "half") {
            val k = if (raw(j + 1) == "an" || raw(j + 1) == "a") j + 2 else j + 1
            if (raw(k) in HOUR_UNITS) return 30 to (k + 1 - start)
        }
        val word = raw(j) ?: return null
        val amount = word.toIntOrNull() ?: NUMBER_WORDS[word] ?: return null
        val unit = raw(j + 1)
        val minutes = when {
            unit in MINUTE_UNITS -> amount
            unit in HOUR_UNITS -> amount * 60
            // A bare number after a lead is minutes ("under 30", "under 30, spicy"), unless a
            // word follows ("under 5 ingredients"). "a"/"an" always need "hour".
            lead != null && word.toIntOrNull() != null && (unit == null || unit in SearchLexicon.connectors) ->
                return amount.takeIf { it in 1..MAX_MINUTES }?.let { it to (j + 1 - start) }
            else -> return null
        }
        if (word in ARTICLE_NUMBERS && unit !in HOUR_UNITS) return null
        return minutes.takeIf { it in 1..MAX_MINUTES }?.let { it to (j + 2 - start) }
    }

    /** Builds the query, de-duplicating repeats ("spicy, hot"). */
    private class Builder(val raw: String) {
        val wants = mutableListOf<Want>()
        val mealTypes = linkedSetOf<MealType>()
        val cuisines = linkedSetOf<String>()
        val diets = linkedSetOf<Diet>()
        var maxMinutes: Int? = null
        var difficulty: Difficulty? = null
        val exclusions = mutableListOf<Exclusion>()
        var usePantry = false

        fun maxMinutes(minutes: Int) {
            maxMinutes = maxMinutes?.let { minOf(it, minutes) } ?: minutes
        }

        fun want(w: Want) {
            if (w !in wants) wants += w
        }

        fun exclude(e: Exclusion) {
            if (e !in exclusions) exclusions += e
        }

        fun text(term: String, negated: Boolean) =
            if (negated) exclude(Exclusion.Text(term)) else want(Want.Text(term))

        fun add(concept: Concept, text: String, negated: Boolean, intense: Boolean) {
            when (concept) {
                is Concept.TasteC ->
                    if (negated) {
                        val label = if (concept.taste == Taste.Spicy) "Mild" else "Not ${concept.taste.label.lowercase()}"
                        exclude(Exclusion.TasteAbove(concept.taste, SearchQuery.MILD_MAX, label))
                    } else {
                        want(Want.Flavor(concept.taste, if (intense) SearchQuery.TASTE_STRONG_MIN else SearchQuery.TASTE_MIN))
                    }
                Concept.MildC ->
                    if (!negated) exclude(Exclusion.TasteAbove(Taste.Spicy, SearchQuery.MILD_MAX, "Mild"))
                is Concept.TextureC ->
                    if (negated) exclude(Exclusion.TextureIs(concept.texture)) else want(Want.TextureIs(concept.texture))
                is Concept.MoodC ->
                    if (negated) exclude(Exclusion.MoodIs(concept.mood)) else want(Want.MoodIs(concept.mood))
                is Concept.MealC ->
                    if (negated) exclude(Exclusion.MealTypeIs(concept.mealType)) else mealTypes += concept.mealType
                is Concept.CuisineC ->
                    if (negated) exclude(Exclusion.CuisineIs(concept.cuisine)) else cuisines += concept.cuisine
                is Concept.DietC -> if (!negated) diets += concept.diet
                is Concept.DifficultyC ->
                    if (negated) exclude(Exclusion.DifficultyIs(concept.difficulty)) else difficulty = concept.difficulty
                is Concept.QuickC -> if (!negated) maxMinutes(concept.maxMinutes)
                Concept.PantryC -> if (!negated) usePantry = true
                is Concept.ProteinC ->
                    if (negated) {
                        exclude(Exclusion.Proteins(concept.proteins, concept.label.lowercase(), concept.negAllergens))
                    } else {
                        want(Want.ProteinIs(concept.proteins, concept.label))
                    }
                is Concept.AllergenC ->
                    if (negated) exclude(Exclusion.Allergens(concept.allergens, concept.label)) else text(text, negated = false)
                is Concept.IngredientC ->
                    if (negated) {
                        exclude(Exclusion.Ingredients(concept.ingredientIds, text))
                    } else {
                        want(Want.Uses(concept.ingredientIds, text, text.replaceFirstChar { it.uppercase() }))
                    }
            }
        }

        fun build(): SearchQuery {
            val chips = buildList {
                wants.forEach { add(QueryChip(it.label, QueryChip.Kind.Want)) }
                mealTypes.forEach { add(QueryChip(it.label, QueryChip.Kind.Filter)) }
                cuisines.forEach { add(QueryChip(it, QueryChip.Kind.Filter)) }
                diets.forEach { add(QueryChip(it.label, QueryChip.Kind.Filter)) }
                maxMinutes?.let { add(QueryChip(formatMinutes(it), QueryChip.Kind.Filter)) }
                difficulty?.let { add(QueryChip(it.label, QueryChip.Kind.Filter)) }
                exclusions.forEach { add(QueryChip(it.label, QueryChip.Kind.Exclude)) }
                if (usePantry) add(QueryChip("Using my kitchen", QueryChip.Kind.Pantry))
            }
            return SearchQuery(
                raw = raw,
                wants = wants.toList(),
                mealTypes = mealTypes.toSet(),
                cuisines = cuisines.toSet(),
                diets = diets.toSet(),
                maxMinutes = maxMinutes,
                difficulty = difficulty,
                exclusions = exclusions.toList(),
                usePantry = usePantry,
                chips = chips,
            )
        }
    }

    companion object {
        private const val FREE = "free"
        private const val MIN_TERM_LENGTH = 2
        private const val MIN_INGREDIENT_KEY_LENGTH = 3
        private const val MAX_NEGATOR_SPAN = 3
        private const val MAX_MINUTES = 24 * 60

        private val TIME_LEADS: List<List<String>> = listOf(
            listOf("no", "more", "than"), listOf("less", "than"), listOf("fewer", "than"),
            listOf("at", "most"), listOf("up", "to"), listOf("under"), listOf("in"), listOf("within"),
            listOf("max"), listOf("maximum"), listOf("below"), listOf("about"), listOf("around"),
            listOf("tops"), listOf("only"),
        )
        private val MINUTE_UNITS = setOf("m", "min", "mins", "minute", "minutes")
        private val HOUR_UNITS = setOf("h", "hr", "hrs", "hour", "hours")
        private val ARTICLE_NUMBERS = setOf("a", "an")
        private val NUMBER_WORDS = mapOf(
            "a" to 1, "an" to 1, "one" to 1, "two" to 2, "three" to 3, "four" to 4, "five" to 5,
            "ten" to 10, "fifteen" to 15, "twenty" to 20, "thirty" to 30, "forty" to 40,
            "fortyfive" to 45, "fifty" to 50, "sixty" to 60, "ninety" to 90,
        )

        /** "Under 30 min", "Under 1 hr", "Under 1 hr 30". */
        fun formatMinutes(minutes: Int): String = when {
            minutes < 60 -> "Under $minutes min"
            minutes % 60 == 0 -> "Under ${minutes / 60} hr"
            else -> "Under ${minutes / 60} hr ${minutes % 60}"
        }

        /**
         * Ingredient phrase → ids. Each name/synonym is indexed under every word-suffix, so
         * "mushroom" also finds "shiitake mushrooms" and "potato" finds "sweet potato", while
         * "rice" does not pull in "rice vinegar" (the head noun is the last word).
         */
        internal fun ingredientFamilies(ingredients: List<Ingredient>): Map<String, Set<String>> {
            val skip = SearchLexicon.stopWords + SearchLexicon.connectors + SearchLexicon.negators + SearchLexicon.intensifiers
            val families = HashMap<String, MutableSet<String>>()
            ingredients.forEach { ingredient ->
                (ingredient.synonyms + ingredient.name)
                    .map(SearchText::normalizePhrase)
                    .filter { it.isNotBlank() }
                    .toSet()
                    .forEach { term ->
                        val words = term.split(' ')
                        for (k in words.indices) {
                            val key = words.subList(k, words.size).joinToString(" ")
                            if (key.length >= MIN_INGREDIENT_KEY_LENGTH && key !in skip) {
                                families.getOrPut(key, ::mutableSetOf) += ingredient.id
                            }
                        }
                    }
            }
            return families
        }
    }
}
