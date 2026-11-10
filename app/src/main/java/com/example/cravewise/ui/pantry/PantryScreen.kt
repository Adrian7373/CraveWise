package com.example.cravewise.ui.pantry

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cravewise.domain.PantryMatch
import com.example.cravewise.domain.PantryMatcher
import com.example.cravewise.domain.PantryResults
import com.example.cravewise.domain.model.Ingredient
import com.example.cravewise.ui.designsystem.CraveChip
import com.example.cravewise.ui.designsystem.CravePreviews
import com.example.cravewise.ui.designsystem.CraveSearchField
import com.example.cravewise.ui.designsystem.CraveSurface
import com.example.cravewise.ui.designsystem.IngredientPill
import com.example.cravewise.ui.designsystem.SectionHeader
import com.example.cravewise.ui.designsystem.ViaEmptyState
import com.example.cravewise.ui.designsystem.ViaSays
import com.example.cravewise.ui.recipe.PreviewRecipes
import com.example.cravewise.ui.recipe.RecipeSummaryCard
import com.example.cravewise.ui.theme.CraveWiseTheme

@Composable
fun PantryScreen(
    onRecipeClick: (String) -> Unit,
    onBrowse: () -> Unit,
    viewModel: PantryViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    PantryScreen(
        state = state,
        actions = PantryActions(
            onQueryChange = viewModel::onQueryChange,
            onSubmitQuery = viewModel::submitQuery,
            onAdd = viewModel::add,
            onRemove = viewModel::remove,
            onClear = viewModel::clearPantry,
            onAssumeStaples = viewModel::setAssumeStaples,
            onRecipeClick = onRecipeClick,
            onBrowse = onBrowse,
        ),
    )
}

