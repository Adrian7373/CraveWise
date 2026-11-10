package com.example.cravewise.ui.recipe

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.RestaurantMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.cravewise.ui.components.PlaceholderContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailScreen(recipeId: String, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Recipe") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
            )
        },
    ) { padding ->
        PlaceholderContent(
            icon = Icons.Outlined.RestaurantMenu,
            title = "Recipe: $recipeId",
            description = "Ingredients (have / missing), steps and cook mode will live here. (Phase 2)",
            modifier = Modifier.padding(padding),
        )
    }
}
