package com.example.cravewise.ui.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material.icons.outlined.BreakfastDining
import androidx.compose.material.icons.outlined.Cake
import androidx.compose.material.icons.outlined.Cookie
import androidx.compose.material.icons.outlined.DinnerDining
import androidx.compose.material.icons.outlined.Kitchen
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material.icons.outlined.Quiz
import androidx.compose.material.icons.outlined.RiceBowl
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Tapas
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.navigation.BrowseRoute
import com.example.cravewise.ui.designsystem.CraveButton
import com.example.cravewise.ui.designsystem.CraveButtonVariant
import com.example.cravewise.ui.designsystem.CraveChip
import com.example.cravewise.ui.designsystem.CravePreviews
import com.example.cravewise.ui.designsystem.readableWidth
import com.example.cravewise.ui.designsystem.CraveSurface
import com.example.cravewise.ui.designsystem.SectionHeader
import com.example.cravewise.ui.designsystem.ViaHero
import com.example.cravewise.ui.theme.CraveTheme
import com.example.cravewise.ui.recipe.PreviewRecipes
import com.example.cravewise.ui.recipe.RecipeSummaryCard
import com.example.cravewise.ui.theme.CraveWiseTheme
import com.example.cravewise.data.photos.RecipePhotosState
import com.example.cravewise.ui.photos.RecipePhotosViewModel

