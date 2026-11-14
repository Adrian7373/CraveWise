package com.example.cravewise.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ListAlt
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Kitchen
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.RestaurantMenu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfoV2
import androidx.compose.material3.adaptive.layout.calculatePaneScaffoldDirective
import androidx.compose.material3.adaptive.navigation3.ListDetailSceneStrategy
import androidx.compose.material3.adaptive.navigation3.rememberListDetailSceneStrategy
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItem
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.rememberNavigationSuiteScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.cravewise.data.seed.CatalogStatus
import com.example.cravewise.navigation.BrowseRoute
import com.example.cravewise.navigation.CookModeRoute
import com.example.cravewise.navigation.NavigationState
import com.example.cravewise.navigation.DecideQuizRoute
import com.example.cravewise.navigation.DesignCatalogRoute
import com.example.cravewise.navigation.FavoritesRoute
import com.example.cravewise.navigation.HomeRoute
import com.example.cravewise.navigation.Navigator
import com.example.cravewise.navigation.PantryRoute
import com.example.cravewise.navigation.ProfileRoute
import com.example.cravewise.navigation.RecipeDetailRoute
import com.example.cravewise.navigation.SearchRoute
import com.example.cravewise.navigation.ShoppingRoute
import com.example.cravewise.navigation.rememberNavigationState
import com.example.cravewise.ui.cook.CookModeScreen
import com.example.cravewise.ui.cookbook.BrowseScreen
import com.example.cravewise.ui.designsystem.CraveLayout
import com.example.cravewise.ui.designsystem.CravePreviews
import com.example.cravewise.ui.designsystem.ViaEmptyState
import com.example.cravewise.ui.theme.CraveWiseTheme
import com.example.cravewise.ui.cookbook.FavoritesScreen
import com.example.cravewise.ui.designsystem.DesignSystemCatalogScreen
import com.example.cravewise.ui.home.HomeScreen
import com.example.cravewise.ui.onboarding.OnboardingScreen
import com.example.cravewise.ui.pantry.PantryScreen
import com.example.cravewise.ui.profile.ProfileScreen
import com.example.cravewise.ui.quiz.DecideQuizScreen
import com.example.cravewise.ui.recipe.LocalRecipePhotos
import com.example.cravewise.ui.recipe.RecipeDetailScreen
import androidx.compose.runtime.CompositionLocalProvider
import com.example.cravewise.ui.search.SearchScreen
import com.example.cravewise.ui.shopping.ShoppingListScreen

private data class TopLevelDestination(val icon: ImageVector, val label: String)

private val TOP_LEVEL_DESTINATIONS: Map<NavKey, TopLevelDestination> = linkedMapOf(
    HomeRoute to TopLevelDestination(Icons.Outlined.Home, "Home"),
    PantryRoute to TopLevelDestination(Icons.Outlined.Kitchen, "My Kitchen"),
    SearchRoute to TopLevelDestination(Icons.Outlined.Search, "Search"),
    ShoppingRoute to TopLevelDestination(Icons.AutoMirrored.Outlined.ListAlt, "Shopping"),
    ProfileRoute to TopLevelDestination(Icons.Outlined.Person, "Profile"),
)

