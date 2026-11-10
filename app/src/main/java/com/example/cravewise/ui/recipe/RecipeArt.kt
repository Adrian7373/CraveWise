package com.example.cravewise.ui.recipe

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BreakfastDining
import androidx.compose.material.icons.outlined.Cake
import androidx.compose.material.icons.outlined.DinnerDining
import androidx.compose.material.icons.outlined.RiceBowl
import androidx.compose.material.icons.outlined.SetMeal
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.cravewise.domain.model.FlavorScores
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.model.Protein
import com.example.cravewise.domain.model.RecipeSummary
import com.example.cravewise.ui.designsystem.RecipeCard
import com.example.cravewise.ui.theme.CraveTheme
import com.example.cravewise.ui.theme.Flavor

/** Placeholder art until recipes have photos: an icon by dish type, tinted by dominant flavor. */
val RecipeSummary.artIcon: ImageVector
    get() = when {
        MealType.Dessert in mealTypes -> Icons.Outlined.Cake
        MealType.Breakfast in mealTypes -> Icons.Outlined.BreakfastDining
        Protein.Fish in proteins || Protein.Shellfish in proteins -> Icons.Outlined.SetMeal
        MealType.Side in mealTypes || MealType.Starter in mealTypes -> Icons.Outlined.RiceBowl
        else -> Icons.Outlined.DinnerDining
    }

/** Highest-scoring flavor; ties resolve in [Flavor] declaration order. */
val FlavorScores.dominant: Flavor
    get() = Flavor.entries.maxBy { flavor -> scoreOf(flavor) * 10 - flavor.ordinal }

/** [RecipeCard] for a domain [RecipeSummary], with the placeholder art applied. */
@Composable
fun RecipeSummaryCard(
    recipe: RecipeSummary,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    matchPercent: Int? = null,
    footer: (@Composable ColumnScope.() -> Unit)? = null,
) {
    RecipeCard(
        matchPercent = matchPercent,
        footer = footer,
        title = recipe.title,
        cuisine = recipe.cuisine,
        minutes = recipe.totalMinutes,
        difficulty = recipe.difficulty.label,
        spiceLevel = recipe.spiceLevel,
        art = recipe.artIcon,
        accent = CraveTheme.extras.flavor[recipe.flavor.dominant],
        onClick = onClick,
        modifier = modifier,
    )
}

fun FlavorScores.toFlavorMap(): Map<Flavor, Int> = Flavor.entries.associateWith { scoreOf(it) }

fun FlavorScores.scoreOf(flavor: Flavor): Int = when (flavor) {
    Flavor.Salty -> salty
    Flavor.Sweet -> sweet
    Flavor.Sour -> sour
    Flavor.Bitter -> bitter
    Flavor.Umami -> umami
    Flavor.Spicy -> spicy
}
