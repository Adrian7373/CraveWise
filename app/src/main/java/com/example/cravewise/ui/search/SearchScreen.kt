package com.example.cravewise.ui.search

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
import androidx.compose.material.icons.outlined.Block
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.FilterAlt
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Kitchen
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cravewise.domain.search.QueryChip
import com.example.cravewise.domain.search.SearchResult
import com.example.cravewise.ui.designsystem.CraveChip
import com.example.cravewise.ui.designsystem.CravePreviews
import com.example.cravewise.ui.designsystem.CraveSearchField
import com.example.cravewise.ui.designsystem.CraveSurface
import com.example.cravewise.ui.designsystem.CraveTag
import com.example.cravewise.ui.designsystem.SectionHeader
import com.example.cravewise.ui.designsystem.ViaEmptyState
import com.example.cravewise.ui.designsystem.ViaSays
import com.example.cravewise.ui.recipe.PreviewRecipes
import com.example.cravewise.ui.recipe.RecipeSummaryCard
import com.example.cravewise.ui.theme.CraveWiseTheme

@Composable
fun SearchScreen(
    onRecipeClick: (String) -> Unit,
    onBrowse: () -> Unit,
    onOpenProfile: () -> Unit,
    onOpenKitchen: () -> Unit,
    viewModel: SearchViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    SearchScreen(
        state = state,
        actions = SearchActions(
            onQueryChange = viewModel::onQueryChange,
            onSubmit = viewModel::submit,
            onClear = viewModel::clearQuery,
            onSearchFor = viewModel::searchFor,
            onClearRecent = viewModel::clearRecent,
            onRecipeClick = { id ->
                viewModel.onResultOpened()
                onRecipeClick(id)
            },
            onBrowse = onBrowse,
            onOpenProfile = onOpenProfile,
            onOpenKitchen = onOpenKitchen,
        ),
    )
}

