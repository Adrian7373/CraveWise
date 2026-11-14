package com.example.cravewise.ui.recipe

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.PlaylistAddCheck
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.AddShoppingCart
import androidx.compose.material.icons.outlined.Eco
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.People
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.RemoveShoppingCart
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.SignalCellularAlt
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cravewise.domain.PantryMatcher
import com.example.cravewise.domain.ProfileConflict
import com.example.cravewise.domain.RecipeScaling
import com.example.cravewise.domain.model.Allergen
import com.example.cravewise.domain.model.Pantry
import com.example.cravewise.domain.model.Recipe
import com.example.cravewise.ui.designsystem.AllergenNotice
import com.example.cravewise.ui.designsystem.CraveButton
import com.example.cravewise.ui.designsystem.CraveButtonVariant
import com.example.cravewise.ui.designsystem.CraveLayout
import com.example.cravewise.ui.designsystem.CravePreviews
import com.example.cravewise.ui.designsystem.CraveSurface
import com.example.cravewise.ui.designsystem.CraveTag
import com.example.cravewise.ui.designsystem.FlavorProfile
import com.example.cravewise.ui.designsystem.NutritionPanel
import com.example.cravewise.ui.designsystem.ProfileConflictNotice
import com.example.cravewise.ui.designsystem.SectionHeader
import com.example.cravewise.ui.designsystem.ServingsStepper
import com.example.cravewise.ui.designsystem.SpiceMeter
import com.example.cravewise.ui.designsystem.ViaEmptyState
import com.example.cravewise.ui.profile.describe
import com.example.cravewise.ui.theme.CraveTheme
import com.example.cravewise.ui.theme.CraveWiseTheme

@Composable
fun RecipeDetailScreen(
    recipeId: String,
    onBack: () -> Unit,
    onBrowseCuisine: (String) -> Unit,
    onStartCooking: (servings: Int) -> Unit,
    showBackButton: Boolean = true,
    viewModel: RecipeDetailViewModel = hiltViewModel<RecipeDetailViewModel, RecipeDetailViewModel.Factory>(
        creationCallback = { it.create(recipeId) },
    ),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    RecipeDetailScreen(
        state = state,
        onBack = onBack,
        onToggleFavorite = viewModel::toggleFavorite,
        onBrowseCuisine = onBrowseCuisine,
        onServingsChange = viewModel::setServings,
        onStartCooking = { onStartCooking(state.servings) },
        showBackButton = showBackButton,
        shopping = ShoppingCallbacks(
            onAddMissing = viewModel::addMissingToShoppingList,
            onRemoveRecipe = viewModel::removeFromShoppingList,
            onToggleIngredient = viewModel::toggleShoppingItem,
        ),
    )
}

class ShoppingCallbacks(
    val onAddMissing: () -> Unit,
    val onRemoveRecipe: () -> Unit,
    val onToggleIngredient: (String) -> Unit,
) {
    companion object {
        val None = ShoppingCallbacks({}, {}, {})
    }
}

