package com.example.cravewise.ui.cookbook

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.outlined.ArrowUpward
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.example.cravewise.ui.designsystem.CraveButton
import com.example.cravewise.ui.designsystem.CraveButtonVariant
import com.example.cravewise.ui.designsystem.SectionHeader
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cravewise.domain.BrowseFilter
import com.example.cravewise.domain.model.Diet
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.navigation.BrowseRoute
import com.example.cravewise.ui.designsystem.CraveChip
import com.example.cravewise.ui.designsystem.CraveLayout
import com.example.cravewise.ui.designsystem.CravePreviews
import com.example.cravewise.ui.designsystem.ViaEmptyState
import com.example.cravewise.ui.recipe.PreviewRecipes
import com.example.cravewise.ui.recipe.RecipeSummaryCard
import com.example.cravewise.ui.theme.CraveWiseTheme

@Composable
fun BrowseScreen(
    route: BrowseRoute,
    onBack: () -> Unit,
    onRecipeClick: (String) -> Unit,
    onOpenProfile: () -> Unit,
    viewModel: BrowseViewModel = hiltViewModel<BrowseViewModel, BrowseViewModel.Factory>(
        creationCallback = { it.create(route) },
    ),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    BrowseScreen(
        state = state,
        actions = BrowseActions(
            onBack = onBack,
            onRecipeClick = onRecipeClick,
            onMealType = viewModel::setMealType,
            onCuisine = viewModel::setCuisine,
            onToggleDiet = viewModel::toggleDiet,
            onToggleQuick = viewModel::toggleQuick,
            onClearFilters = viewModel::clearFilters,
            onOpenProfile = onOpenProfile,
            onShelf = viewModel::applyShelf,
        ),
    )
}