class PantryActions(
    val onQueryChange: (String) -> Unit,
    val onSubmitQuery: () -> Unit,
    val onAdd: (String) -> Unit,
    val onRemove: (String) -> Unit,
    val onClear: () -> Unit,
    val onAssumeStaples: (Boolean) -> Unit,
    val onRecipeClick: (String) -> Unit,
    val onBrowse: () -> Unit,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantryScreen(state: PantryUiState, actions: PantryActions) {
    val cs = MaterialTheme.colorScheme
    Scaffold(
        containerColor = cs.background,
        topBar = {
            TopAppBar(
                title = { Text("My Kitchen", style = MaterialTheme.typography.headlineSmall) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = cs.background),
            )
        },
    ) { padding ->
        if (state.isLoading) {
            Box(Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
            return@Scaffold
        }
        var showAllShopping by rememberSaveable { mutableStateOf(false) }
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
            if (!state.hasPantry) {
                item("via") { ViaSays("Tell me what's in your fridge and I'll find something slurp-worthy!") }
            }
            item("search") {
                CraveSearchField(
                    value = state.query,
                    onValueChange = actions.onQueryChange,
                    placeholder = "Add an ingredient, e.g. garlic",
                    onSubmit = actions.onSubmitQuery,
                )
            }
            if (state.query.isNotBlank()) {
                item("suggestions") { Suggestions(state, actions.onAdd) }
            }
            if (state.hasPantry) {
                item("kitchen") { KitchenSection(state.pantryItems, actions.onRemove, actions.onClear) }
            }
            if (state.quickAdd.isNotEmpty()) {
                item("quick-add") { QuickAddSection(state.quickAdd, actions.onAdd) }
            }
            if (state.staples.isNotEmpty()) {
                item("basics") { BasicsToggle(state.assumeStaples, state.staples, actions.onAssumeStaples) }
            }
            if (state.hasPantry) {
                results(state.results, showAllShopping, { showAllShopping = !showAllShopping }, actions)
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun Suggestions(state: PantryUiState, onAdd: (String) -> Unit) {
    if (state.suggestions.isEmpty()) {
        Text(
            "No ingredient called “${state.query.trim()}” in the cookbook yet. Try another name?",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        return
    }
    FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        state.suggestions.forEach { AddChip(it, onAdd) }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun KitchenSection(items: List<Ingredient>, onRemove: (String) -> Unit, onClear: () -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        SectionHeader(
            "In your kitchen",
            eyebrow = if (items.size == 1) "1 ingredient" else "${items.size} ingredients",
            actionLabel = "Clear all",
            onAction = onClear,
        )
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items.forEach { ingredient ->
                CraveChip(
                    text = ingredient.name,
                    selected = true,
                    onClick = { onRemove(ingredient.id) },
                    trailingIcon = Icons.Outlined.Close,
                    trailingIconDescription = "Remove ${ingredient.name}",
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun QuickAddSection(items: List<Ingredient>, onAdd: (String) -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Quick add", style = MaterialTheme.typography.titleMedium)
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items.forEach { AddChip(it, onAdd) }
        }
    }
}

@Composable
private fun AddChip(ingredient: Ingredient, onAdd: (String) -> Unit) {
    CraveChip(
        text = ingredient.name,
        selected = false,
        onClick = { onAdd(ingredient.id) },
        leading = { Icon(Icons.Outlined.Add, contentDescription = null, modifier = Modifier.size(16.dp)) },
        modifier = Modifier.semantics { role = Role.Button },
    )
}

@Composable
private fun BasicsToggle(assume: Boolean, staples: List<Ingredient>, onChange: (Boolean) -> Unit) {
    CraveSurface(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        hardShadow = false,
        onClick = { onChange(!assume) },
    ) {
        Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text("I have the basics", style = MaterialTheme.typography.titleMedium)
                Text(
                    staples.joinToString(", ") { it.name },
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
            Spacer(Modifier.width(12.dp))
            // The whole row toggles; the switch only mirrors state so taps aren't handled twice.
            Switch(checked = assume, onCheckedChange = null)
        }
    }
}

private fun LazyListScope.results(
    results: PantryResults,
    showAllShopping: Boolean,
    onToggleShowAll: () -> Unit,
    actions: PantryActions,
) {
    if (results.isEmpty) {
        item("empty") {
            ViaEmptyState(
                title = "Nothing cooking yet",
                body = "None of my recipes use those yet. Add a few more ingredients, or browse the whole cookbook.",
                actionLabel = "Browse recipes",
                onAction = actions.onBrowse,
            )
        }
        return
    }
    bucket("cook-now", "Cook now", "Nothing missing", results.cookNow, actions)
    val almost = PantryMatcher.ALMOST_THERE_MAX_MISSING
    bucket("almost", "Almost there", "Missing 1–$almost", results.almostThere, actions)

    val shopping = results.needsShopping
    val visible = if (showAllShopping) shopping else shopping.take(SHOPPING_PREVIEW)
    val canToggle = shopping.size > SHOPPING_PREVIEW
    bucket(
        key = "shopping",
        title = "Worth a shop",
        eyebrow = "Missing ${almost + 1}+",
        matches = visible,
        actions = actions,
        count = shopping.size,
        actionLabel = when {
            !canToggle -> null
            showAllShopping -> "Show fewer"
            else -> "Show all ${shopping.size}"
        },
        onAction = onToggleShowAll,
    )
}

private fun LazyListScope.bucket(
    key: String,
    title: String,
    eyebrow: String,
    matches: List<PantryMatch>,
    actions: PantryActions,
    count: Int = matches.size,
    actionLabel: String? = null,
    onAction: () -> Unit = {},
) {
    if (matches.isEmpty()) return
    item("$key-header") {
        SectionHeader(
            title,
            eyebrow = "$eyebrow · $count",
            actionLabel = actionLabel,
            onAction = onAction,
            modifier = Modifier.padding(top = 16.dp),
        )
    }
    items(matches, key = { "$key-${it.recipe.id}" }) { match ->
        MatchCard(match, onClick = { actions.onRecipeClick(match.recipe.id) })
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun MatchCard(match: PantryMatch, onClick: () -> Unit) {
    RecipeSummaryCard(
        recipe = match.recipe,
        onClick = onClick,
        matchPercent = match.matchPercent,
        footer = {
            Text(
                if (match.missing.isEmpty()) {
                    "You have all ${match.total} ingredients"
                } else {
                    "You have ${match.have.size} of ${match.total}. Missing:"
                },
                style = MaterialTheme.typography.labelLarge,
            )
            if (match.missing.isNotEmpty()) {
                FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    match.missing.forEach { IngredientPill(it.name, have = false) }
                }
            }
        },
    )
}

private const val SHOPPING_PREVIEW = 3

// ---------------------------------------------------------------------------------------------
// Previews
// ---------------------------------------------------------------------------------------------

private val previewActions = PantryActions({}, {}, {}, {}, {}, {}, {}, {})

private object PreviewPantry {
    private val lines = PreviewRecipes.recipe.ingredients
    val ingredients = lines.map { it.ingredient }
    val staples = ingredients.filter { it.id in setOf("salt", "garlic") }.map { it.copy(isPantryStaple = true) }
    val beef = ingredients.first { it.id == "beef" }
    val lemon = ingredients.first { it.id == "lemon" }
    val soy = ingredients.first { it.id == "soy_sauce" }

    val results = PantryResults(
        almostThere = listOf(
            PantryMatch(PreviewRecipes.bistek, have = listOf(beef, soy) + staples, missing = listOf(lemon), usesFromPantry = 2),
        ),
        needsShopping = listOf(
            PantryMatch(PreviewRecipes.stirFry, have = listOf(beef), missing = listOf(lemon, soy, lemon.copy(id = "basil", name = "Basil")), usesFromPantry = 1),
        ),
    )
}

@CravePreviews
@Composable
private fun PantryResultsPreview() = CraveWiseTheme {
    PantryScreen(
        state = PantryUiState(
            isLoading = false,
            pantryItems = listOf(PreviewPantry.beef, PreviewPantry.soy),
            staples = PreviewPantry.staples,
            quickAdd = listOf(PreviewPantry.lemon),
            results = PreviewPantry.results,
        ),
        actions = previewActions,
    )
}

@CravePreviews
@Composable
private fun PantryEmptyPreview() = CraveWiseTheme {
    PantryScreen(
        state = PantryUiState(
            isLoading = false,
            query = "gar",
            suggestions = PreviewPantry.ingredients.filter { it.id == "garlic" },
            staples = PreviewPantry.staples,
            quickAdd = PreviewPantry.ingredients,
        ),
        actions = previewActions,
    )
}

@CravePreviews
@Composable
private fun PantryNoMatchesPreview() = CraveWiseTheme {
    PantryScreen(
        state = PantryUiState(
            isLoading = false,
            pantryItems = listOf(PreviewPantry.lemon),
            staples = PreviewPantry.staples,
        ),
        actions = previewActions,
    )
}
