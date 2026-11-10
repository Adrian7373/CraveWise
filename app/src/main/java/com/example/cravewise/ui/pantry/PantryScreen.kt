package com.example.cravewise.ui.pantry

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Kitchen
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.cravewise.ui.components.PlaceholderContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantryScreen() {
    Scaffold(topBar = { TopAppBar(title = { Text("My Kitchen") }) }) { padding ->
        PlaceholderContent(
            icon = Icons.Outlined.Kitchen,
            title = "What's in your kitchen?",
            description = "Add your ingredients and we'll show what you can cook right now. (Phase 3)",
            modifier = Modifier.padding(padding),
        )
    }
}
