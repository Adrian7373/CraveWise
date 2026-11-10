package com.example.cravewise.navigation

import androidx.navigation3.runtime.NavKey
import com.example.cravewise.domain.model.MealType
import kotlinx.serialization.Serializable

// ---- Top-level tabs ----
@Serializable data object HomeRoute : NavKey
@Serializable data object PantryRoute : NavKey
@Serializable data object SearchRoute : NavKey
@Serializable data object ShoppingRoute : NavKey
@Serializable data object ProfileRoute : NavKey

// ---- Sub-routes (pushed onto the current tab's back stack) ----
@Serializable data class RecipeDetailRoute(val recipeId: String) : NavKey

/** Cookbook browse. A set [mealType] or [cuisine] makes it a category screen (initial filter). */
@Serializable data class BrowseRoute(val mealType: MealType? = null, val cuisine: String? = null) : NavKey
@Serializable data object FavoritesRoute : NavKey
@Serializable data object DecideQuizRoute : NavKey
@Serializable data object DesignCatalogRoute : NavKey
