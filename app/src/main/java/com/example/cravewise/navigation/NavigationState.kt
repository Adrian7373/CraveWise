package com.example.cravewise.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberDecoratedNavEntries
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator

/**
 * Navigation state with one back stack per bottom-nav tab. Survives config changes and process death.
 * Follows the "exit through home" pattern: the start tab's entries are always at the bottom.
 */
@Composable
fun rememberNavigationState(
    startRoute: NavKey,
    topLevelRoutes: Set<NavKey>,
): NavigationState {
    val topLevelIndex = rememberSaveable { mutableStateOf(topLevelRoutes.indexOf(startRoute)) }
    val backStacks = topLevelRoutes.associateWith { key -> rememberNavBackStack(key) }

    return remember(startRoute, topLevelRoutes) {
        NavigationState(
            startRoute = startRoute,
            topLevelRoutes = topLevelRoutes.toList(),
            topLevelIndex = topLevelIndex,
            backStacks = backStacks,
        )
    }
}

class NavigationState(
    val startRoute: NavKey,
    private val topLevelRoutes: List<NavKey>,
    topLevelIndex: MutableState<Int>,
    val backStacks: Map<NavKey, NavBackStack<NavKey>>,
) {
    private var topLevelIndex: Int by topLevelIndex

    var topLevelRoute: NavKey
        get() = topLevelRoutes[topLevelIndex]
        set(value) {
            topLevelIndex = topLevelRoutes.indexOf(value)
        }

    @Composable
    fun toDecoratedEntries(
        entryProvider: (NavKey) -> NavEntry<NavKey>,
    ): List<NavEntry<NavKey>> {
        val decoratedEntries = backStacks.mapValues { (_, stack) ->
            val decorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator<NavKey>(),
                rememberViewModelStoreNavEntryDecorator<NavKey>(),
            )
            rememberDecoratedNavEntries(
                backStack = stack,
                entryDecorators = decorators,
                entryProvider = entryProvider,
            )
        }
        val inUse = if (topLevelRoute == startRoute) listOf(startRoute) else listOf(startRoute, topLevelRoute)
        return inUse.flatMap { decoratedEntries[it].orEmpty() }
    }
}
