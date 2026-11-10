package com.example.cravewise.domain

import com.example.cravewise.domain.model.Ingredient

/** Type-ahead over ingredient names and synonyms for the pantry picker. */
object IngredientSearch {

    fun normalize(text: String): String = text.trim().lowercase().replace(WHITESPACE, " ")

    /**
     * Best matches for [query], skipping ids in [exclude]. Ranking per ingredient (best term wins):
     * exact name/synonym, name prefix, synonym prefix, word prefix ("oil" → "olive oil"), substring.
     * Ties sort by name. A blank query gives nothing.
     */
    fun suggest(
        query: String,
        ingredients: List<Ingredient>,
        exclude: Set<String> = emptySet(),
        limit: Int = DEFAULT_LIMIT,
    ): List<Ingredient> {
        val q = normalize(query)
        if (q.isEmpty()) return emptyList()
        return ingredients
            .asSequence()
            .filter { it.id !in exclude }
            .mapNotNull { ingredient -> rank(q, ingredient)?.let { ingredient to it } }
            .sortedWith(compareBy<Pair<Ingredient, Int>> { it.second }.thenBy { it.first.name.lowercase() })
            .take(limit)
            .map { it.first }
            .toList()
    }

    /** The single ingredient [query] names exactly (name or synonym), if any. */
    fun exactMatch(query: String, ingredients: List<Ingredient>): Ingredient? {
        val q = normalize(query)
        if (q.isEmpty()) return null
        return ingredients.firstOrNull { normalize(it.name) == q || q in it.synonyms }
    }

    private fun rank(q: String, ingredient: Ingredient): Int? {
        val name = normalize(ingredient.name)
        val terms = ingredient.synonyms + name
        return when {
            q == name || q in ingredient.synonyms -> 0
            name.startsWith(q) -> 1
            terms.any { it.startsWith(q) } -> 2
            terms.any { term -> term.split(' ').any { it.startsWith(q) } } -> 3
            terms.any { q in it } -> 4
            else -> null
        }
    }

    const val DEFAULT_LIMIT = 8
    private val WHITESPACE = Regex("\\s+")
}
