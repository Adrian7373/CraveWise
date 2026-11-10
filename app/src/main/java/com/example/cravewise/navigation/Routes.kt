package com.example.cravewise.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

// ---- Top-level tabs ----
@Serializable data object HomeRoute : NavKey
@Serializable data object PantryRoute : NavKey
@Serializable data object SearchRoute : NavKey
@Serializable data object ShoppingRoute : NavKey
@Serializable data object ProfileRoute : NavKey

// ---- Sub-routes (pushed onto the current tab's back stack) ----
@Serializable data class RecipeDetailRoute(val recipeId: String) : NavKey
@Serializable data object DecideQuizRoute : NavKey
@Serializable data object DesignCatalogRoute : NavKey
