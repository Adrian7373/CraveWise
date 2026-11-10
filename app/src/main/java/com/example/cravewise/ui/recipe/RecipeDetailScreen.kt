package com.example.cravewise.ui.recipe

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.Eco
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.People
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cravewise.domain.PantryMatcher
import com.example.cravewise.domain.model.Pantry
import com.example.cravewise.domain.model.Recipe
import com.example.cravewise.ui.designsystem.AllergenNotice
import com.example.cravewise.ui.designsystem.CraveButton
import com.example.cravewise.ui.designsystem.CraveButtonVariant
import com.example.cravewise.ui.designsystem.CravePreviews
import com.example.cravewise.ui.designsystem.CraveSurface
import com.example.cravewise.ui.designsystem.CraveTag
import com.example.cravewise.ui.designsystem.FlavorProfile
import com.example.cravewise.ui.designsystem.ProfileConflictNotice
import com.example.cravewise.ui.profile.describe
import com.example.cravewise.domain.ProfileConflict
import com.example.cravewise.domain.model.Allergen
import com.example.cravewise.ui.designsystem.SectionHeader
import com.example.cravewise.ui.designsystem.SpiceMeter
import com.example.cravewise.ui.designsystem.ViaEmptyState
import com.example.cravewise.ui.theme.CraveTheme
import com.example.cravewise.ui.theme.CraveWiseTheme

@Composable
fun RecipeDetailScreen(
    recipeId: String,
    onBack: () -> Unit,
    onBrowseCuisine: (String) -> Unit,
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
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailScreen(
    state: RecipeDetailUiState,
    onBack: () -> Unit,
    onToggleFavorite: () -> Unit,
    onBrowseCuisine: (String) -> Unit,
) {
    val cs = MaterialTheme.colorScheme
    Scaffold(
        containerColor = cs.background,
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
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
            else -> RecipeContent(recipe, state.pantry, state.conflicts, padding, onBrowseCuisine)
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun RecipeContent(
    recipe: Recipe,
    pantry: Pantry,
    conflicts: List<ProfileConflict>,
    padding: PaddingValues,
    onBrowseCuisine: (String) -> Unit,
) {
    val summary = recipe.summary
    // Have/missing marks only make sense once the user has listed something.
    val match = if (pantry.isEmpty) {
        null
    } else {
        val catalog = recipe.ingredients.associate { it.ingredient.id to it.ingredient }
        PantryMatcher.matchRecipe(summary, recipe.ingredients.map { it.ingredient.id }, catalog, pantry)
    }
    LazyColumn(
        contentPadding = PaddingValues(
            start = 20.dp,
            end = 20.dp,
            top = padding.calculateTopPadding() + 4.dp,
            bottom = padding.calculateBottomPadding() + 32.dp,
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxSize(),
    ) {
        if (conflicts.isNotEmpty()) {
            item("conflicts") {
                val names = recipe.ingredients.associate { it.ingredient.id to it.ingredient.name }
                ProfileConflictNotice(conflicts.map { c -> c.describe { id -> names[id] ?: id } })
            }
        }
        item("hero") { RecipeHero(recipe) }
        item("title") {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(summary.cuisine, style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary)
                Text(summary.title, style = MaterialTheme.typography.headlineMedium)
            }
        }
        item("facts") { FactsRow(recipe) }
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
        item("ingredients-header") {
            SectionHeader(
                "Ingredients",
                eyebrow = buildString {
                    append("Serves ${recipe.servings}")
                    if (match != null) append(" · You have ${match.have.size} of ${match.total}")
                },
                modifier = Modifier.padding(top = 16.dp),
            )
        }
        item("ingredients") { IngredientList(recipe, pantry.takeUnless { it.isEmpty }) }
        item("steps-header") {
            SectionHeader(
                "Method",
                eyebrow = if (recipe.steps.size == 1) "1 step" else "${recipe.steps.size} steps",
                modifier = Modifier.padding(top = 16.dp),
            )
        }
        itemsIndexed(recipe.steps, key = { i, _ -> "step-$i" }) { i, step -> StepRow(i + 1, step) }
        item("more") {
            CraveButton(
                "More ${summary.cuisine} recipes",
                onClick = { onBrowseCuisine(summary.cuisine) },
                variant = CraveButtonVariant.Secondary,
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            )
        }
        item("source") { SourceCredit(recipe) }
    }
}

@Composable
private fun RecipeHero(recipe: Recipe) {
    val accent = CraveTheme.extras.flavor[recipe.summary.flavor.dominant]
    CraveSurface(Modifier.fillMaxWidth(), hardShadow = false) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(Brush.linearGradient(listOf(accent.copy(alpha = 0.40f), accent.copy(alpha = 0.12f)))),
            contentAlignment = Alignment.Center,
        ) {
            Icon(recipe.summary.artIcon, contentDescription = null, tint = accent, modifier = Modifier.size(88.dp))
        }
    }
}

@Composable
private fun FactsRow(recipe: Recipe) {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        Fact(
            icon = Icons.Outlined.Schedule,
            value = "${recipe.summary.totalMinutes} min",
            label = "Prep ${recipe.prepMinutes} · Cook ${recipe.cookMinutes}",
            modifier = Modifier.weight(1.4f),
        )
        Fact(Icons.Outlined.People, "${recipe.servings}", "Servings", Modifier.weight(1f))
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

@Composable
private fun IngredientList(recipe: Recipe, pantry: Pantry?) {
    CraveSurface(Modifier.fillMaxWidth(), hardShadow = false) {
        Column(Modifier.padding(horizontal = 16.dp)) {
            recipe.ingredients.forEachIndexed { i, line ->
                if (i > 0) HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
                Row(Modifier.padding(vertical = 12.dp), verticalAlignment = Alignment.Top) {
                    Text(
                        line.rawMeasure,
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.width(112.dp),
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        line.rawName.replaceFirstChar { it.titlecase() },
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.weight(1f),
                    )
                    if (pantry != null) {
                        val have = pantry.owns(line.ingredient)
                        Spacer(Modifier.width(8.dp))
                        Icon(
                            if (have) Icons.Filled.CheckCircle else Icons.Outlined.AddCircleOutline,
                            contentDescription = if (have) "You have this" else "Missing",
                            tint = if (have) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(20.dp),
                        )
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
            TextButton(onClick = { uriHandler.openUri(recipe.sourceUrl) }) {
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
