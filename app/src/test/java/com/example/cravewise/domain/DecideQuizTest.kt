package com.example.cravewise.domain

import com.example.cravewise.domain.model.Difficulty
import com.example.cravewise.domain.model.FlavorScores
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.model.Mood
import com.example.cravewise.domain.model.Protein
import com.example.cravewise.domain.model.RecipeSummary
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class DecideQuizTest {

    private fun recipe(
        id: String,
        minutes: Int = 30,
        meal: MealType = MealType.Main,
        flavor: FlavorScores = FlavorScores(0, 0, 0, 0, 0, 0),
        moods: Set<Mood> = emptySet(),
        proteins: Set<Protein> = emptySet(),
    ) = RecipeSummary(
        id = id, title = id, cuisine = "Any", totalMinutes = minutes, difficulty = Difficulty.Easy,
        flavor = flavor, mealTypes = setOf(meal), proteins = proteins, diets = emptySet(),
        allergens = emptySet(), moods = moods,
    )

    private val ramen = recipe("ramen", 40, flavor = FlavorScores(4, 0, 0, 0, 5, 1), moods = setOf(Mood.Comfort), proteins = setOf(Protein.Pork))
    private val salad = recipe("salad", 10, flavor = FlavorScores(1, 1, 3, 0, 0, 0), moods = setOf(Mood.Fresh, Mood.Light))
    private val tacos = recipe("tacos", 25, flavor = FlavorScores(3, 1, 2, 0, 3, 3), moods = setOf(Mood.Comfort), proteins = setOf(Protein.Chicken))
    private val cake = recipe("cake", 60, MealType.Dessert, FlavorScores(0, 5, 0, 0, 0, 0), setOf(Mood.Indulgent))
    private val all = listOf(ramen, salad, tacos, cake)

    private fun rank(answers: QuizAnswers, pantry: Map<String, Int> = emptyMap()) =
        DecideQuiz.rank(all, answers, pantry).map { it.recipe.id }

    @Test fun noAnswersRanksQuickestFirst() {
        assertEquals(listOf("salad", "tacos", "ramen", "cake"), rank(QuizAnswers()))
    }

    @Test fun mealTypeAndTimeNarrowThePool() {
        assertEquals(listOf("cake"), rank(QuizAnswers(mealType = MealType.Dessert)))
        assertEquals(listOf("salad", "tacos"), rank(QuizAnswers(time = TimeBudget.HalfHour)))
    }

    @Test fun cravingsMoodAndProteinScore() {
        assertEquals("ramen", rank(QuizAnswers(cravings = setOf(Craving.Umami))).first())
        assertEquals("tacos", rank(QuizAnswers(mood = Mood.Comfort, protein = Protein.Chicken)).first())
    }

    @Test fun pantryBoostsOnlyWhenEnabled() {
        val pantry = mapOf("cake" to 100)
        assertEquals("salad", rank(QuizAnswers(usePantry = false), pantry).first())
        assertEquals("cake", rank(QuizAnswers(usePantry = true), pantry).first())
    }

    @Test fun reasonsExplainThePick() {
        val pick = DecideQuiz.score(ramen, QuizAnswers(mood = Mood.Comfort, cravings = setOf(Craving.Umami, Craving.Sweet)))
        assertEquals(listOf("Umami 5/5", "Comfort"), pick.reasons)
    }

    @Test fun reasonsFallBackToTime() {
        assertEquals(listOf("10 min"), DecideQuiz.score(salad, QuizAnswers()).reasons)
    }

    @Test fun showcaseCyclesHeroAndSkipsItInRunnersUp() {
        val picks = DecideQuiz.rank(all, QuizAnswers())
        val first = DecideQuiz.showcase(picks, 0)!!
        assertEquals("salad", first.top.recipe.id)
        assertEquals(listOf("tacos", "ramen", "cake"), first.runnersUp.map { it.recipe.id })

        val second = DecideQuiz.showcase(picks, 1)!!
        assertEquals("tacos", second.top.recipe.id)
        assertTrue(second.runnersUp.none { it.recipe.id == "tacos" })

        assertEquals("salad", DecideQuiz.showcase(picks, picks.size)!!.top.recipe.id)
    }

    @Test fun showcaseIsNullWithoutPicks() {
        assertNull(DecideQuiz.showcase(emptyList(), 0))
    }
}
