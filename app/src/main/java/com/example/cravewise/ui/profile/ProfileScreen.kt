package com.example.cravewise.ui.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cravewise.ui.components.PlaceholderContent
import com.example.cravewise.ui.designsystem.CraveButton
import com.example.cravewise.ui.designsystem.CraveButtonVariant
import com.example.cravewise.ui.designsystem.CravePreviews
import com.example.cravewise.ui.theme.CraveWiseTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(onOpenFavorites: () -> Unit, onOpenDesignSystem: () -> Unit) {
    val cs = MaterialTheme.colorScheme
    Scaffold(
        containerColor = cs.background,
        topBar = {
            TopAppBar(
                title = { Text("Profile", style = MaterialTheme.typography.headlineSmall) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = cs.background),
            )
        },
    ) { padding ->
        Box(Modifier.padding(padding)) {
            PlaceholderContent(
                icon = Icons.Outlined.Person,
                title = "Your food profile",
                description = "Allergies, hated ingredients, spice tolerance and diet preferences. (Phase 4)",
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                CraveButton(
                    "Favorites",
                    onClick = onOpenFavorites,
                    variant = CraveButtonVariant.Secondary,
                    icon = Icons.Outlined.FavoriteBorder,
                    modifier = Modifier.fillMaxWidth(),
                )
                // Temporary entry point while the design direction is being chosen.
                CraveButton(
                    "Design system catalog",
                    onClick = onOpenDesignSystem,
                    variant = CraveButtonVariant.Outline,
                    icon = Icons.Outlined.Palette,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
    }
}

@CravePreviews
@Composable
private fun ProfileScreenPreview() = CraveWiseTheme { ProfileScreen(onOpenFavorites = {}, onOpenDesignSystem = {}) }
