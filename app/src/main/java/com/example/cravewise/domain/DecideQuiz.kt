package com.example.cravewise.domain

import com.example.cravewise.domain.model.FlavorScores
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.model.Mood
import com.example.cravewise.domain.model.Protein
import com.example.cravewise.domain.model.RecipeSummary

/** Flavors you can crave in the quiz (bitter isn't much of a craving). */
enum class Craving(val label: String) {
    Salty("Salty"), Sweet("Sweet"), Sour("Sour"), Umami("Umami"), Spicy("Spicy");

    fun scoreOf(flavor: FlavorScores): Int = when (this) {
        Salty -> flavor.salty
        Sweet -> flavor.sweet
        Sour -> flavor.sour
        Umami -> flavor.umami
        Spicy -> flavor.spicy
    }
}

enum class TimeBudget(val maxMinutes: Int, val label: String) {
    Quick(15, "15 min"),
    HalfHour(30, "30 min"),
    Hour(60, "1 hour"),
}

/** Quiz answers. Null / empty means "Any". [mealType] and [time] narrow the pool; the rest score. */
data class QuizAnswers(
    val mealType: MealType? = null,
    val time: TimeBudget? = null,
    val mood: Mood? = null,
    val cravings: Set<Craving> = emptySet(),
    val protein: Protein? = null,
    val usePantry: Boolean = false,
)

/** A ranked quiz result. [reasons] feed the "why this" line, most important first. */
data class QuizPick(
    val recipe: RecipeSummary,
    val score: Int,
    val reasons: List<String>,
)

/** The hero and runners-up currently on screen. */
data class QuizShowcase(val top: QuizPick, val runnersUp: List<QuizPick>)

/**
 * "Help me decide" scoring. Profile hard filters are NOT applied here: callers must run
 * [ProfileFilter] on the output of [rank] (safety rule: filters come after ranking).
 */
object DecideQuiz {

    const val MOOD_POINTS = 6
    const val PROTEIN_POINTS = 6
    const val CRAVING_MULTIPLIER = 2

    /** A craving shows up in "why this" once the recipe scores at least this on it. */
    const val CRAVING_REASON_MIN = 3

    /** Shuffle cycles the hero through this many top picks. */
    const val SHUFFLE_POOL = 10
    const val RUNNERS_UP = 4

    /**
     * Ranks recipes for [answers]: best score first, then quickest, then title.
     *
     * @param pantryPercent recipe id → pantry match % (0–100). Used only when
     *   [QuizAnswers.usePantry] is on; recipes missing from the map score 0 for it.
     */
    fun rank(
        recipes: List<RecipeSummary>,
        answers: QuizAnswers,
        pantryPercent: Map<String, Int> = emptyMap(),
    ): List<QuizPick> =
        recipes
            .filter { answers.mealType == null || answers.mealType in it.mealTypes }
            .filter { answers.time == null || it.totalMinutes <= answers.time.maxMinutes }
            .map { score(it, answers, pantryPercent) }
            .sortedWith(
                compareByDescending<QuizPick> { it.score }
                    .thenBy { it.recipe.totalMinutes }
                    .thenBy { it.recipe.title.lowercase() },
            )

    fun score(recipe: RecipeSummary, answers: QuizAnswers, pantryPercent: Map<String, Int> = emptyMap()): QuizPick {
        var score = 0
        val reasons = mutableListOf<String>()

        answers.cravings.sortedBy { it.ordinal }.forEach { craving ->
            val s = craving.scoreOf(recipe.flavor)
            score += s * CRAVING_MULTIPLIER
            if (s >= CRAVING_REASON_MIN) reasons += "${craving.label} $s/5"
        }
        answers.mood?.let { mood ->
            if (mood in recipe.moods) {
                score += MOOD_POINTS
                reasons += mood.label
            }
        }
        answers.protein?.let { protein ->
            if (protein in recipe.proteins) {
                score += PROTEIN_POINTS
                reasons += protein.label
            }
        }
        if (answers.usePantry) {
            val percent = pantryPercent[recipe.id] ?: 0
            score += percent / 10
            if (percent > 0) reasons += "You have $percent%"
        }
        if (answers.time != null || reasons.isEmpty()) reasons += "${recipe.totalMinutes} min"
        return QuizPick(recipe, score, reasons)
    }

    /**
     * The hero for the [shuffle]-th tap of "Shuffle" (0 = best pick) and the runners-up after it.
     * The hero cycles through the top [SHUFFLE_POOL]; null when there are no picks.
     */
    fun showcase(picks: List<QuizPick>, shuffle: Int): QuizShowcase? {
        if (picks.isEmpty()) return null
        val pool = minOf(picks.size, SHUFFLE_POOL)
        val heroIndex = Math.floorMod(shuffle, pool)
        val rest = picks.filterIndexed { i, _ -> i != heroIndex }.take(RUNNERS_UP)
        return QuizShowcase(picks[heroIndex], rest)
    }
}
