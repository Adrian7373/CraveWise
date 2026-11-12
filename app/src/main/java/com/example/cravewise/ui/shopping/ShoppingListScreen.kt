package com.example.cravewise.ui.shopping

import android.content.Intent
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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.DeleteOutline
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.ShoppingBasket
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cravewise.domain.AisleSection
import com.example.cravewise.domain.ShoppingListView
import com.example.cravewise.domain.ShoppingRow
import com.example.cravewise.domain.model.Aisle
import com.example.cravewise.domain.model.Ingredient
import com.example.cravewise.domain.model.RecipeSummary
import com.example.cravewise.ui.designsystem.CraveButton
import com.example.cravewise.ui.designsystem.CraveChip
import com.example.cravewise.ui.designsystem.CravePreviews
import com.example.cravewise.ui.designsystem.readableWidth
import com.example.cravewise.ui.designsystem.CraveSearchField
import com.example.cravewise.ui.designsystem.CraveSurface
import com.example.cravewise.ui.designsystem.SectionHeader
import com.example.cravewise.ui.designsystem.ViaEmptyState
import com.example.cravewise.ui.recipe.PreviewRecipes
import com.example.cravewise.ui.theme.CraveTheme
import com.example.cravewise.ui.theme.CraveWiseTheme

@Composable
fun ShoppingListScreen(
    onBrowse: () -> Unit,
    viewModel: ShoppingViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    ShoppingListScreen(
        state = state,
        actions = ShoppingActions(
            onQueryChange = viewModel::onQueryChange,
            onSubmitQuery = viewModel::submitQuery,
            onAddIngredient = viewModel::addIngredient,
            onAddCustom = viewModel::addCustom,
            onToggle = { row -> viewModel.setChecked(row.key, !row.checked) },
            onDelete = { row -> viewModel.delete(row.key, row.name) },
            onRemoveRecipe = viewModel::removeRecipe,
            onFinishShopping = viewModel::finishShopping,
            onClearList = viewModel::clearList,
            onShare = {
                val send = Intent(Intent.ACTION_SEND)
                    .setType("text/plain")
                    .putExtra(Intent.EXTRA_TEXT, state.shareText)
                context.startActivity(Intent.createChooser(send, "Share shopping list"))
            },
            onUndo = viewModel::undo,
            onUndoDismissed = viewModel::undoDismissed,
            onBrowse = onBrowse,
        ),
    )
}

