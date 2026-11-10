package com.example.cravewise.ui.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cravewise.ui.components.PlaceholderContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(onOpenDesignSystem: () -> Unit) {
    Scaffold(topBar = { TopAppBar(title = { Text("Profile") }) }) { padding ->
        Box(Modifier.padding(padding)) {
            PlaceholderContent(
                icon = Icons.Outlined.Person,
                title = "Your food profile",
                description = "Allergies, hated ingredients, spice tolerance and diet preferences. (Phase 4)",
            )
            // Temporary entry point while the design direction is being chosen.
            OutlinedButton(
                onClick = onOpenDesignSystem,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(24.dp),
            ) {
                Icon(Icons.Outlined.Palette, contentDescription = null)
                Text("Design system catalog", Modifier.padding(start = 8.dp))
            }
        }
    }
}