class SearchActions(
    val onQueryChange: (String) -> Unit,
    val onSubmit: () -> Unit,
    val onClear: () -> Unit,
    val onSearchFor: (String) -> Unit,
    val onClearRecent: () -> Unit,
    val onRecipeClick: (String) -> Unit,
    val onBrowse: () -> Unit,
    val onOpenProfile: () -> Unit,
    val onOpenKitchen: () -> Unit,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(state: SearchUiState, actions: SearchActions) {
    val cs = MaterialTheme.colorScheme
    Scaffold(
        containerColor = cs.background,
        topBar = {
            TopAppBar(
                title = { Text("Search", style = MaterialTheme.typography.headlineSmall) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = cs.background),
            )
        },
    ) { padding ->
        // Collapsed "close matches" resets for every new query.
        var showAllClose by rememberSaveable(state.query) { mutableStateOf(false) }
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
            item("search") {
                CraveSearchField(
                    value = state.query,
                    onValueChange = actions.onQueryChange,
                    placeholder = "Try “creamy and quick”",
                    onSubmit = actions.onSubmit,
                    onClear = actions.onClear,
                    imeAction = ImeAction.Search,
                )
            }
            when {
                !state.hasQuery -> startContent(state, actions)
                state.isLoading -> item("loading") {
                    Box(Modifier.fillMaxWidth().padding(32.dp), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }
                else -> results(state, showAllClose, { showAllClose = !showAllClose }, actions)
            }
        }
    }
}

private fun LazyListScope.startContent(state: SearchUiState, actions: SearchActions) {
    item("via") {
        ViaSays("Tell me a flavor, a vibe or an ingredient, and anything to skip. I'll sniff out a match!")
    }
    item("suggestions") {
        ChipSection("Try one of these", SearchViewModel.SUGGESTIONS, icon = null, onClick = actions.onSearchFor)
    }
    if (state.recent.isNotEmpty()) {
        item("recent") {
            ChipSection(
                "Recent searches",
                state.recent,
                icon = Icons.Outlined.History,
                onClick = actions.onSearchFor,
                actionLabel = "Clear",
                onAction = actions.onClearRecent,
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ChipSection(
    title: String,
    queries: List<String>,
    icon: ImageVector?,
    onClick: (String) -> Unit,
    actionLabel: String? = null,
    onAction: () -> Unit = {},
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(title, style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1f))
            if (actionLabel != null) {
                TextButton(onClick = onAction) { Text(actionLabel, style = MaterialTheme.typography.labelLarge) }
            }
        }
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            queries.forEach { q ->
                CraveChip(
                    text = q,
                    selected = false,
                    onClick = { onClick(q) },
                    leading = icon?.let { { Icon(it, contentDescription = null, modifier = Modifier.size(16.dp)) } },
                )
            }
        }
    }
}

private fun LazyListScope.results(
    state: SearchUiState,
    showAllClose: Boolean,
    onToggleClose: () -> Unit,
    actions: SearchActions,
) {
    if (state.chips.isNotEmpty()) {
        item("understood") { Understood(state.chips) }
    }
    if (state.pantryEmpty) {
        item("pantry-empty") {
            Note(
                "Your kitchen is empty, so I searched the whole cookbook.",
                actionLabel = "Add ingredients",
                onAction = actions.onOpenKitchen,
            )
        }
    }
    if (state.unmatchedTerms.isNotEmpty()) {
        item("unknown") {
            val words = state.unmatchedTerms.joinToString(", ") { "“$it”" }
            Note("No recipe mentions $words yet.")
        }
    }

    if (!state.hasResults) {
        item("empty") {
            if (state.hiddenByProfile) {
                ViaEmptyState(
                    title = "Hidden by your profile",
                    body = "I found matches, but none of them fit your food profile. Try another craving, or check your profile.",
                    actionLabel = "Review my profile",
                    onAction = actions.onOpenProfile,
                )
            } else {
                ViaEmptyState(
                    title = "Nothing on the menu",
                    body = "I couldn't find a match for that. Try fewer words, or browse the whole cookbook.",
                    actionLabel = "Browse recipes",
                    onAction = actions.onBrowse,
                )
            }
        }
        return
    }

    if (!state.split) {
        section("results", "Results", countLabel(state.best.size), state.best, actions)
        return
    }
    if (state.best.isNotEmpty()) {
        section("best", "Best matches", "Everything you asked for · ${state.best.size}", state.best, actions)
    }
    val close = state.close
    val visible = if (showAllClose) close else close.take(CLOSE_PREVIEW)
    section(
        key = "close",
        title = if (state.best.isEmpty()) "Closest matches" else "Close matches",
        eyebrow = "Some of what you asked for · ${close.size}",
        results = visible,
        actions = actions,
        actionLabel = when {
            close.size <= CLOSE_PREVIEW -> null
            showAllClose -> "Show fewer"
            else -> "Show all ${close.size}"
        },
        onAction = onToggleClose,
    )
}

private fun countLabel(n: Int) = if (n == 1) "1 recipe" else "$n recipes"

private fun LazyListScope.section(
    key: String,
    title: String,
    eyebrow: String,
    results: List<SearchResult>,
    actions: SearchActions,
    actionLabel: String? = null,
    onAction: () -> Unit = {},
) {
    if (results.isEmpty()) return
    item("$key-header") {
        SectionHeader(title, eyebrow = eyebrow, actionLabel = actionLabel, onAction = onAction, modifier = Modifier.padding(top = 8.dp))
    }
    items(results, key = { "$key-${it.recipe.id}" }) { result ->
        ResultCard(result, onClick = { actions.onRecipeClick(result.recipe.id) })
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ResultCard(result: SearchResult, onClick: () -> Unit) {
    RecipeSummaryCard(
        recipe = result.recipe,
        onClick = onClick,
        matchPercent = result.pantry?.matchPercent,
        footer = if (result.reasons.isEmpty()) {
            null
        } else {
            {
                FlowRow(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    result.reasons.forEach { CraveTag(it, icon = Icons.Outlined.Check) }
                }
            }
        },
    )
}

/** "Looking for" row: how the query was understood, so surprises are visible. */
@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun Understood(chips: List<QueryChip>) {
    val cs = MaterialTheme.colorScheme
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("Looking for", style = MaterialTheme.typography.labelLarge, color = cs.onSurfaceVariant)
        FlowRow(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            chips.forEach { chip ->
                when (chip.kind) {
                    QueryChip.Kind.Want -> CraveTag(chip.label)
                    QueryChip.Kind.Filter -> CraveTag(
                        chip.label,
                        icon = Icons.Outlined.FilterAlt,
                        color = cs.secondaryContainer,
                        contentColor = cs.onSecondaryContainer,
                    )
                    QueryChip.Kind.Exclude -> CraveTag(
                        chip.label,
                        icon = Icons.Outlined.Block,
                        color = cs.surfaceContainerHighest,
                        contentColor = cs.onSurface,
                    )
                    QueryChip.Kind.Pantry -> CraveTag(
                        chip.label,
                        icon = Icons.Outlined.Kitchen,
                        color = cs.secondaryContainer,
                        contentColor = cs.onSecondaryContainer,
                    )
                }
            }
        }
    }
}

@Composable
private fun Note(text: String, actionLabel: String? = null, onAction: () -> Unit = {}) {
    val cs = MaterialTheme.colorScheme
    CraveSurface(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        color = cs.surfaceContainer,
        contentColor = cs.onSurfaceVariant,
        hardShadow = false,
    ) {
        Row(Modifier.padding(horizontal = 16.dp, vertical = 12.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Outlined.Info, contentDescription = null, modifier = Modifier.size(20.dp))
            Spacer(Modifier.width(12.dp))
            Text(text, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.weight(1f))
            if (actionLabel != null) {
                TextButton(onClick = onAction) { Text(actionLabel, style = MaterialTheme.typography.labelLarge) }
            }
        }
    }
}

private const val CLOSE_PREVIEW = 5

// ---------------------------------------------------------------------------------------------
// Previews
// ---------------------------------------------------------------------------------------------

private val previewActions = SearchActions({}, {}, {}, {}, {}, {}, {}, {}, {})

@CravePreviews
@Composable
private fun SearchStartPreview() = CraveWiseTheme {
    SearchScreen(
        state = SearchUiState(isLoading = false, recent = listOf("Spicy noodles", "Creamy and quick")),
        actions = previewActions,
    )
}

@CravePreviews
@Composable
private fun SearchResultsPreview() = CraveWiseTheme {
    SearchScreen(
        state = SearchUiState(
            isLoading = false,
            query = "salty beef, no dairy",
            chips = listOf(
                QueryChip("Salty", QueryChip.Kind.Want),
                QueryChip("Beef", QueryChip.Kind.Want),
                QueryChip("Under 30 min", QueryChip.Kind.Filter),
                QueryChip("No dairy", QueryChip.Kind.Exclude),
            ),
            split = true,
            best = listOf(SearchResult(PreviewRecipes.bistek, listOf("Salty 4/5", "Beef"), 2, 14)),
            close = listOf(SearchResult(PreviewRecipes.stirFry, listOf("Beef"), 1, 6)),
            unmatchedTerms = listOf("zorbo"),
        ),
        actions = previewActions,
    )
}

@CravePreviews
@Composable
private fun SearchEmptyPreview() = CraveWiseTheme {
    SearchScreen(
        state = SearchUiState(
            isLoading = false,
            query = "something sweet",
            chips = listOf(QueryChip("Sweet", QueryChip.Kind.Want)),
            hiddenByProfile = true,
        ),
        actions = previewActions,
    )
}
