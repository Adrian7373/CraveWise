package com.example.cravewise.ui.recipe

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import java.io.File

/**
 * Which recipes have a downloaded photo, and where it is. Provided once at the app root (from
 * `PhotoStore`) so every card and the detail hero can show a photo without each ViewModel knowing
 * about photos. Recipes without one keep the placeholder [com.example.cravewise.ui.designsystem.RecipeArt].
 */
@Immutable
class RecipePhotoLookup(private val ids: Set<String>, private val fileFor: (String) -> File) {
    fun photoFor(recipeId: String): File? = if (recipeId in ids) fileFor(recipeId) else null

    companion object {
        val None = RecipePhotoLookup(emptySet()) { File("") }
    }
}

val LocalRecipePhotos = compositionLocalOf { RecipePhotoLookup.None }
