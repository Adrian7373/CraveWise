package com.example.cravewise.ui.cookbook

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cravewise.domain.BrowseFilter
import com.example.cravewise.domain.model.Diet
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.navigation.BrowseRoute
import com.example.cravewise.ui.designsystem.CraveChip
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
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BrowseScreen(state: BrowseUiState, actions: BrowseActions) {
    val cs = MaterialTheme.colorScheme
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
        LazyColumn(
            contentPadding = PaddingValues(
                top = padding.calculateTopPadding() + 4.dp,
                bottom = padding.calculateBottomPadding() + 24.dp,
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize(),
        ) {
            item("meal-types") {
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
            item("cuisines") {
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
            item("diets") {
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
            item("count") {
                Row(
                    Modifier.fillMaxWidth().padding(start = 20.dp, end = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    val n = state.results.size
                    Text(
                        if (n == 1) "1 recipe" else "$n recipes",
                        style = MaterialTheme.typography.labelLarge,
                        color = cs.onSurfaceVariant,
                        modifier = Modifier.weight(1f),
                    )
                    if (!filter.isEmpty) {
                        TextButton(onClick = actions.onClearFilters) {
                            Text("Clear filters", style = MaterialTheme.typography.labelLarge)
                        }
                    }
                }
            }
            if (state.results.isEmpty()) {
                item("empty") {
                    ViaEmptyState(
                        title = "Nothing on this menu",
                        body = "No recipes tick every box yet. Loosen a filter and I'll dig through the cookbook again.",
                        actionLabel = "Clear filters",
                        onAction = actions.onClearFilters,
                    )
                }
            }
            items(state.results, key = { it.id }) { recipe ->
                RecipeSummaryCard(
                    recipe,
                    onClick = { actions.onRecipeClick(recipe.id) },
                    modifier = Modifier.padding(horizontal = 20.dp),
                )
            }
        }
    }
}

/** Edge-to-edge horizontal chip row aligned to the 20dp gutter. */
@Composable
private fun ChipRow(content: LazyListScope.() -> Unit) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        // Top, not center: selected chips are 4dp taller (sticker shadow) and would jump.
        verticalAlignment = Alignment.Top,
        content = content,
    )
}

private val previewActions = BrowseActions({}, {}, {}, {}, {}, {}, {})

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
