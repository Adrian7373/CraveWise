package com.example.cravewise.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Kitchen
import androidx.compose.material.icons.outlined.Quiz
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cravewise.domain.model.Difficulty
import com.example.cravewise.domain.model.FlavorScores
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.model.Protein
import com.example.cravewise.domain.model.RecipeSummary
import com.example.cravewise.ui.designsystem.CravePreviews
import com.example.cravewise.ui.designsystem.CraveSurface
import com.example.cravewise.ui.designsystem.RecipeCard
import com.example.cravewise.ui.designsystem.SectionHeader
import com.example.cravewise.ui.designsystem.ViaSays
import com.example.cravewise.ui.recipe.artIcon
import com.example.cravewise.ui.recipe.dominant
import com.example.cravewise.ui.theme.CraveTheme
import com.example.cravewise.ui.theme.CraveWiseTheme

@Composable
fun HomeScreen(
    onCookWithWhatIHave: () -> Unit,
    onHelpMeDecide: () -> Unit,
    onSmartSearch: () -> Unit,
    onRecipeClick: (String) -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    HomeScreen(
        featured = state.featured,
        onCookWithWhatIHave = onCookWithWhatIHave,
        onHelpMeDecide = onHelpMeDecide,
        onSmartSearch = onSmartSearch,
        onRecipeClick = onRecipeClick,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    featured: List<RecipeSummary>,
    onCookWithWhatIHave: () -> Unit,
    onHelpMeDecide: () -> Unit,
    onSmartSearch: () -> Unit,
    onRecipeClick: (String) -> Unit,
) {
    val cs = MaterialTheme.colorScheme
    Scaffold(
        containerColor = cs.background,
        topBar = {
            TopAppBar(
                title = { Text("CraveWise", style = MaterialTheme.typography.headlineSmall) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = cs.background),
            )
        },
    ) { padding ->
        LazyColumn(
            contentPadding = PaddingValues(
                start = 20.dp,
                end = 20.dp,
                top = padding.calculateTopPadding() + 8.dp,
                bottom = padding.calculateBottomPadding() + 24.dp,
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            item { ViaSays("Hungry?! Tell me what's in your kitchen and I'll find something slurp-worthy.") }
            item {
                Text(
                    "What are we cooking today?",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(top = 8.dp),
                )
            }
            item {
                FeatureCard(
                    icon = Icons.Outlined.Kitchen,
                    title = "Cook with what I have",
                    subtitle = "Enter your ingredients and see what you can make",
                    container = cs.primary,
                    content = cs.onPrimary,
                    onClick = onCookWithWhatIHave,
                )
            }
            item {
                FeatureCard(
                    icon = Icons.Outlined.Quiz,
                    title = "Help me decide",
                    subtitle = "Answer a few quick questions and get picks",
                    container = cs.secondaryContainer,
                    content = cs.onSecondaryContainer,
                    onClick = onHelpMeDecide,
                )
            }
            item {
                FeatureCard(
                    icon = Icons.Outlined.Search,
                    title = "Smart search",
                    subtitle = "Try \"something salty\" or \"quick spicy dinner\"",
                    container = cs.tertiaryContainer,
                    content = cs.onTertiaryContainer,
                    onClick = onSmartSearch,
                )
            }
            if (featured.isNotEmpty()) {
                item { SectionHeader("Quick picks", modifier = Modifier.padding(top = 8.dp)) }
            }
            items(featured, key = { it.id }) { recipe ->
                RecipeCard(
                    title = recipe.title,
                    cuisine = recipe.cuisine,
                    minutes = recipe.totalMinutes,
                    difficulty = recipe.difficulty.label,
                    spiceLevel = recipe.spiceLevel,
                    art = recipe.artIcon,
                    accent = CraveTheme.extras.flavor[recipe.flavor.dominant],
                    onClick = { onRecipeClick(recipe.id) },
                )
            }
        }
    }
}

@Composable
private fun FeatureCard(
    icon: ImageVector,
    title: String,
    subtitle: String,
    container: Color,
    content: Color,
    onClick: () -> Unit,
) {
    CraveSurface(
        onClick = onClick,
        color = container,
        contentColor = content,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(Modifier.padding(20.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = null, modifier = Modifier.size(32.dp))
            Spacer(Modifier.width(16.dp))
            Column(Modifier.weight(1f)) {
                Text(title, style = MaterialTheme.typography.titleMedium)
                Text(subtitle, style = MaterialTheme.typography.bodyMedium)
            }
            Icon(Icons.AutoMirrored.Outlined.ArrowForward, contentDescription = null)
        }
    }
}

@CravePreviews
@Composable
private fun HomeScreenPreview() = CraveWiseTheme {
    HomeScreen(featured = previewRecipes, onCookWithWhatIHave = {}, onHelpMeDecide = {}, onSmartSearch = {}, onRecipeClick = {})
}

private val previewRecipes = listOf(
    RecipeSummary(
        id = "mdb-1", title = "Bistek", cuisine = "Filipino", totalMinutes = 35, difficulty = Difficulty.Easy,
        flavor = FlavorScores(salty = 4, sweet = 1, sour = 3, bitter = 0, umami = 4, spicy = 0),
        mealTypes = setOf(MealType.Main), proteins = setOf(Protein.Beef),
    ),
    RecipeSummary(
        id = "mdb-2", title = "Thai beef stir-fry", cuisine = "Thai", totalMinutes = 20, difficulty = Difficulty.Easy,
        flavor = FlavorScores(salty = 3, sweet = 2, sour = 1, bitter = 0, umami = 3, spicy = 4),
        mealTypes = setOf(MealType.Main), proteins = setOf(Protein.Beef),
    ),
)
