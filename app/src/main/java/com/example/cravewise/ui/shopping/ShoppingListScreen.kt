package com.example.cravewise.ui.shopping

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ListAlt
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.cravewise.ui.components.PlaceholderContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListScreen() {
    Scaffold(topBar = { TopAppBar(title = { Text("Shopping List") }) }) { padding ->
        PlaceholderContent(
            icon = Icons.AutoMirrored.Outlined.ListAlt,
            title = "Your shopping list is empty",
            description = "Missing ingredients from recipes will show up here, grouped by aisle. (Phase 5)",
            modifier = Modifier.padding(padding),
        )
    }
}
