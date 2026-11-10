package com.example.cravewise.ui.recipe

import com.example.cravewise.domain.model.Aisle
import com.example.cravewise.domain.model.Allergen
import com.example.cravewise.domain.model.Diet
import com.example.cravewise.domain.model.Difficulty
import com.example.cravewise.domain.model.FlavorScores
import com.example.cravewise.domain.model.Ingredient
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.model.MeasureUnit
import com.example.cravewise.domain.model.Mood
import com.example.cravewise.domain.model.Protein
import com.example.cravewise.domain.model.Recipe
import com.example.cravewise.domain.model.RecipeIngredientLine
import com.example.cravewise.domain.model.RecipeSummary
import com.example.cravewise.domain.model.Texture

/** Sample data for @CravePreviews only. */
internal object PreviewRecipes {

    val bistek = RecipeSummary(
        id = "mdb-1", title = "Bistek", cuisine = "Filipino", totalMinutes = 35, difficulty = Difficulty.Easy,
        flavor = FlavorScores(salty = 4, sweet = 1, sour = 3, bitter = 0, umami = 4, spicy = 0),
        mealTypes = setOf(MealType.Main), proteins = setOf(Protein.Beef), diets = setOf(Diet.DairyFree),
        allergens = setOf(Allergen.Gluten, Allergen.Soy), moods = setOf(Mood.Comfort, Mood.Hearty),
    )

    val stirFry = RecipeSummary(
        id = "mdb-2", title = "Thai beef stir-fry", cuisine = "Thai", totalMinutes = 15, difficulty = Difficulty.Easy,
        flavor = FlavorScores(salty = 3, sweet = 1, sour = 0, bitter = 0, umami = 4, spicy = 3),
        mealTypes = setOf(MealType.Main), proteins = setOf(Protein.Beef), diets = setOf(Diet.DairyFree),
        allergens = setOf(Allergen.Fish, Allergen.Soy), moods = setOf(Mood.Fresh),
    )

    val etonMess = RecipeSummary(
        id = "mdb-3", title = "Eton Mess", cuisine = "British", totalMinutes = 15, difficulty = Difficulty.Easy,
        flavor = FlavorScores(salty = 0, sweet = 5, sour = 2, bitter = 0, umami = 0, spicy = 0),
        mealTypes = setOf(MealType.Dessert), proteins = emptySet(), diets = setOf(Diet.Vegetarian, Diet.GlutenFree),
        allergens = setOf(Allergen.Eggs, Allergen.Milk), moods = setOf(Mood.Indulgent),
    )

    val summaries = listOf(bistek, etonMess, stirFry)

    private fun ingredient(id: String, name: String, aisle: Aisle, allergens: Set<Allergen> = emptySet()) =
        Ingredient(id, name, aisle, allergens, isPantryStaple = false)

    private fun line(ingredient: Ingredient, measure: String, amount: Double?, unit: MeasureUnit?) =
        RecipeIngredientLine(ingredient, ingredient.name, measure, amount, null, unit, null)

    val recipe = Recipe(
        summary = bistek,
        servings = 4,
        prepMinutes = 15,
        cookMinutes = 20,
        textures = setOf(Texture.Saucy, Texture.Tender),
        ingredients = listOf(
            line(ingredient("beef", "Beef", Aisle.MeatSeafood), "1 lb", 1.0, MeasureUnit.Lb),
            line(ingredient("soy_sauce", "Soy Sauce", Aisle.Condiments, setOf(Allergen.Gluten, Allergen.Soy)), "5 tablespoons", 5.0, MeasureUnit.Tbsp),
            line(ingredient("lemon", "Lemon", Aisle.Produce), "1", 1.0, null),
            line(ingredient("garlic", "Garlic", Aisle.Produce), "3 cloves", 3.0, MeasureUnit.Clove),
            line(ingredient("salt", "Salt", Aisle.Spices), "To taste", null, null),
        ),
        steps = listOf(
            "Marinate beef in soy sauce and lemon for at least 1 hour.",
            "Pan-fry half of the onions until soft. Set aside.",
            "Pan-fry the beef 1 minute per side, then simmer in the marinade until tender.",
        ),
        imageUrl = null,
        sourceName = "TheMealDB",
        sourceUrl = "https://www.themealdb.com/meal/53069",
    )
}
