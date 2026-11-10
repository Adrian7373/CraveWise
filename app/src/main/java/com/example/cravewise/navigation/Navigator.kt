package com.example.cravewise.navigation

import androidx.navigation3.runtime.NavKey

/** Handles navigation events by mutating [NavigationState]. */
class Navigator(val state: NavigationState) {

    fun navigate(route: NavKey) {
        if (route in state.backStacks.keys) {
            state.topLevelRoute = route
        } else {
            state.backStacks[state.topLevelRoute]?.add(route)
        }
    }

    /** Switch to a tab and push [route] onto it, e.g. Home → "Cook with what I have" opens Pantry. */
    fun navigateInTab(tab: NavKey, route: NavKey) {
        state.topLevelRoute = tab
        state.backStacks[tab]?.add(route)
    }

    fun goBack() {
        val stack = state.backStacks[state.topLevelRoute]
            ?: error("Stack for ${state.topLevelRoute} not found")
        if (stack.last() == state.topLevelRoute) {
            state.topLevelRoute = state.startRoute
        } else {
            stack.removeLastOrNull()
        }
    }
}
