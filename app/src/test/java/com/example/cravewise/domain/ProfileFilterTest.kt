package com.example.cravewise.domain

import com.example.cravewise.domain.model.Allergen
import com.example.cravewise.domain.model.Diet
import com.example.cravewise.domain.model.Difficulty
import com.example.cravewise.domain.model.FlavorScores
import com.example.cravewise.domain.model.FoodProfile
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.model.RecipeSummary
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ProfileFilterTest {

    private fun recipe(
        id: String,
        allergens: Set<Allergen> = emptySet(),
        diets: Set<Diet> = emptySet(),
        spicy: Int = 0,
    ) = RecipeSummary(
        id = id, title = id, cuisine = "Any", totalMinutes = 10, difficulty = Difficulty.Easy,
        flavor = FlavorScores(0, 0, 0, 0, 0, spicy), mealTypes = setOf(MealType.Main),
        proteins = emptySet(), diets = diets, allergens = allergens,
    )

    private val satay = recipe("satay", allergens = setOf(Allergen.Peanuts, Allergen.Soy), spicy = 3)
    private val salad = recipe("salad", diets = setOf(Diet.Vegetarian, Diet.Vegan))
    private val curry = recipe("curry", diets = setOf(Diet.Vegetarian), spicy = 5)
    private val all = listOf(satay, salad, curry)

    private val ingredients = mapOf(
        "satay" to listOf("chicken", "peanut", "soy_sauce"),
        "salad" to listOf("lettuce", "coriander"),
        "curry" to listOf("chickpea", "chili"),
    )

    private fun apply(profile: FoodProfile, items: List<RecipeSummary> = all, refs: Map<String, List<String>> = ingredients) =
        ProfileFilter.apply(items, refs, profile) { it }.map { it.id }

    @Test fun emptyProfileKeepsEverythingInOrder() {
        assertEquals(listOf("satay", "salad", "curry"), apply(FoodProfile()))
    }

    @Test fun allergenHidesRecipe() {
        assertEquals(listOf("salad", "curry"), apply(FoodProfile(allergens = setOf(Allergen.Peanuts))))
    }

    @Test fun dietsMustAllBeMet() {
        assertEquals(listOf("salad", "curry"), apply(FoodProfile(diets = setOf(Diet.Vegetarian))))
        assertEquals(listOf("salad"), apply(FoodProfile(diets = setOf(Diet.Vegetarian, Diet.Vegan))))
    }

    @Test fun hatedIngredientHidesRecipeById() {
        assertEquals(listOf("satay", "curry"), apply(FoodProfile(hatedIngredientIds = setOf("coriander"))))
    }

    @Test fun unknownIngredientsAreHiddenWhenHatedSetIsNonEmpty() {
        val refs = ingredients - "curry"
        assertEquals(listOf("satay", "salad", "curry"), apply(FoodProfile(), refs = refs))
        assertEquals(listOf("satay"), apply(FoodProfile(hatedIngredientIds = setOf("coriander")), refs = refs))
    }

    @Test fun spiceLimitHidesHotterRecipes() {
        assertEquals(listOf("salad"), apply(FoodProfile(maxSpice = 2)))
        assertEquals(listOf("satay", "salad"), apply(FoodProfile(maxSpice = 3)))
    }

    @Test fun unsetOrMaxSpiceHidesNothing() {
        assertEquals(3, apply(FoodProfile(maxSpice = null)).size)
        assertEquals(3, apply(FoodProfile(maxSpice = FoodProfile.MAX_SPICE)).size)
    }

    @Test fun conflictsListEveryReasonInOrder() {
        val profile = FoodProfile(
            allergens = setOf(Allergen.Soy, Allergen.Peanuts),
            diets = setOf(Diet.Vegan),
            hatedIngredientIds = setOf("chicken"),
            maxSpice = 1,
        )
        val conflicts = ProfileFilter.conflicts(satay, ingredients.getValue("satay"), profile)
        assertEquals(
            listOf(
                ProfileConflict.ContainsAllergen(Allergen.Peanuts),
                ProfileConflict.ContainsAllergen(Allergen.Soy),
                ProfileConflict.NotDiet(Diet.Vegan),
                ProfileConflict.HatedIngredient("chicken"),
                ProfileConflict.TooSpicy(3, 1),
            ),
            conflicts,
        )
    }

    @Test fun fittingRecipeHasNoConflicts() {
        assertTrue(ProfileFilter.conflicts(salad, ingredients.getValue("salad"), FoodProfile(diets = setOf(Diet.Vegan))).isEmpty())
    }
}