@Composable
fun HomeScreen(
    onCookWithWhatIHave: () -> Unit,
    onHelpMeDecide: () -> Unit,
    onSmartSearch: () -> Unit,
    onRecipeClick: (String) -> Unit,
    onBrowse: (BrowseRoute) -> Unit,
    onOpenFavorites: () -> Unit,
    onOpenProfile: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
    photosViewModel: RecipePhotosViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val photos by photosViewModel.state.collectAsStateWithLifecycle()
    HomeScreen(
        state = state,
        photos = photos,
        onDownloadPhotos = photosViewModel::download,
        onDismissPhotos = photosViewModel::dismissPrompt,
        onCookWithWhatIHave = onCookWithWhatIHave,
        onHelpMeDecide = onHelpMeDecide,
        onSmartSearch = onSmartSearch,
        onRecipeClick = onRecipeClick,
        onBrowse = onBrowse,
        onOpenFavorites = onOpenFavorites,
        onOpenProfile = onOpenProfile,
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(
    state: HomeUiState,
    onCookWithWhatIHave: () -> Unit,
    onHelpMeDecide: () -> Unit,
    onSmartSearch: () -> Unit,
    onRecipeClick: (String) -> Unit,
    onBrowse: (BrowseRoute) -> Unit,
    onOpenFavorites: () -> Unit,
    onOpenProfile: () -> Unit,
    photos: RecipePhotosState = RecipePhotosState(promptDismissed = true),
    onDownloadPhotos: () -> Unit = {},
    onDismissPhotos: () -> Unit = {},
) {
    val cs = MaterialTheme.colorScheme
    val gutter = Modifier.padding(horizontal = 20.dp)
    Scaffold(
        containerColor = cs.background,
        topBar = {
            TopAppBar(
                title = { Text("CraveWise", style = MaterialTheme.typography.headlineSmall) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = cs.background),
            )
        },
    ) { padding ->
        // No horizontal content padding so the favorites strip can scroll edge to edge;
        // every other item applies the 20dp gutter itself.
        LazyColumn(
            contentPadding = PaddingValues(
                top = padding.calculateTopPadding() + 8.dp,
                bottom = padding.calculateBottomPadding() + 24.dp,
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.readableWidth(),
        ) {
            // Via's hero is the one Via on Home: the spice nudge and the one-time photo ask take
            // over its bubble instead of stacking a second Via.
            item("via") {
                HomeHero(
                    state = state,
                    photos = photos,
                    onOpenProfile = onOpenProfile,
                    onDownloadPhotos = onDownloadPhotos,
                    onDismissPhotos = onDismissPhotos,
                    modifier = gutter,
                )
            }
            item("question") {
                Text(
                    "What are we cooking today?",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = gutter.padding(top = 16.dp),
                )
            }
            item("pantry") {
                // The main action keeps the tomato fill; the other two stay quiet so the hero leads.
                FeatureCard(
                    icon = Icons.Outlined.Kitchen,
                    title = "Cook with what I have",
                    subtitle = "Enter your ingredients and see what you can make",
                    container = cs.primary,
                    content = cs.onPrimary,
                    badge = cs.onPrimary.copy(alpha = 0.16f),
                    onClick = onCookWithWhatIHave,
                    modifier = gutter,
                )
            }
            item("decide") {
                FeatureCard(
                    icon = Icons.Outlined.Quiz,
                    title = "Help me decide",
                    subtitle = "Answer a few quick questions and get picks",
                    container = CraveTheme.extras.cardColor,
                    content = cs.onSurface,
                    badge = cs.secondaryContainer,
                    onBadge = cs.onSecondaryContainer,
                    onClick = onHelpMeDecide,
                    modifier = gutter,
                )
            }
            item("search") {
                FeatureCard(
                    icon = Icons.Outlined.Search,
                    title = "Smart search",
                    subtitle = "Try \"something salty\" or \"quick spicy dinner\"",
                    container = CraveTheme.extras.cardColor,
                    content = cs.onSurface,
                    badge = cs.tertiaryContainer,
                    onBadge = cs.onTertiaryContainer,
                    onClick = onSmartSearch,
                    modifier = gutter,
                )
            }

            if (state.favorites.isNotEmpty()) {
                item("favorites-header") {
                    SectionHeader(
                        "Your favorites",
                        actionLabel = "See all",
                        onAction = onOpenFavorites,
                        modifier = gutter.padding(top = 16.dp),
                    )
                }
                item("favorites") {
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        items(state.favorites, key = { it.id }) { recipe ->
                            RecipeSummaryCard(
                                recipe,
                                onClick = { onRecipeClick(recipe.id) },
                                modifier = Modifier.width(260.dp),
                                titleMinLines = 2,
                            )
                        }
                    }
                }
            }

            if (state.mealTypes.isNotEmpty()) {
                item("meals-header") {
                    SectionHeader(
                        "Browse by meal",
                        eyebrow = "Cookbook",
                        actionLabel = "See all",
                        onAction = { onBrowse(BrowseRoute()) },
                        modifier = gutter.padding(top = 16.dp),
                    )
                }
                item("meals") {
                    FlowRow(
                        modifier = gutter,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        state.mealTypes.forEach { type ->
                            CraveChip(
                                type.label,
                                selected = false,
                                onClick = { onBrowse(BrowseRoute(mealType = type)) },
                                leading = { Icon(type.icon, contentDescription = null, modifier = Modifier.size(18.dp)) },
                            )
                        }
                    }
                }
            }

            if (state.cuisines.isNotEmpty()) {
                item("cuisines-header") { SectionHeader("Cuisines", modifier = gutter.padding(top = 8.dp)) }
                item("cuisines") {
                    FlowRow(
                        modifier = gutter,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        state.cuisines.forEach { cuisine ->
                            CraveChip(cuisine, selected = false, onClick = { onBrowse(BrowseRoute(cuisine = cuisine)) })
                        }
                    }
                }
            }

            if (state.featured.isNotEmpty()) {
                item("quick-header") { SectionHeader("Quick picks", modifier = gutter.padding(top = 16.dp)) }
            }
            items(state.featured, key = { "quick-${it.id}" }) { recipe ->
                RecipeSummaryCard(recipe, onClick = { onRecipeClick(recipe.id) }, modifier = gutter)
            }
        }
    }
}

private val MealType.icon: ImageVector
    get() = when (this) {
        MealType.Breakfast -> Icons.Outlined.BreakfastDining
        MealType.Main -> Icons.Outlined.DinnerDining
        MealType.Side -> Icons.Outlined.RiceBowl
        MealType.Starter -> Icons.Outlined.Tapas
        MealType.Dessert -> Icons.Outlined.Cake
        MealType.Snack -> Icons.Outlined.Cookie
    }

/**
 * Home's hero: Via greets, then says the most useful thing right now. Priority: the spice nudge
 * (until set), the one-time photo ask, else a daily tip the user can flip through.
 */
@Composable
private fun HomeHero(
    state: HomeUiState,
    photos: RecipePhotosState,
    onOpenProfile: () -> Unit,
    onDownloadPhotos: () -> Unit,
    onDismissPhotos: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val headline = remember { greeting() }
    var tip by rememberSaveable { mutableIntStateOf(tipOfTheDay()) }
    val bubbleText = MaterialTheme.typography.bodyMedium
    // Ink on saffron: tomato links would be too low-contrast on the hero.
    val onHeroText = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.onSecondaryContainer)
    when {
        state.askSpice -> ViaHero(
            headline = headline,
            modifier = modifier,
            actions = {
                CraveButton("Set spice level", onClick = onOpenProfile, variant = CraveButtonVariant.Outline)
            },
        ) {
            Text("How brave is your tongue? Tell me your heat limit and I'll keep every pick just right.", style = bubbleText)
        }
        photos.shouldPrompt -> ViaHero(
            headline = headline,
            modifier = modifier,
            actions = {
                CraveButton(
                    "Get photos",
                    onClick = onDownloadPhotos,
                    variant = CraveButtonVariant.Outline,
                    icon = Icons.Outlined.Download,
                )
                TextButton(onClick = onDismissPhotos, colors = onHeroText) {
                    Text("Not now", style = MaterialTheme.typography.labelLarge)
                }
            },
        ) {
            Text(
                "Want real dish photos instead of my doodles? About ${photos.estimatedMegabytes} MB once, on Wi-Fi.",
                style = bubbleText,
            )
        }
        else -> ViaHero(
            headline = headline,
            modifier = modifier,
            actions = {
                TextButton(onClick = { tip = (tip + 1) % HOME_TIPS.size }, colors = onHeroText) {
                    Icon(Icons.Outlined.Refresh, contentDescription = null, modifier = Modifier.size(18.dp))
                    Spacer(Modifier.width(6.dp))
                    Text("Another tip", style = MaterialTheme.typography.labelLarge)
                }
            },
        ) {
            AnimatedContent(targetState = tip, transitionSpec = { fadeIn() togetherWith fadeOut() }, label = "tip") { i ->
                Text(HOME_TIPS[i], style = bubbleText)
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
    badge: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    onBadge: Color = content,
) {
    CraveSurface(
        onClick = onClick,
        color = container,
        contentColor = content,
        modifier = modifier.fillMaxWidth(),
    ) {
        Row(Modifier.padding(20.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(
                Modifier.size(48.dp).clip(CircleShape).background(badge),
                contentAlignment = Alignment.Center,
            ) {
                Icon(icon, contentDescription = null, tint = onBadge, modifier = Modifier.size(26.dp))
            }
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
    HomeScreen(
        state = HomeUiState(
            isLoading = false,
            featured = PreviewRecipes.summaries,
            favorites = listOf(PreviewRecipes.etonMess, PreviewRecipes.bistek),
            mealTypes = listOf(MealType.Breakfast, MealType.Main, MealType.Dessert, MealType.Snack),
            cuisines = listOf("British", "Filipino", "Italian", "Japanese", "Thai"),
        ),
        onCookWithWhatIHave = {}, onHelpMeDecide = {}, onSmartSearch = {}, onRecipeClick = {},
        onBrowse = {}, onOpenFavorites = {}, onOpenProfile = {},
    )
}

@CravePreviews
@Composable
private fun HomePhotoPromptPreview() = CraveWiseTheme {
    HomeScreen(
        state = HomeUiState(isLoading = false, featured = PreviewRecipes.summaries),
        onCookWithWhatIHave = {}, onHelpMeDecide = {}, onSmartSearch = {}, onRecipeClick = {},
        onBrowse = {}, onOpenFavorites = {}, onOpenProfile = {},
        photos = RecipePhotosState(total = 789),
    )
}

@CravePreviews
@Composable
private fun HomeAskSpicePreview() = CraveWiseTheme {
    HomeScreen(
        state = HomeUiState(isLoading = false, featured = PreviewRecipes.summaries, askSpice = true),
        onCookWithWhatIHave = {}, onHelpMeDecide = {}, onSmartSearch = {}, onRecipeClick = {},
        onBrowse = {}, onOpenFavorites = {}, onOpenProfile = {},
    )
}
