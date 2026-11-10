package com.example.cravewise.ui.search

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.cravewise.ui.components.PlaceholderContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen() {
    Scaffold(topBar = { TopAppBar(title = { Text("Search") }) }) { padding ->
        PlaceholderContent(
            icon = Icons.Outlined.Search,
            title = "Smart search",
            description = "Search by craving, like \"something salty\" or \"creamy and quick\". (Phase 6)",
            modifier = Modifier.padding(padding),
        )
    }
}
