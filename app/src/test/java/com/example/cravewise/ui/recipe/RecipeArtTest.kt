package com.example.cravewise.ui.recipe

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BakeryDining
import androidx.compose.material.icons.outlined.Cake
import androidx.compose.material.icons.outlined.DinnerDining
import androidx.compose.material.icons.outlined.RamenDining
import androidx.compose.material.icons.outlined.SoupKitchen
import com.example.cravewise.domain.model.Difficulty
import com.example.cravewise.domain.model.FlavorScores
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.model.RecipeSummary
import org.junit.Assert.assertEquals
import org.junit.Test

class RecipeArtTest {

    private fun recipe(title: String, meal: MealType = MealType.Main) = RecipeSummary(
        id = title, title = title, cuisine = "Any", totalMinutes = 10, difficulty = Difficulty.Easy,
        flavor = FlavorScores(0, 0, 0, 0, 0, 0), mealTypes = setOf(meal), proteins = emptySet(),
        diets = emptySet(), allergens = emptySet(),
    )

    @Test fun titleWordsPickTheDishForm() {
        assertEquals(Icons.Outlined.SoupKitchen, recipe("Chicken Noodle Soup").artIcon)
        assertEquals(Icons.Outlined.RamenDining, recipe("Beef Noodles").artIcon)
        assertEquals(Icons.Outlined.BakeryDining, recipe("Steak and Kidney Pie").artIcon)
    }

    @Test fun wholeWordsOnly() {
        // "pie" must not match "piece", "bun" not "bunny".
        assertEquals(Icons.Outlined.DinnerDining, recipe("Piece of Bunny Chow").artIcon)
    }

    @Test fun fallsBackToMealType() {
        assertEquals(Icons.Outlined.Cake, recipe("Eton Mess", MealType.Dessert).artIcon)
    }
}