class BrowseActions(
    val onBack: () -> Unit,
    val onRecipeClick: (String) -> Unit,
    val onMealType: (MealType?) -> Unit,
    val onCuisine: (String?) -> Unit,
    val onToggleDiet: (Diet) -> Unit,
    val onToggleQuick: () -> Unit,
    val onClearFilters: () -> Unit,
    val onOpenProfile: () -> Unit,
    val onShelf: (BrowseShelf) -> Unit,
)

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun BrowseScreen(state: BrowseUiState, actions: BrowseActions) {
    val cs = MaterialTheme.colorScheme
    val gridState = rememberLazyGridState()
    val scope = rememberCoroutineScope()
    val scrollToTop: () -> Unit = { scope.launch { gridState.animateScrollToItem(0) } }
    // "See all" on a shelf filters in place; Back returns to the shelves before leaving.
    BackHandler(enabled = state.backClearsFilters) { actions.onClearFilters() }
    // A new filter starts at the top, not mid-way down the previous list.
    LaunchedEffect(state.filter) { gridState.scrollToItem(0) }
    Scaffold(
        containerColor = cs.background,
        topBar = {
            TopAppBar(
                title = { Text(state.title, style = MaterialTheme.typography.headlineSmall) },
                navigationIcon = {
                    IconButton(onClick = actions.onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
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
        val filter = state.filter
        // Adaptive grid: one column on phones and in a tablet's list pane, more when full-width.
        // Headers span every column; chip rows bleed past the gutter so they scroll edge to edge.
        // Top padding goes on the grid itself (not contentPadding) so the sticky bar pins just
        // under the top app bar instead of behind it.
        LazyVerticalGrid(
            columns = GridCells.Adaptive(CraveLayout.CardMinWidth),
            state = gridState,
            contentPadding = PaddingValues(
                start = CraveLayout.Gutter,
                end = CraveLayout.Gutter,
                top = 4.dp,
                bottom = padding.calculateBottomPadding() + 24.dp,
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize().padding(top = padding.calculateTopPadding()),
        ) {
            fullWidthItem("meal-types") {
                ChipRow {
                    item { CraveChip("All meals", filter.mealType == null, onClick = { actions.onMealType(null) }) }
                    items(state.mealTypes) { type ->
                        CraveChip(
                            type.label,
                            selected = filter.mealType == type,
                            onClick = { actions.onMealType(if (filter.mealType == type) null else type) },
                        )
                    }
                }
            }
            fullWidthItem("cuisines") {
                ChipRow {
                    item { CraveChip("All cuisines", filter.cuisine == null, onClick = { actions.onCuisine(null) }) }
                    items(state.cuisines) { cuisine ->
                        CraveChip(
                            cuisine,
                            selected = filter.cuisine == cuisine,
                            onClick = { actions.onCuisine(if (filter.cuisine == cuisine) null else cuisine) },
                        )
                    }
                }
            }
            fullWidthItem("diets") {
                ChipRow {
                    item {
                        CraveChip(
                            "Under ${BrowseFilter.QUICK_MINUTES} min",
                            selected = filter.maxMinutes != null,
                            onClick = actions.onToggleQuick,
                        )
                    }
                    items(Diet.entries) { diet ->
                        CraveChip(diet.label, selected = diet in filter.diets, onClick = { actions.onToggleDiet(diet) })
                    }
                }
            }
            if (state.showShelves) {
                shelves(state.shelves, actions)
                return@LazyVerticalGrid
            }
            // Pinned while the chip rows scroll away, so the count and a way back to the
            // filters are always one tap off.
            stickyHeader("count") {
                val filtersOffScreen by remember { derivedStateOf { gridState.firstVisibleItemIndex >= FILTER_ROWS } }
                ResultsBar(
                    count = state.results.size,
                    showFiltersButton = filtersOffScreen,
                    onFilters = scrollToTop,
                    onClear = actions.onClearFilters.takeIf { !filter.isEmpty },
                )
            }
            if (state.results.isEmpty() && state.hiddenByProfile) {
                fullWidthItem("empty") {
                    ViaEmptyState(
                        title = "Hidden by your profile",
                        body = "There are recipes here, but they don't fit your food profile. Loosen a filter, or check your profile settings.",
                        actionLabel = "Review my profile",
                        onAction = actions.onOpenProfile,
                    )
                }
            } else if (state.results.isEmpty()) {
                fullWidthItem("empty") {
                    ViaEmptyState(
                        title = "Nothing on this menu",
                        body = "No recipes tick every box yet. Loosen a filter and I'll dig through the cookbook again.",
                        actionLabel = "Clear filters",
                        onAction = actions.onClearFilters,
                    )
                }
            }
            items(state.results, key = { it.id }) { recipe ->
                RecipeSummaryCard(recipe, onClick = { actions.onRecipeClick(recipe.id) })
            }
            if (state.results.size > END_NOTE_MIN) {
                fullWidthItem("end") { EndOfList(state.results.size, onBackToTop = scrollToTop) }
            }
        }
    }
}

/** Chip rows above the results (meal types, cuisines, quick + diets). */
private const val FILTER_ROWS = 3

/** Short lists end on their own; long ones get an explicit end and a way back up. */
private const val END_NOTE_MIN = 6

private fun LazyGridScope.shelves(shelves: List<BrowseShelf>, actions: BrowseActions) {
    shelves.forEach { shelf ->
        fullWidthItem("shelf-head-${shelf.key}") {
            SectionHeader(
                shelf.title,
                eyebrow = if (shelf.count == 1) "1 recipe" else "${shelf.count} recipes",
                actionLabel = "See all",
                onAction = { actions.onShelf(shelf) },
                modifier = Modifier.padding(top = 16.dp),
            )
        }
        fullWidthItem("shelf-${shelf.key}") {
            LazyRow(
                modifier = Modifier.bleed(CraveLayout.Gutter),
                contentPadding = PaddingValues(horizontal = CraveLayout.Gutter),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                items(shelf.picks, key = { it.id }) { recipe ->
                    RecipeSummaryCard(
                        recipe,
                        onClick = { actions.onRecipeClick(recipe.id) },
                        modifier = Modifier.width(ShelfCardWidth),
                        titleMinLines = 2,
                    )
                }
            }
        }
    }
}

private val ShelfCardWidth = 260.dp

@Composable
private fun ResultsBar(count: Int, showFiltersButton: Boolean, onFilters: () -> Unit, onClear: (() -> Unit)?) {
    val cs = MaterialTheme.colorScheme
    Row(
        Modifier
            .bleed(CraveLayout.Gutter)
            .background(cs.background)
            .padding(horizontal = CraveLayout.Gutter)
            .heightIn(min = 48.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            if (count == 1) "1 recipe" else "$count recipes",
            style = MaterialTheme.typography.labelLarge,
            color = cs.onSurfaceVariant,
            modifier = Modifier.weight(1f),
        )
        if (showFiltersButton) {
            TextButton(onClick = onFilters) {
                Icon(Icons.Outlined.Tune, contentDescription = null, modifier = Modifier.size(18.dp))
                Spacer(Modifier.width(6.dp))
                Text("Filters", style = MaterialTheme.typography.labelLarge)
            }
        }
        if (onClear != null) {
            TextButton(onClick = onClear) {
                Text("Clear filters", style = MaterialTheme.typography.labelLarge)
            }
        }
    }
}

@Composable
private fun EndOfList(count: Int, onBackToTop: () -> Unit) {
    Column(
        Modifier.fillMaxWidth().padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            "That's all $count recipes",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        CraveButton(
            "Back to top",
            onClick = onBackToTop,
            variant = CraveButtonVariant.Outline,
            icon = Icons.Outlined.ArrowUpward,
        )
    }
}

private fun LazyGridScope.fullWidthItem(key: String, content: @Composable () -> Unit) =
    item(key, span = { GridItemSpan(maxLineSpan) }) { content() }

/** Edge-to-edge horizontal chip row aligned to the gutter (it bleeds out of the grid's padding). */
@Composable
private fun ChipRow(content: LazyListScope.() -> Unit) {
    LazyRow(
        modifier = Modifier.bleed(CraveLayout.Gutter),
        contentPadding = PaddingValues(horizontal = CraveLayout.Gutter),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        // Top, not center: selected chips are 4dp taller (sticker shadow) and would jump.
        verticalAlignment = Alignment.Top,
        content = content,
    )
}

/** Widens the content by [horizontal] on each side, e.g. to scroll under a parent's padding. */
private fun Modifier.bleed(horizontal: Dp) = layout { measurable, constraints ->
    val extra = horizontal.roundToPx()
    val placeable = measurable.measure(
        constraints.copy(minWidth = constraints.minWidth + 2 * extra, maxWidth = constraints.maxWidth + 2 * extra),
    )
    layout(constraints.maxWidth, placeable.height) { placeable.place(-extra, 0) }
}

private val previewActions = BrowseActions({}, {}, {}, {}, {}, {}, {}, {}, {})

@CravePreviews
@Composable
private fun BrowseShelvesPreview() = CraveWiseTheme {
    val all = PreviewRecipes.summaries
    BrowseScreen(
        state = BrowseUiState(
            isLoading = false,
            results = all,
            mealTypes = listOf(MealType.Main, MealType.Dessert),
            cuisines = listOf("British", "Filipino", "Thai"),
            shelves = listOf(
                BrowseShelf("quick", "Ready in 30 minutes", 120, all, BrowseFilter(maxMinutes = 30)),
                BrowseShelf("meal-Main", "Mains", 412, all, BrowseFilter(mealType = MealType.Main)),
            ),
        ),
        actions = previewActions,
    )
}

@CravePreviews
@Composable
private fun BrowsePreview() = CraveWiseTheme {
    BrowseScreen(
        state = BrowseUiState(
            isLoading = false,
            filter = BrowseFilter(mealType = MealType.Main),
            results = PreviewRecipes.summaries.filter { MealType.Main in it.mealTypes },
            mealTypes = listOf(MealType.Main, MealType.Dessert),
            cuisines = listOf("British", "Filipino", "Thai"),
        ),
        actions = previewActions,
    )
}

@CravePreviews
@Composable
private fun BrowseEmptyPreview() = CraveWiseTheme {
    BrowseScreen(
        state = BrowseUiState(
            isLoading = false,
            filter = BrowseFilter(cuisine = "Thai", diets = setOf(Diet.Vegan)),
            mealTypes = listOf(MealType.Main),
            cuisines = listOf("Thai"),
        ),
        actions = previewActions,
    )
}

@CravePreviews
@Composable
private fun BrowseHiddenByProfilePreview() = CraveWiseTheme {
    BrowseScreen(
        state = BrowseUiState(
            isLoading = false,
            filter = BrowseFilter(mealType = MealType.Dessert),
            mealTypes = listOf(MealType.Main),
            cuisines = listOf("Thai"),
            hiddenByProfile = true,
        ),
        actions = previewActions,
    )
}