/** Shows onboarding on first run, then the tabbed app. A broken catalog replaces both. */
@Composable
fun CraveWiseAppRoot(appViewModel: AppViewModel = hiltViewModel()) {
    val onboardingComplete by appViewModel.onboardingComplete.collectAsStateWithLifecycle()
    val catalog by appViewModel.catalogStatus.collectAsStateWithLifecycle()
    val photos by appViewModel.recipePhotos.collectAsStateWithLifecycle()
    if (catalog is CatalogStatus.Failed) {
        CatalogErrorScreen(onRetry = appViewModel::retryCatalog)
        return
    }
    CompositionLocalProvider(LocalRecipePhotos provides photos) {
        when (onboardingComplete) {
            // Brief: DataStore answers almost at once. A plain canvas avoids flashing onboarding.
            null -> Box(Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background))
            false -> OnboardingScreen()
            true -> CraveWiseTabs(appViewModel)
        }
    }
}

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
private fun CraveWiseTabs(appViewModel: AppViewModel) {
    val shoppingCount by appViewModel.shoppingToBuyCount.collectAsStateWithLifecycle()
    val navigationState = rememberNavigationState(
        startRoute = HomeRoute,
        topLevelRoutes = TOP_LEVEL_DESTINATIONS.keys,
    )
    val navigator = remember(navigationState) { Navigator(navigationState) }
    val openProfile: () -> Unit = { navigator.navigate(ProfileRoute) }

    // Tablets / unfolded foldables: recipe lists sit beside the recipe they opened.
    val paneDirective = calculatePaneScaffoldDirective(currentWindowAdaptiveInfoV2())
    val twoPane = paneDirective.maxHorizontalPartitions > 1
    val listDetailStrategy = rememberListDetailSceneStrategy<NavKey>(directive = paneDirective)
    val listPane = ListDetailSceneStrategy.listPane(detailPlaceholder = { RecipePanePlaceholder() })
    val detailPane = ListDetailSceneStrategy.detailPane()

    // Cook mode is full-screen: hide the bar/rail while it's on top.
    val topKey = navigationState.backStacks[navigationState.topLevelRoute]?.lastOrNull()
    val isNavVisible = topKey !is CookModeRoute
    val navSuiteState = rememberNavigationSuiteScaffoldState()
    LaunchedEffect(isNavVisible) {
        if (isNavVisible) navSuiteState.show() else navSuiteState.hide()
    }

    val entryProvider = entryProvider<NavKey> {
        entry<HomeRoute> {
            HomeScreen(
                onCookWithWhatIHave = { navigator.navigate(PantryRoute) },
                onHelpMeDecide = { navigator.navigate(DecideQuizRoute) },
                onSmartSearch = { navigator.navigate(SearchRoute) },
                onRecipeClick = { id -> navigator.navigate(RecipeDetailRoute(id)) },
                onBrowse = { route -> navigator.navigate(route) },
                onOpenFavorites = { navigator.navigate(FavoritesRoute) },
                onOpenProfile = openProfile,
            )
        }
        entry<PantryRoute>(metadata = listPane) {
            PantryScreen(
                onRecipeClick = { id -> navigator.navigate(RecipeDetailRoute(id)) },
                onBrowse = { navigator.navigate(BrowseRoute()) },
                onOpenProfile = openProfile,
                onOpenShopping = { navigator.navigate(ShoppingRoute) },
            )
        }
        entry<SearchRoute>(metadata = listPane) {
            SearchScreen(
                onRecipeClick = { id -> navigator.navigate(RecipeDetailRoute(id)) },
                onBrowse = { navigator.navigate(BrowseRoute()) },
                onOpenProfile = openProfile,
                onOpenKitchen = { navigator.navigate(PantryRoute) },
            )
        }
        entry<ShoppingRoute> { ShoppingListScreen(onBrowse = { navigator.navigate(BrowseRoute()) }) }
        entry<ProfileRoute> {
            ProfileScreen(
                onOpenFavorites = { navigator.navigate(FavoritesRoute) },
                onOpenDesignSystem = { navigator.navigate(DesignCatalogRoute) },
            )
        }
        entry<BrowseRoute>(metadata = listPane) { key ->
            BrowseScreen(
                route = key,
                onBack = navigator::goBack,
                onRecipeClick = { id -> navigator.navigate(RecipeDetailRoute(id)) },
                onOpenProfile = openProfile,
            )
        }
        entry<FavoritesRoute>(metadata = listPane) {
            FavoritesScreen(
                onBack = navigator::goBack,
                onRecipeClick = { id -> navigator.navigate(RecipeDetailRoute(id)) },
                onBrowse = { navigator.navigate(BrowseRoute()) },
                onOpenProfile = openProfile,
            )
        }
        entry<DesignCatalogRoute> { DesignSystemCatalogScreen(onBack = navigator::goBack) }
        entry<DecideQuizRoute> {
            DecideQuizScreen(
                onBack = navigator::goBack,
                onRecipeClick = { id -> navigator.navigate(RecipeDetailRoute(id)) },
                onOpenProfile = openProfile,
            )
        }
        entry<RecipeDetailRoute>(metadata = detailPane) { key ->
            // Beside its list on a tablet, the detail pane needs no back arrow.
            val inPane = twoPane && navigationState.opensFromList(key)
            RecipeDetailScreen(
                recipeId = key.recipeId,
                onBack = navigator::goBack,
                onBrowseCuisine = { cuisine -> navigator.navigate(BrowseRoute(cuisine = cuisine)) },
                onStartCooking = { servings -> navigator.navigate(CookModeRoute(key.recipeId, servings)) },
                showBackButton = !inPane,
            )
        }
        entry<CookModeRoute> { key -> CookModeScreen(route = key, onExit = navigator::goBack) }
    }

    // Bottom bar on phones, rail on tablets and desktop windows.
    NavigationSuiteScaffold(
        state = navSuiteState,
        containerColor = MaterialTheme.colorScheme.background,
        navigationItems = {
            TOP_LEVEL_DESTINATIONS.forEach { (route, destination) ->
                val selected = route == navigationState.topLevelRoute
                NavigationSuiteItem(
                    selected = selected,
                    onClick = { navigator.navigate(route) },
                    icon = { Icon(destination.icon, contentDescription = null) },
                    // The saffron pill marks the tab; the label stays ink so it's readable on cream.
                    label = {
                        Text(
                            destination.label,
                            color = if (selected) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    },
                    badge = if (route == ShoppingRoute && shoppingCount > 0) {
                        { Badge { Text(if (shoppingCount > 99) "99+" else "$shoppingCount") } }
                    } else {
                        null
                    },
                )
            }
        },
    ) {
        NavDisplay(
            entries = navigationState.toDecoratedEntries(entryProvider),
            onBack = { navigator.goBack() },
            sceneStrategies = listOf(listDetailStrategy),
        )
    }
}

/** True when the entry under [key] is a recipe list, i.e. the two would share a list-detail scene. */
private fun NavigationState.opensFromList(key: NavKey): Boolean {
    val stack = backStacks.values.firstOrNull { key in it } ?: return false
    val previous = stack.getOrNull(stack.lastIndexOf(key) - 1)
    return previous is BrowseRoute || previous == FavoritesRoute || previous == SearchRoute || previous == PantryRoute
}

/** Detail pane before a recipe is picked. No Via here: the list beside it may already show one. */
@Composable
private fun RecipePanePlaceholder() {
    Column(
        Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            Icons.Outlined.RestaurantMenu,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(64.dp),
        )
        Text("Pick a recipe", style = MaterialTheme.typography.headlineSmall)
        Text(
            "Tap any dish in the list and it'll open right here.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
        )
    }
}

/** The bundled recipes couldn't be loaded (corrupt install, full disk). Nothing works without them. */
@Composable
private fun CatalogErrorScreen(onRetry: () -> Unit) {
    Box(
        Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).safeDrawingPadding(),
        contentAlignment = Alignment.Center,
    ) {
        ViaEmptyState(
            title = "The cookbook got stuck",
            body = "I couldn't open the recipe collection on this phone. Try again, and if it keeps happening, " +
                "free up some storage or reinstall CraveWise. Your kitchen and lists are safe.",
            actionLabel = "Try again",
            onAction = onRetry,
            modifier = Modifier.widthIn(max = CraveLayout.ReadableWidth),
        )
    }
}

@CravePreviews
@Composable
private fun CatalogErrorPreview() = CraveWiseTheme { CatalogErrorScreen(onRetry = {}) }

@CravePreviews
@Composable
private fun RecipePanePlaceholderPreview() = CraveWiseTheme { RecipePanePlaceholder() }