class ShoppingActions(
    val onQueryChange: (String) -> Unit,
    val onSubmitQuery: () -> Unit,
    val onAddIngredient: (Ingredient) -> Unit,
    val onAddCustom: (String) -> Unit,
    val onToggle: (ShoppingRow) -> Unit,
    val onDelete: (ShoppingRow) -> Unit,
    val onRemoveRecipe: (RecipeSummary) -> Unit,
    val onFinishShopping: () -> Unit,
    val onClearList: () -> Unit,
    val onShare: () -> Unit,
    val onUndo: () -> Unit,
    val onUndoDismissed: (Long) -> Unit,
    val onBrowse: () -> Unit,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListScreen(state: ShoppingUiState, actions: ShoppingActions) {
    val cs = MaterialTheme.colorScheme
    val snackbar = remember { SnackbarHostState() }
    val undo = state.undo
    LaunchedEffect(undo?.id) {
        if (undo == null) return@LaunchedEffect
        val result = snackbar.showSnackbar(undo.message, actionLabel = "Undo", duration = SnackbarDuration.Short)
        if (result == SnackbarResult.ActionPerformed) actions.onUndo() else actions.onUndoDismissed(undo.id)
    }
    Scaffold(
        containerColor = cs.background,
        snackbarHost = { SnackbarHost(snackbar) },
        topBar = {
            TopAppBar(
                title = { Text("Shopping list", style = MaterialTheme.typography.headlineSmall) },
                actions = {
                    if (state.list.toBuyCount > 0) {
                        IconButton(onClick = actions.onShare) {
                            Icon(Icons.Outlined.Share, contentDescription = "Share list")
                        }
                    }
                    if (!state.list.isEmpty) OverflowMenu(actions.onClearList)
                },
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
        val list = state.list
        LazyColumn(
            contentPadding = PaddingValues(
                start = 20.dp,
                end = 20.dp,
                top = padding.calculateTopPadding() + 4.dp,
                bottom = padding.calculateBottomPadding() + 32.dp,
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.readableWidth(),
        ) {
            item("search") {
                CraveSearchField(
                    value = state.query,
                    onValueChange = actions.onQueryChange,
                    placeholder = "Add an item, e.g. onions",
                    onSubmit = actions.onSubmitQuery,
                    leadingIcon = Icons.Outlined.Add,
                )
            }
            if (state.query.isNotBlank()) {
                item("suggestions") { Suggestions(state, actions) }
            }
            if (list.isEmpty) {
                item("empty") {
                    ViaEmptyState(
                        title = "Your basket's looking light",
                        body = "Add missing ingredients from any recipe, or type something above. I'll sort it all by aisle.",
                        actionLabel = "Browse recipes",
                        onAction = actions.onBrowse,
                    )
                }
                return@LazyColumn
            }
            if (state.recipes.isNotEmpty()) {
                item("recipes") { RecipeStrip(state.recipes, actions.onRemoveRecipe) }
            }
            item("to-buy-header") {
                SectionHeader(
                    "To buy",
                    eyebrow = itemCount(list.toBuyCount),
                    modifier = Modifier.padding(top = 8.dp),
                )
            }
            if (list.sections.isEmpty()) {
                item("all-in-basket") {
                    Text(
                        "Everything's in the basket. Tap Done shopping to stock your kitchen.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = cs.onSurfaceVariant,
                    )
                }
            }
            items(list.sections, key = { "aisle-${it.aisle.name}" }) { section ->
                AisleGroup(section, actions)
            }
            if (list.basket.isNotEmpty()) {
                item("basket-header") {
                    SectionHeader(
                        "In the basket",
                        eyebrow = itemCount(list.basket.size),
                        modifier = Modifier.padding(top = 16.dp),
                    )
                }
                item("basket") { RowCard(list.basket, actions) }
                item("done") {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        CraveButton(
                            "Done shopping",
                            onClick = actions.onFinishShopping,
                            icon = Icons.Outlined.ShoppingBasket,
                            modifier = Modifier.fillMaxWidth(),
                        )
                        Text(
                            "Clears the basket and adds those ingredients to My Kitchen.",
                            style = MaterialTheme.typography.bodySmall,
                            color = cs.onSurfaceVariant,
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun OverflowMenu(onClearList: () -> Unit) {
    var open by remember { mutableStateOf(false) }
    Box {
        IconButton(onClick = { open = true }) {
            Icon(Icons.Outlined.MoreVert, contentDescription = "More options")
        }
        DropdownMenu(expanded = open, onDismissRequest = { open = false }) {
            DropdownMenuItem(
                text = { Text("Clear whole list") },
                leadingIcon = { Icon(Icons.Outlined.DeleteOutline, contentDescription = null) },
                onClick = {
                    open = false
                    onClearList()
                },
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun Suggestions(state: ShoppingUiState, actions: ShoppingActions) {
    FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        state.suggestions.forEach { ingredient ->
            AddChip(ingredient.name) { actions.onAddIngredient(ingredient) }
        }
        state.customSuggestion?.let { text ->
            AddChip("Add “$text”") { actions.onAddCustom(text) }
        }
    }
}

@Composable
private fun AddChip(text: String, onClick: () -> Unit) {
    CraveChip(
        text = text,
        selected = false,
        onClick = onClick,
        leading = { Icon(Icons.Outlined.Add, contentDescription = null, modifier = Modifier.size(16.dp)) },
        modifier = Modifier.semantics { role = Role.Button },
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun RecipeStrip(recipes: List<RecipeSummary>, onRemove: (RecipeSummary) -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("For these recipes", style = MaterialTheme.typography.titleMedium)
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            recipes.forEach { recipe ->
                CraveChip(
                    text = recipe.title,
                    selected = false,
                    onClick = { onRemove(recipe) },
                    trailingIcon = Icons.Outlined.Close,
                    trailingIconDescription = "Remove ingredients for ${recipe.title}",
                )
            }
        }
    }
}

@Composable
private fun AisleGroup(section: AisleSection, actions: ShoppingActions) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(section.aisle.label, style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1f))
            Text(
                "${section.rows.size}",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
        RowCard(section.rows, actions)
    }
}

@Composable
private fun RowCard(rows: List<ShoppingRow>, actions: ShoppingActions) {
    CraveSurface(Modifier.fillMaxWidth(), hardShadow = false) {
        Column {
            rows.forEachIndexed { i, row ->
                if (i > 0) HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
                key(row.key) { SwipeableRow(row, actions) }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SwipeableRow(row: ShoppingRow, actions: ShoppingActions) {
    val dismiss = rememberSwipeToDismissBoxState()
    val onDelete by rememberUpdatedState(actions.onDelete)
    val current by rememberUpdatedState(row)
    LaunchedEffect(dismiss.currentValue) {
        if (dismiss.currentValue == SwipeToDismissBoxValue.EndToStart) onDelete(current)
    }
    SwipeToDismissBox(
        state = dismiss,
        enableDismissFromStartToEnd = false,
        backgroundContent = {
            Box(
                Modifier.fillMaxSize().background(MaterialTheme.colorScheme.errorContainer).padding(horizontal = 20.dp),
                contentAlignment = Alignment.CenterEnd,
            ) {
                Icon(
                    Icons.Outlined.DeleteOutline,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onErrorContainer,
                )
            }
        },
    ) {
        ShoppingRowContent(row, onToggle = { actions.onToggle(row) })
    }
}

@Composable
private fun ShoppingRowContent(row: ShoppingRow, onToggle: () -> Unit) {
    val cs = MaterialTheme.colorScheme
    Row(
        Modifier
            .fillMaxWidth()
            .background(CraveTheme.extras.cardColor)
            .toggleable(value = row.checked, role = Role.Checkbox, onValueChange = { onToggle() })
            .heightIn(min = 56.dp)
            .padding(start = 4.dp, end = 16.dp, top = 6.dp, bottom = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // The whole row toggles; the checkbox only mirrors state so taps aren't handled twice.
        Checkbox(checked = row.checked, onCheckedChange = null, modifier = Modifier.padding(12.dp))
        Spacer(Modifier.width(4.dp))
        Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Text(
                row.name,
                style = MaterialTheme.typography.bodyLarge,
                textDecoration = if (row.checked) TextDecoration.LineThrough else null,
                color = if (row.checked) cs.onSurfaceVariant else cs.onSurface,
            )
            row.detail?.let {
                Text(it, style = MaterialTheme.typography.labelMedium, color = cs.onSurfaceVariant)
            }
        }
    }
}

private fun itemCount(n: Int) = if (n == 1) "1 item" else "$n items"

// ---------------------------------------------------------------------------------------------
// Previews
// ---------------------------------------------------------------------------------------------

private val previewActions = ShoppingActions({}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {})

private object PreviewShopping {
    private fun row(key: String, name: String, aisle: Aisle, quantity: String?, recipes: Int, checked: Boolean = false) =
        ShoppingRow(key, key, name, aisle, checked, quantity, recipes)

    val view = ShoppingListView(
        sections = listOf(
            AisleSection(
                Aisle.Produce,
                listOf(
                    row("lemon", "Lemon", Aisle.Produce, "2", 1),
                    row("onion", "Onion", Aisle.Produce, "1.2 kg", 2),
                ),
            ),
            AisleSection(Aisle.MeatSeafood, listOf(row("beef", "Beef", Aisle.MeatSeafood, "500 g", 1))),
            AisleSection(
                Aisle.Other,
                listOf(ShoppingRow("custom:paper towels", null, "Paper towels", Aisle.Other, false, null, 0)),
            ),
        ),
        basket = listOf(row("soy_sauce", "Soy sauce", Aisle.Condiments, "3 tbsp", 1, checked = true)),
        recipeIds = listOf(PreviewRecipes.bistek.id, PreviewRecipes.stirFry.id),
    )
}

@CravePreviews
@Composable
private fun ShoppingListPreview() = CraveWiseTheme {
    ShoppingListScreen(
        state = ShoppingUiState(
            isLoading = false,
            list = PreviewShopping.view,
            recipes = listOf(PreviewRecipes.bistek, PreviewRecipes.stirFry),
        ),
        actions = previewActions,
    )
}

@CravePreviews
@Composable
private fun ShoppingEmptyPreview() = CraveWiseTheme {
    ShoppingListScreen(
        state = ShoppingUiState(isLoading = false, query = "paper tow", customSuggestion = "paper tow"),
        actions = previewActions,
    )
}
