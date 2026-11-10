package com.example.cravewise.domain

import com.example.cravewise.domain.model.Diet
import com.example.cravewise.domain.model.Difficulty
import com.example.cravewise.domain.model.FlavorScores
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.model.RecipeSummary
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CookbookTest {

    private fun recipe(
        id: String,
        cuisine: String = "Italian",
        minutes: Int = 20,
        mealTypes: Set<MealType> = setOf(MealType.Main),
        diets: Set<Diet> = emptySet(),
    ) = RecipeSummary(
        id = id, title = id, cuisine = cuisine, totalMinutes = minutes, difficulty = Difficulty.Easy,
        flavor = FlavorScores(0, 0, 0, 0, 0, 0), mealTypes = mealTypes, proteins = emptySet(), diets = diets,
    )

    private val pasta = recipe("pasta", diets = setOf(Diet.Vegetarian))
    private val curry = recipe("curry", cuisine = "Indian", minutes = 60, diets = setOf(Diet.Vegetarian, Diet.Vegan))
    private val cake = recipe("cake", cuisine = "British", minutes = 90, mealTypes = setOf(MealType.Dessert))
    private val all = listOf(cake, curry, pasta)

    @Test fun emptyFilterKeepsEverythingInOrder() {
        assertEquals(all, Cookbook.filter(all, BrowseFilter()))
        assertTrue(BrowseFilter().isEmpty)
    }

    @Test fun filtersCombineAsAnd() {
        val f = BrowseFilter(mealType = MealType.Main, diets = setOf(Diet.Vegetarian), maxMinutes = 30)
        assertEquals(listOf(pasta), Cookbook.filter(all, f))
    }

    @Test fun dietFilterRequiresEveryDiet() {
        val f = BrowseFilter(diets = setOf(Diet.Vegetarian, Diet.Vegan))
        assertEquals(listOf(curry), Cookbook.filter(all, f))
    }

    @Test fun cuisineMatchIsCaseInsensitive() {
        assertEquals(listOf(curry), Cookbook.filter(all, BrowseFilter(cuisine = "indian")))
    }

    @Test fun cuisinesSortedByCountThenName() {
        val list = all + recipe("pizza")
        assertEquals(listOf("Italian", "British", "Indian"), Cookbook.cuisines(list).map { it.value })
        assertEquals(2, Cookbook.cuisines(list).first().count)
    }

    @Test fun mealTypesSkipEmptyCategories() {
        assertEquals(listOf(MealType.Main, MealType.Dessert), Cookbook.mealTypes(all).map { it.value })
    }

    @Test fun quickPicksExcludeDessertsAndSortByTime() {
        assertEquals(listOf(pasta, curry), Cookbook.quickPicks(all, count = 5))
    }

    @Test fun favoritesKeepOrderAndDropStaleIds() {
        assertEquals(listOf(curry, cake), Cookbook.favorites(all, listOf("curry", "gone", "cake")))
    }
}
