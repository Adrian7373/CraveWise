package com.example.cravewise.ui.recipe

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BakeryDining
import androidx.compose.material.icons.outlined.BreakfastDining
import androidx.compose.material.icons.outlined.Cake
import androidx.compose.material.icons.outlined.Cookie
import androidx.compose.material.icons.outlined.DinnerDining
import androidx.compose.material.icons.outlined.EggAlt
import androidx.compose.material.icons.outlined.Icecream
import androidx.compose.material.icons.outlined.KebabDining
import androidx.compose.material.icons.outlined.LocalPizza
import androidx.compose.material.icons.outlined.LunchDining
import androidx.compose.material.icons.outlined.OutdoorGrill
import androidx.compose.material.icons.outlined.RamenDining
import androidx.compose.material.icons.outlined.RiceBowl
import androidx.compose.material.icons.outlined.SetMeal
import androidx.compose.material.icons.outlined.SoupKitchen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cravewise.domain.model.FlavorScores
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.model.Protein
import com.example.cravewise.domain.model.RecipeSummary
import com.example.cravewise.ui.designsystem.RecipeArt
import com.example.cravewise.ui.designsystem.RecipePhotoOrArt
import com.example.cravewise.ui.designsystem.RecipeCard
import com.example.cravewise.ui.theme.CraveTheme
import com.example.cravewise.ui.theme.Flavor

/**
 * Title words that name the dish's form, checked in order (first hit wins), so "Chicken noodle
 * soup" is a soup and "Rice pudding" is a dessert by the meal-type rule below it.
 */
private val titleArt: List<Pair<List<String>, ImageVector>> = listOf(
    listOf("pizza", "calzone") to Icons.Outlined.LocalPizza,
    listOf("soup", "stew", "broth", "chowder", "bisque", "goulash", "gumbo", "pottage", "minestrone") to Icons.Outlined.SoupKitchen,
    listOf("ramen", "noodle", "pho", "laksa", "udon", "soba", "chow mein", "pad thai", "lo mein") to Icons.Outlined.RamenDining,
    listOf("burger", "sandwich", "wrap", "taco", "burrito", "quesadilla", "hot dog", "bap", "sub") to Icons.Outlined.LunchDining,
    listOf("kebab", "skewer", "satay", "souvlaki", "kofta", "shish") to Icons.Outlined.KebabDining,
    listOf("ice cream", "sorbet", "gelato", "semifreddo") to Icons.Outlined.Icecream,
    listOf("cookie", "biscuit", "brownie", "flapjack", "shortbread") to Icons.Outlined.Cookie,
    listOf("cake", "gateau", "torte", "cheesecake", "muffin", "cupcake") to Icons.Outlined.Cake,
    listOf("omelette", "frittata", "shakshuka", "scrambled", "egg") to Icons.Outlined.EggAlt,
    listOf("bread", "bun", "loaf", "scone", "croissant", "pastry", "pie", "tart", "roll", "pasty", "strudel") to Icons.Outlined.BakeryDining,
    listOf("pasta", "spaghetti", "lasagne", "lasagna", "linguine", "penne", "macaroni", "fettuccine", "tagliatelle", "ravioli", "gnocchi") to Icons.Outlined.DinnerDining,
    listOf("rice", "risotto", "paella", "biryani", "pilaf", "pilau", "jambalaya", "kedgeree") to Icons.Outlined.RiceBowl,
    listOf("grill", "bbq", "barbecue", "steak", "roast", "chop", "ribs") to Icons.Outlined.OutdoorGrill,
)

/** Placeholder art until recipes have photos: an icon by dish form or type, tinted by dominant flavor. */
val RecipeSummary.artIcon: ImageVector
    get() {
        val words = " ${title.lowercase()} "
        titleArt.firstOrNull { (keys, _) -> keys.any { words.containsWord(it) } }?.let { return it.second }
        return when {
            MealType.Dessert in mealTypes -> Icons.Outlined.Cake
            MealType.Breakfast in mealTypes -> Icons.Outlined.BreakfastDining
            Protein.Fish in proteins || Protein.Shellfish in proteins -> Icons.Outlined.SetMeal
            MealType.Side in mealTypes || MealType.Starter in mealTypes -> Icons.Outlined.RiceBowl
            else -> Icons.Outlined.DinnerDining
        }
    }

/** Whole-word (or plural) match, so "bun" doesn't hit "bunny" and "pie" doesn't hit "piece". */
private fun String.containsWord(word: String): Boolean {
    var from = 0
    while (true) {
        val i = indexOf(word, from)
        if (i < 0) return false
        val before = this[i - 1]
        val after = getOrNull(i + word.length)
        val endOk = after == null || !after.isLetter() || (after == 's' && getOrNull(i + word.length + 1)?.isLetter() != true)
        if (!before.isLetter() && endOk) return true
        from = i + 1
    }
}

/** Stable per recipe, so its art pattern never changes between screens or launches. */
val RecipeSummary.artSeed: Int get() = id.hashCode()

/** Highest-scoring flavor; ties resolve in [Flavor] declaration order. */
val FlavorScores.dominant: Flavor
    get() = Flavor.entries.maxBy { flavor -> scoreOf(flavor) * 10 - flavor.ordinal }

/** The recipe's downloaded photo if there is one, else its [RecipeArt]. */
@Composable
fun RecipeSummaryArt(recipe: RecipeSummary, modifier: Modifier = Modifier, plateSize: Dp = 64.dp) {
    RecipePhotoOrArt(
        photo = LocalRecipePhotos.current.photoFor(recipe.id),
        icon = recipe.artIcon,
        accent = CraveTheme.extras.flavor[recipe.flavor.dominant],
        seed = recipe.artSeed,
        plateSize = plateSize,
        modifier = modifier,
    )
}

/** [RecipeCard] for a domain [RecipeSummary], with the placeholder art applied. */
@Composable
fun RecipeSummaryCard(
    recipe: RecipeSummary,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    matchPercent: Int? = null,
    /** 2 for cards in a horizontal row, so they're all the same height. */
    titleMinLines: Int = 1,
    footer: (@Composable ColumnScope.() -> Unit)? = null,
) {
    RecipeCard(
        titleMinLines = titleMinLines,
        matchPercent = matchPercent,
        footer = footer,
        title = recipe.title,
        cuisine = recipe.cuisine,
        minutes = recipe.totalMinutes,
        difficulty = recipe.difficulty.label,
        spiceLevel = recipe.spiceLevel,
        art = recipe.artIcon,
        accent = CraveTheme.extras.flavor[recipe.flavor.dominant],
        artSeed = recipe.artSeed,
        photo = LocalRecipePhotos.current.photoFor(recipe.id),
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
