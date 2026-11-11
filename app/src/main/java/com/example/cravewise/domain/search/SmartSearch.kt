package com.example.cravewise.domain.search

import com.example.cravewise.domain.PantryMatch
import com.example.cravewise.domain.PantryMatcher
import com.example.cravewise.domain.model.Ingredient
import com.example.cravewise.domain.model.Pantry
import com.example.cravewise.domain.model.RecipeSummary

/** Full-text hits for one term: recipe ids with it in the title, and anywhere (title, cuisine, ingredients). */
data class TextHits(val inTitle: Set<String> = emptySet(), val anywhere: Set<String> = emptySet())

/** One ranked result. [reasons] feed the "why it matched" tags, in query order. */
data class SearchResult(
    val recipe: RecipeSummary,
    val reasons: List<String>,
    val matchedWants: Int,
    val score: Int,
    /** Set for "with what I have" searches. */
    val pantry: PantryMatch? = null,
)

data class SearchResults(
    /** Matches every want (or everything, when the query has at most one want). */
    val best: List<SearchResult> = emptyList(),
    /** Matches some wants, best first. */
    val close: List<SearchResult> = emptyList(),
    /** Unknown words that no recipe mentions, so the UI can say so. */
    val unmatchedTerms: List<String> = emptyList(),
    /** Asked for "with what I have" while the pantry is empty, so that part was ignored. */
    val pantryEmpty: Boolean = false,
) {
    val total: Int get() = best.size + close.size
    val isEmpty: Boolean get() = total == 0
}

/**
 * Lexicon + full-text search ranking (Phase 6a). Hard filters from the query (meal type, cuisine,
 * diet, time, difficulty, exclusions, pantry) remove recipes; wants are scored, and a recipe must
 * match at least one want when there are any.
 *
 * Profile hard filters are NOT applied here: callers run ProfileGate on [SearchResults.best] and
 * [SearchResults.close] afterwards (safety rule: filters come after ranking). Diet and allergen
 * exclusions in the query use rule-derived tags, so they are safe too, but they're the user's
 * request for this search, not their profile.
 */
object SmartSearch {

    const val PROTEIN_POINTS = 6
    const val USES_POINTS = 6
    const val TITLE_BONUS = 2
    const val TAG_POINTS = 4
    const val TEXT_TITLE_POINTS = 6
    const val TEXT_ANYWHERE_POINTS = 3
    const val FLAVOR_MULTIPLIER = 2

    /**
     * @param recipeIngredients recipe id → ingredient ids. Recipes without an entry can't be
     *   checked against ingredient exclusions or pantry, so they are dropped from those searches.
     * @param textHits [SearchQuery.textTerms] → hits. Missing terms count as no hits.
     */
    fun search(
        query: SearchQuery,
        recipes: List<RecipeSummary>,
        recipeIngredients: Map<String, List<String>>,
        ingredients: Map<String, Ingredient>,
        pantry: Pantry,
        textHits: Map<String, TextHits>,
    ): SearchResults {
        if (query.isEmpty) return SearchResults()
        val usePantry = query.usePantry && !pantry.isEmpty
        val hits = { term: String -> textHits[term] ?: TextHits() }

        val scored = recipes.mapNotNull { recipe ->
            val ids = recipeIngredients[recipe.id]
            if (!passesFilters(recipe, ids, query, hits)) return@mapNotNull null
            val pantryMatch = if (usePantry) {
                PantryMatcher.matchRecipe(recipe, ids ?: return@mapNotNull null, ingredients, pantry)
                    .takeIf { it.usesFromPantry > 0 } ?: return@mapNotNull null
            } else {
                null
            }
            score(recipe, ids.orEmpty().toHashSet(), query, hits, pantryMatch)
                .takeIf { query.wants.isEmpty() || it.matchedWants > 0 }
        }.sortedWith(ranking(query))

        val split = query.wants.size > 1
        val (best, close) = if (split) scored.partition { it.matchedWants == query.wants.size } else scored to emptyList()
        return SearchResults(
            best = best,
            close = close,
            unmatchedTerms = query.wants.filterIsInstance<Want.Text>().map { it.term }.filter { hits(it).anywhere.isEmpty() },
            pantryEmpty = query.usePantry && pantry.isEmpty,
        )
    }