/**
 * @param showBackButton false when shown as the detail pane next to a list on a tablet: the list
 *   is right there, so a back arrow would only add noise.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailScreen(
    state: RecipeDetailUiState,
    onBack: () -> Unit,
    onToggleFavorite: () -> Unit,
    onBrowseCuisine: (String) -> Unit,
    onServingsChange: (Int) -> Unit = {},
    onStartCooking: () -> Unit = {},
    showBackButton: Boolean = true,
    shopping: ShoppingCallbacks = ShoppingCallbacks.None,
) {
    val cs = MaterialTheme.colorScheme
    Scaffold(
        containerColor = cs.background,
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    if (showBackButton) {
                        IconButton(onClick = onBack) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                        }
                    }
                },
                actions = {
                    if (state.recipe != null) {
                        IconButton(onClick = onToggleFavorite) {
                            Icon(
                                if (state.isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                                contentDescription = if (state.isFavorite) "Remove from favorites" else "Save to favorites",
                                tint = if (state.isFavorite) cs.primary else cs.onSurface,
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = cs.background),
            )
        },
    ) { padding ->
        val recipe = state.recipe
        when {
            state.isLoading -> Box(Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
            recipe == null -> Box(Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                ViaEmptyState(
                    title = "This recipe wandered off",
                    body = "It may have left the cookbook in an update. Plenty more where that came from!",
                    actionLabel = "Go back",
                    onAction = onBack,
                )
            }
            else -> RecipeContent(
                recipe = recipe,
                state = state,
                padding = padding,
                actions = DetailActions(onBrowseCuisine, onServingsChange, onStartCooking, shopping),
            )
        }
    }
}

private class DetailActions(
    val onBrowseCuisine: (String) -> Unit,
    val onServingsChange: (Int) -> Unit,
    val onStartCooking: () -> Unit,
    val shopping: ShoppingCallbacks,
)

/** One column on phones; overview + ingredients beside the method on wide windows. */
@Composable
private fun RecipeContent(
    recipe: Recipe,
    state: RecipeDetailUiState,
    padding: PaddingValues,
    actions: DetailActions,
) {
    BoxWithConstraints(Modifier.fillMaxSize()) {
        val twoColumns = maxWidth >= CraveLayout.TwoColumnWidth
        val gutter = if (twoColumns) 24.dp else CraveLayout.gutterFor(maxWidth)
        fun contentPadding(start: Boolean = true, end: Boolean = true) = PaddingValues(
            start = if (start) gutter else 12.dp,
            end = if (end) gutter else 12.dp,
            top = padding.calculateTopPadding() + 4.dp,
            bottom = padding.calculateBottomPadding() + 32.dp,
        )
        if (twoColumns) {
            Row(Modifier.fillMaxSize()) {
                LazyColumn(
                    contentPadding = contentPadding(end = false),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.weight(1f).fillMaxSize(),
                ) {
                    overviewItems(recipe, state, actions)
                    ingredientItems(recipe, state, actions)
                }
                LazyColumn(
                    contentPadding = contentPadding(start = false),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.weight(1f).fillMaxSize(),
                ) {
                    methodItems(recipe, actions, topPadding = false)
                }
            }
        } else {
            LazyColumn(
                contentPadding = contentPadding(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize(),
            ) {
                overviewItems(recipe, state, actions)
                ingredientItems(recipe, state, actions)
                methodItems(recipe, actions, topPadding = true)
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
private fun LazyListScope.overviewItems(recipe: Recipe, state: RecipeDetailUiState, actions: DetailActions) {
    val summary = recipe.summary
    if (state.conflicts.isNotEmpty()) {
        item("conflicts") {
            val names = recipe.ingredients.associate { it.ingredient.id to it.ingredient.name }
            ProfileConflictNotice(state.conflicts.map { c -> c.describe { id -> names[id] ?: id } })
        }
    }
    item("hero") { RecipeHero(recipe) }
    item("title") {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(summary.cuisine, style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary)
            Text(summary.title, style = MaterialTheme.typography.headlineMedium)
        }
    }
    item("facts") { FactsRow(recipe, state.servings) }
    if (recipe.steps.isNotEmpty()) {
        item("cook") {
            CraveButton(
                "Start cooking",
                onClick = actions.onStartCooking,
                icon = Icons.Outlined.PlayArrow,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
    item("heat") {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Heat", style = MaterialTheme.typography.labelLarge)
            Spacer(Modifier.width(12.dp))
            SpiceMeter(summary.spiceLevel)
        }
    }
    item("tags") {
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            recipe.diets.sortedBy { it.ordinal }.forEach { CraveTag(it.label, icon = Icons.Outlined.Eco) }
            summary.mealTypes.sortedBy { it.ordinal }.forEach { CraveTag(it.label) }
            recipe.moods.sortedBy { it.ordinal }.forEach { CraveTag(it.label) }
            recipe.textures.sortedBy { it.ordinal }.forEach { CraveTag(it.label) }
        }
    }
    item("allergens") { AllergenNotice(recipe.allergens.sortedBy { it.ordinal }.map { it.label }) }
    item("flavor") {
        CraveSurface(Modifier.fillMaxWidth(), hardShadow = false) {
            Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Flavor profile", style = MaterialTheme.typography.titleMedium)
                FlavorProfile(summary.flavor.toFlavorMap())
            }
        }
    }
    // No grams at all = a dataset built without nutrition; show nothing rather than "unavailable".
    state.nutrition?.takeIf { recipe.ingredients.any { it.grams != null } }?.let { n ->
        item("nutrition") {
            val scaled = RecipeScaling.isScaled(state.scale)
            NutritionPanel(
                perServing = n.perServing.takeIf { n.available },
                coveredLines = n.coveredLines,
                totalLines = n.totalLines,
                servings = n.servings.takeIf { scaled },
                totalKcal = n.total.kcal.takeIf { scaled },
            )
        }
    }
}

private fun LazyListScope.ingredientItems(recipe: Recipe, state: RecipeDetailUiState, actions: DetailActions) {
    val pantry = state.pantry
    // Have/missing marks only make sense once the user has listed something.
    val match = if (pantry.isEmpty) {
        null
    } else {
        val catalog = recipe.ingredients.associate { it.ingredient.id to it.ingredient }
        PantryMatcher.matchRecipe(recipe.summary, recipe.ingredients.map { it.ingredient.id }, catalog, pantry)
    }
    item("ingredients-header") {
        SectionHeader(
            "Ingredients",
            eyebrow = when {
                match != null -> "You have ${match.have.size} of ${match.total}"
                RecipeScaling.isScaled(state.scale) -> "Scaled from ${recipe.servings}"
                else -> null
            },
            modifier = Modifier.padding(top = 16.dp),
        )
    }
    item("servings") {
        ServingsStepper(
            value = state.servings,
            onValueChange = actions.onServingsChange,
            min = RecipeScaling.MIN_SERVINGS,
            max = RecipeScaling.MAX_SERVINGS,
        )
    }
    item("ingredients") {
        IngredientList(recipe, state.scale, pantry, state.onShoppingList, actions.shopping.onToggleIngredient)
    }
    item("shopping") { ShoppingButton(state, actions.shopping) }
}

private fun LazyListScope.methodItems(recipe: Recipe, actions: DetailActions, topPadding: Boolean) {
    val summary = recipe.summary
    item("steps-header") {
        SectionHeader(
            "Method",
            eyebrow = if (recipe.steps.size == 1) "1 step" else "${recipe.steps.size} steps",
            modifier = if (topPadding) Modifier.padding(top = 16.dp) else Modifier,
        )
    }
    itemsIndexed(recipe.steps, key = { i, _ -> "step-$i" }) { i, step -> StepRow(i + 1, step) }
    item("more") {
        CraveButton(
            "More ${summary.cuisine} recipes",
            onClick = { actions.onBrowseCuisine(summary.cuisine) },
            variant = CraveButtonVariant.Outline,
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
        )
    }
    item("source") { SourceCredit(recipe) }
}

@Composable
private fun RecipeHero(recipe: Recipe) {
    CraveSurface(Modifier.fillMaxWidth(), hardShadow = false) {
        RecipeSummaryArt(recipe.summary, Modifier.fillMaxWidth().height(180.dp), plateSize = 96.dp)
    }
}

@Composable
private fun FactsRow(recipe: Recipe, servings: Int) {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        Fact(
            icon = Icons.Outlined.Schedule,
            value = "${recipe.summary.totalMinutes} min",
            label = "Prep ${recipe.prepMinutes} · Cook ${recipe.cookMinutes}",
            modifier = Modifier.weight(1.4f),
        )
        Fact(Icons.Outlined.People, "$servings", "Servings", Modifier.weight(1f))
        Fact(Icons.Outlined.SignalCellularAlt, recipe.summary.difficulty.label, "Difficulty", Modifier.weight(1f))
    }
}

@Composable
private fun Fact(icon: ImageVector, value: String, label: String, modifier: Modifier = Modifier) {
    CraveSurface(modifier, shape = MaterialTheme.shapes.medium, hardShadow = false) {
        Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Icon(icon, contentDescription = null, modifier = Modifier.size(20.dp), tint = MaterialTheme.colorScheme.primary)
            Text(value, style = MaterialTheme.typography.titleMedium)
            Text(label, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

/** "Add N missing" while anything you lack isn't listed yet; otherwise a way to take it back off. */
@Composable
private fun ShoppingButton(state: RecipeDetailUiState, shopping: ShoppingCallbacks) {
    val missing = state.missingNotListed.size
    when {
        missing > 0 -> CraveButton(
            if (missing == 1) "Add 1 missing to shopping list" else "Add $missing missing to shopping list",
            onClick = shopping.onAddMissing,
            variant = CraveButtonVariant.Secondary,
            icon = Icons.Outlined.AddShoppingCart,
            modifier = Modifier.fillMaxWidth(),
        )
        state.onShoppingList.isNotEmpty() -> CraveButton(
            "Remove from shopping list",
            onClick = shopping.onRemoveRecipe,
            variant = CraveButtonVariant.Outline,
            icon = Icons.Outlined.RemoveShoppingCart,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Composable
private fun IngredientList(
    recipe: Recipe,
    scale: Double,
    pantry: Pantry,
    onShoppingList: Set<String>,
    onToggleShopping: (String) -> Unit,
) {
    val cs = MaterialTheme.colorScheme
    CraveSurface(Modifier.fillMaxWidth(), hardShadow = false) {
        Column(Modifier.padding(start = 16.dp, end = 4.dp)) {
            recipe.ingredients.forEachIndexed { i, line ->
                if (i > 0) HorizontalDivider(color = cs.outlineVariant, modifier = Modifier.padding(end = 12.dp))
                val have = pantry.owns(line.ingredient)
                Row(Modifier.heightIn(min = 48.dp).padding(vertical = 4.dp), verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        RecipeScaling.measure(line, scale),
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.width(112.dp),
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        line.rawName.replaceFirstChar { it.titlecase() },
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.weight(1f),
                    )
                    when {
                        // Have-marks only make sense once the user has listed something.
                        have && !pantry.isEmpty -> Box(Modifier.size(48.dp), contentAlignment = Alignment.Center) {
                            Icon(
                                Icons.Filled.CheckCircle,
                                contentDescription = "You have this",
                                tint = cs.tertiary,
                                modifier = Modifier.size(20.dp),
                            )
                        }
                        have -> Spacer(Modifier.width(48.dp))
                        else -> {
                            val listed = line.ingredient.id in onShoppingList
                            val name = line.ingredient.name
                            IconButton(onClick = { onToggleShopping(line.ingredient.id) }) {
                                Icon(
                                    if (listed) Icons.AutoMirrored.Filled.PlaylistAddCheck else Icons.Outlined.AddCircleOutline,
                                    contentDescription = if (listed) "$name is on your shopping list. Remove" else "Missing. Add $name to shopping list",
                                    tint = if (listed) cs.primary else cs.onSurfaceVariant,
                                    modifier = Modifier.size(22.dp),
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun StepRow(number: Int, text: String) {
    val cs = MaterialTheme.colorScheme
    Row(verticalAlignment = Alignment.Top) {
        Box(
            Modifier.size(32.dp).background(cs.primary, CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            Text("$number", style = MaterialTheme.typography.labelLarge, color = cs.onPrimary)
        }
        Spacer(Modifier.width(12.dp))
        Text(text, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f).padding(top = 4.dp))
    }
}

@Composable
private fun SourceCredit(recipe: Recipe) {
    val uriHandler = LocalUriHandler.current
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            "Adapted from ${recipe.sourceName}",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.weight(1f),
        )
        if (recipe.sourceUrl.isNotBlank()) {
            // The only link out of the app. Offline it simply opens in the browser later; with no
            // browser installed openUri throws, so swallow that rather than crash.
            TextButton(onClick = { runCatching { uriHandler.openUri(recipe.sourceUrl) } }) {
                Text("View original", style = MaterialTheme.typography.labelLarge)
            }
        }
    }
}

@CravePreviews
@Composable
private fun RecipeDetailPreview() = CraveWiseTheme {
    RecipeDetailScreen(
        state = RecipeDetailUiState(
            isLoading = false,
            recipe = PreviewRecipes.recipe,
            isFavorite = true,
            pantry = Pantry(listOf("beef", "lemon")),
            conflicts = listOf(ProfileConflict.ContainsAllergen(Allergen.Soy), ProfileConflict.HatedIngredient("garlic")),
            onShoppingList = setOf("soy_sauce"),
            servings = PreviewRecipes.recipe.servings * 2,
        ),
        onBack = {}, onToggleFavorite = {}, onBrowseCuisine = {},
    )
}

@Preview(name = "Tablet", device = "spec:width=1280dp,height=800dp,dpi=240", showBackground = true)
@Composable
private fun RecipeDetailTabletPreview() = CraveWiseTheme {
    RecipeDetailScreen(
        state = RecipeDetailUiState(
            isLoading = false,
            recipe = PreviewRecipes.recipe,
            servings = PreviewRecipes.recipe.servings,
        ),
        onBack = {}, onToggleFavorite = {}, onBrowseCuisine = {},
    )
}

@CravePreviews
@Composable
private fun RecipeDetailMissingPreview() = CraveWiseTheme {
    RecipeDetailScreen(
        state = RecipeDetailUiState(isLoading = false, recipe = null),
        onBack = {}, onToggleFavorite = {}, onBrowseCuisine = {},
    )
}
