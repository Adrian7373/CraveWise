package com.example.cravewise.ui.cookbook

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cravewise.ui.designsystem.CravePreviews
import com.example.cravewise.ui.designsystem.ViaEmptyState
import com.example.cravewise.ui.recipe.PreviewRecipes
import com.example.cravewise.ui.recipe.RecipeSummaryCard
import com.example.cravewise.ui.theme.CraveWiseTheme

@Composable
fun FavoritesScreen(
    onBack: () -> Unit,
    onRecipeClick: (String) -> Unit,
    onBrowse: () -> Unit,
    onOpenProfile: () -> Unit,
    viewModel: FavoritesViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    FavoritesScreen(state, onBack, onRecipeClick, onBrowse, onOpenProfile)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen(
    state: FavoritesUiState,
    onBack: () -> Unit,
    onRecipeClick: (String) -> Unit,
    onBrowse: () -> Unit,
    onOpenProfile: () -> Unit,
) {
    val cs = MaterialTheme.colorScheme
    Scaffold(
        containerColor = cs.background,
        topBar = {
            TopAppBar(
                title = { Text("Favorites", style = MaterialTheme.typography.headlineSmall) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = cs.background),
            )
        },
    ) { padding ->
        when {
            state.isLoading -> Box(Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
            state.favorites.isEmpty() && state.hiddenByProfile -> Box(
                Modifier.fillMaxSize().padding(padding),
                contentAlignment = Alignment.Center,
            ) {
                ViaEmptyState(
                    title = "Hidden by your profile",
                    body = "Your saved recipes don't fit your current food profile, so I've tucked them away.",
                    actionLabel = "Review my profile",
                    onAction = onOpenProfile,
                )
            }
            state.favorites.isEmpty() -> Box(Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                ViaEmptyState(
                    title = "No favorites yet",
                    body = "Tap the heart on any recipe and I'll keep it warm for you here.",
                    actionLabel = "Browse recipes",
                    onAction = onBrowse,
                )
            }
            else -> LazyColumn(
                contentPadding = PaddingValues(
                    start = 20.dp,
                    end = 20.dp,
                    top = padding.calculateTopPadding() + 4.dp,
                    bottom = padding.calculateBottomPadding() + 24.dp,
                ),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize(),
            ) {
                items(state.favorites, key = { it.id }) { recipe ->
                    RecipeSummaryCard(recipe, onClick = { onRecipeClick(recipe.id) })
                }
            }
        }
    }
}

@CravePreviews
@Composable
private fun FavoritesPreview() = CraveWiseTheme {
    FavoritesScreen(FavoritesUiState(isLoading = false, favorites = PreviewRecipes.summaries), {}, {}, {}, {})
}

@CravePreviews
@Composable
private fun FavoritesEmptyPreview() = CraveWiseTheme {
    FavoritesScreen(FavoritesUiState(isLoading = false), {}, {}, {}, {})
}

@CravePreviews
@Composable
private fun FavoritesHiddenPreview() = CraveWiseTheme {
    FavoritesScreen(FavoritesUiState(isLoading = false, hiddenByProfile = true), {}, {}, {}, {})
}