    private fun passesFilters(
        r: RecipeSummary,
        ids: List<String>?,
        q: SearchQuery,
        hits: (String) -> TextHits,
    ): Boolean {
        if (q.mealTypes.isNotEmpty() && q.mealTypes.none { it in r.mealTypes }) return false
        if (q.cuisines.isNotEmpty() && q.cuisines.none { it.equals(r.cuisine, ignoreCase = true) }) return false
        if (!r.diets.containsAll(q.diets)) return false
        if (q.maxMinutes != null && r.totalMinutes > q.maxMinutes) return false
        if (q.difficulty != null && r.difficulty != q.difficulty) return false
        return q.exclusions.none { excluded(it, r, ids, hits) }
    }

    private fun excluded(e: Exclusion, r: RecipeSummary, ids: List<String>?, hits: (String) -> TextHits): Boolean =
        when (e) {
            // No ingredient list = can't prove it's free of the ingredient, so leave it out.
            is Exclusion.Ingredients -> ids == null || ids.any { it in e.ingredientIds }
            is Exclusion.Proteins -> r.proteins.any { it in e.proteins } || r.allergens.any { it in e.allergens }
            is Exclusion.Allergens -> r.allergens.any { it in e.allergens }
            is Exclusion.MealTypeIs -> e.mealType in r.mealTypes
            is Exclusion.CuisineIs -> r.cuisine.equals(e.cuisine, ignoreCase = true)
            is Exclusion.TextureIs -> e.texture in r.textures
            is Exclusion.MoodIs -> e.mood in r.moods
            is Exclusion.DifficultyIs -> r.difficulty == e.difficulty
            is Exclusion.TasteAbove -> e.taste.scoreOf(r.flavor) > e.max
            is Exclusion.Text -> r.id in hits(e.term).anywhere
        }

    private fun score(
        r: RecipeSummary,
        ids: Set<String>,
        q: SearchQuery,
        hits: (String) -> TextHits,
        pantryMatch: PantryMatch?,
    ): SearchResult {
        var score = 0
        var matched = 0
        val reasons = mutableListOf<String>()
        fun hit(points: Int, reason: String) {
            score += points
            matched++
            reasons += reason
        }
        q.wants.forEach { want ->
            when (want) {
                is Want.Flavor -> {
                    val s = want.taste.scoreOf(r.flavor)
                    if (s >= want.min) hit(s * FLAVOR_MULTIPLIER, "${want.taste.label} $s/5")
                }
                is Want.TextureIs -> if (want.texture in r.textures) hit(TAG_POINTS, want.label)
                is Want.MoodIs -> if (want.mood in r.moods) hit(TAG_POINTS, want.label)
                is Want.ProteinIs -> r.proteins.firstOrNull { it in want.proteins }?.let { hit(PROTEIN_POINTS, it.label) }
                is Want.Uses -> {
                    val uses = ids.any { it in want.ingredientIds }
                    val inTitle = r.id in hits(want.term).inTitle
                    if (uses || inTitle) hit(USES_POINTS + if (inTitle) TITLE_BONUS else 0, want.label)
                }
                is Want.Text -> {
                    val h = hits(want.term)
                    when (r.id) {
                        in h.inTitle -> hit(TEXT_TITLE_POINTS, want.label)
                        in h.anywhere -> hit(TEXT_ANYWHERE_POINTS, want.label)
                    }
                }
            }
        }
        if (pantryMatch != null) {
            score += pantryMatch.matchPercent / 10
            reasons += if (pantryMatch.missing.isEmpty()) "You have everything" else "You have ${pantryMatch.have.size} of ${pantryMatch.total}"
        }
        return SearchResult(r, reasons, matched, score, pantryMatch)
    }

    /** Most wants matched, then score, then fewest missing (pantry), then quickest if time-boxed, then title. */
    private fun ranking(q: SearchQuery): Comparator<SearchResult> {
        var c = compareByDescending<SearchResult> { it.matchedWants }.thenByDescending { it.score }
        if (q.usePantry) c = c.thenBy { it.pantry?.missing?.size ?: Int.MAX_VALUE }
        if (q.maxMinutes != null) c = c.thenBy { it.recipe.totalMinutes }
        return c.thenBy { it.recipe.title.lowercase() }
    }
}
