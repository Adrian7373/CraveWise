package com.example.cravewise.ui

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ListAlt
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Kitchen
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.cravewise.navigation.DecideQuizRoute
import com.example.cravewise.navigation.DesignCatalogRoute
import com.example.cravewise.navigation.HomeRoute
import com.example.cravewise.navigation.Navigator
import com.example.cravewise.navigation.PantryRoute
import com.example.cravewise.navigation.ProfileRoute
import com.example.cravewise.navigation.RecipeDetailRoute
import com.example.cravewise.navigation.SearchRoute
import com.example.cravewise.navigation.ShoppingRoute
import com.example.cravewise.navigation.rememberNavigationState
import com.example.cravewise.ui.designsystem.DesignSystemCatalogScreen
import com.example.cravewise.ui.home.HomeScreen
import com.example.cravewise.ui.pantry.PantryScreen
import com.example.cravewise.ui.profile.ProfileScreen
import com.example.cravewise.ui.quiz.DecideQuizScreen
import com.example.cravewise.ui.recipe.RecipeDetailScreen
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

@Composable
fun CraveWiseAppRoot() {
    val navigationState = rememberNavigationState(
        startRoute = HomeRoute,
        topLevelRoutes = TOP_LEVEL_DESTINATIONS.keys,
    )
    val navigator = remember(navigationState) { Navigator(navigationState) }

    val entryProvider = entryProvider<NavKey> {
        entry<HomeRoute> {
            HomeScreen(
                onCookWithWhatIHave = { navigator.navigate(PantryRoute) },
                onHelpMeDecide = { navigator.navigate(DecideQuizRoute) },
                onSmartSearch = { navigator.navigate(SearchRoute) },
                onRecipeClick = { id -> navigator.navigate(RecipeDetailRoute(id)) },
            )
        }
        entry<PantryRoute> { PantryScreen() }
        entry<SearchRoute> { SearchScreen() }
        entry<ShoppingRoute> { ShoppingListScreen() }
        entry<ProfileRoute> {
            ProfileScreen(onOpenDesignSystem = { navigator.navigate(DesignCatalogRoute) })
        }
        entry<DesignCatalogRoute> { DesignSystemCatalogScreen(onBack = navigator::goBack) }
        entry<DecideQuizRoute> { DecideQuizScreen(onBack = navigator::goBack) }
        entry<RecipeDetailRoute> { key ->
            RecipeDetailScreen(recipeId = key.recipeId, onBack = navigator::goBack)
        }
    }

    Scaffold(
        contentWindowInsets = WindowInsets(0.dp),
        bottomBar = {
            NavigationBar {
                TOP_LEVEL_DESTINATIONS.forEach { (route, destination) ->
                    NavigationBarItem(
                        selected = route == navigationState.topLevelRoute,
                        onClick = { navigator.navigate(route) },
                        icon = { Icon(destination.icon, contentDescription = null) },
                        label = { Text(destination.label) },
                    )
                }
            }
        },
    ) { innerPadding ->
        NavDisplay(
            entries = navigationState.toDecoratedEntries(entryProvider),
            onBack = { navigator.goBack() },
            modifier = Modifier
                .padding(innerPadding)
                .consumeWindowInsets(innerPadding),
        )
    }
}
