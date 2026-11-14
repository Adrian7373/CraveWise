package com.example.cravewise.ui.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cravewise.domain.model.Allergen
import com.example.cravewise.domain.model.Diet
import com.example.cravewise.domain.model.FoodProfile
import com.example.cravewise.ui.designsystem.CraveButton
import com.example.cravewise.ui.designsystem.CraveButtonVariant
import com.example.cravewise.ui.designsystem.CravePreviews
import com.example.cravewise.ui.designsystem.readableWidth
import com.example.cravewise.ui.designsystem.SectionHeader
import com.example.cravewise.BuildConfig
import com.example.cravewise.ui.designsystem.CraveSurface
import com.example.cravewise.ui.designsystem.ViaMascot
import com.example.cravewise.ui.theme.CraveWiseTheme
import com.example.cravewise.data.photos.RecipePhotosState
import com.example.cravewise.ui.photos.RecipePhotosActions
import com.example.cravewise.ui.photos.RecipePhotosPanel
import com.example.cravewise.ui.photos.RecipePhotosViewModel
import com.example.cravewise.ui.photos.eyebrowText

@Composable
fun ProfileScreen(
    onOpenFavorites: () -> Unit,
    onOpenDesignSystem: () -> Unit,
    viewModel: ProfileViewModel = hiltViewModel(),
    photosViewModel: RecipePhotosViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val photos by photosViewModel.state.collectAsStateWithLifecycle()
    ProfileScreen(
        state = state,
        photos = photos,
        photoActions = RecipePhotosActions(
            onDownload = photosViewModel::download,
            onCancel = photosViewModel::cancel,
            onRemove = photosViewModel::removeAll,
            onAllowMobileData = photosViewModel::setAllowMobileData,
        ),
        actions = ProfileActions(
            onToggleAllergen = viewModel::toggleAllergen,
            onToggleDiet = viewModel::toggleDiet,
            onQueryChange = viewModel::onQueryChange,
            onSubmitQuery = viewModel::submitQuery,
            onAddHated = viewModel::addHated,
            onRemoveHated = viewModel::removeHated,
            onSetMaxSpice = viewModel::setMaxSpice,
            onOpenFavorites = onOpenFavorites,
            onOpenDesignSystem = onOpenDesignSystem,
        ),
    )
}

class ProfileActions(
    val onToggleAllergen: (Allergen) -> Unit,
    val onToggleDiet: (Diet) -> Unit,
    val onQueryChange: (String) -> Unit,
    val onSubmitQuery: () -> Unit,
    val onAddHated: (String) -> Unit,
    val onRemoveHated: (String) -> Unit,
    val onSetMaxSpice: (Int) -> Unit,
    val onOpenFavorites: () -> Unit,
    val onOpenDesignSystem: () -> Unit,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    state: ProfileUiState,
    actions: ProfileActions,
    photos: RecipePhotosState = RecipePhotosState(),
    photoActions: RecipePhotosActions = RecipePhotosActions({}, {}, {}, {}),
    showDesignCatalog: Boolean = BuildConfig.DEBUG,
    appVersion: String = BuildConfig.VERSION_NAME,
) {
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
        if (state.isLoading) {
            Box(Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
            return@Scaffold
        }
        val profile = state.profile
        LazyColumn(
            contentPadding = PaddingValues(
                start = 20.dp,
                end = 20.dp,
                top = padding.calculateTopPadding() + 4.dp,
                bottom = padding.calculateBottomPadding() + 32.dp,
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.readableWidth(),
        ) {
            item("via") {
                ProfileSummaryCard(profileSummary(profile, state.hated.size))
            }
            item("allergies") {
                Section("Allergies", eyebrow = countLabel(profile.allergens.size, "avoided")) {
                    AllergyEditor(profile.allergens, actions.onToggleAllergen)
                }
            }
            item("diets") {
                Section("Diet", eyebrow = countLabel(profile.diets.size, "followed")) {
                    DietEditor(profile.diets, actions.onToggleDiet)
                }
            }
            item("hated") {
                Section("Ingredients I hate", eyebrow = countLabel(state.hated.size, "hidden")) {
                    HatedIngredientsEditor(
                        hated = state.hated,
                        query = state.query,
                        suggestions = state.suggestions,
                        onQueryChange = actions.onQueryChange,
                        onSubmit = actions.onSubmitQuery,
                        onAdd = actions.onAddHated,
                        onRemove = actions.onRemoveHated,
                    )
                }
            }
            item("spice") {
                Section("Spice tolerance", eyebrow = profile.maxSpice?.let { SPICE_LABELS[it] } ?: "Not set") {
                    SpiceEditor(profile.maxSpice, actions.onSetMaxSpice)
                }
            }
            if (photos.total > 0) {
                item("photos") {
                    Section("Recipe photos", eyebrow = eyebrowText(photos)) {
                        RecipePhotosPanel(photos, photoActions)
                    }
                }
            }
            item("links") {
                Column(Modifier.padding(top = 16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    CraveButton(
                        "Favorites",
                        onClick = actions.onOpenFavorites,
                        variant = CraveButtonVariant.Secondary,
                        icon = Icons.Outlined.FavoriteBorder,
                        modifier = Modifier.fillMaxWidth(),
                    )
                    // A developer tool: debug builds only, never in the release APK's UI.
                    if (showDesignCatalog) {
                        CraveButton(
                            "Design system catalog",
                            onClick = actions.onOpenDesignSystem,
                            variant = CraveButtonVariant.Outline,
                            icon = Icons.Outlined.Palette,
                            modifier = Modifier.fillMaxWidth(),
                        )
                    }
                }
            }
            item("about") {
                Section("About", eyebrow = "CraveWise $appVersion") {
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                            "Everything works offline. Your food profile, kitchen and lists stay on this phone.",
                            style = MaterialTheme.typography.bodyMedium,
                        )
                        Text(
                            "Nutrition estimates: USDA FoodData Central (SR Legacy).",
                            style = MaterialTheme.typography.bodyMedium,
                            color = cs.onSurfaceVariant,
                        )
                        Text(
                            "Recipes and photos adapted from TheMealDB.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = cs.onSurfaceVariant,
                        )
                    }
                }
            }
        }
    }
}

/** Via's read-back of the rules: what's hidden, in one sentence. The one Via on Profile. */
@Composable
private fun ProfileSummaryCard(summary: String) {
    CraveSurface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
        hardShadow = false,
    ) {
        Row(Modifier.padding(20.dp), verticalAlignment = Alignment.CenterVertically) {
            ViaMascot(72.dp)
            Spacer(Modifier.width(16.dp))
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text("Your food rules", style = MaterialTheme.typography.titleMedium)
                Text(summary, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Composable
private fun Section(title: String, eyebrow: String, content: @Composable () -> Unit) {
    Column(Modifier.padding(top = 16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        SectionHeader(title, eyebrow = eyebrow)
        content()
    }
}

private fun countLabel(n: Int, verb: String) = if (n == 0) "None" else "$n $verb"

private val previewActions = ProfileActions({}, {}, {}, {}, {}, {}, {}, {}, {})

@CravePreviews
@Composable
private fun ProfileScreenPreview() = CraveWiseTheme {
    ProfileScreen(
        state = ProfileUiState(
            isLoading = false,
            profile = FoodProfile(allergens = setOf(Allergen.Peanuts), diets = setOf(Diet.Vegetarian), maxSpice = 3),
        ),
        actions = previewActions,
    )
}

@CravePreviews
@Composable
private fun ProfileScreenEmptyPreview() = CraveWiseTheme {
    ProfileScreen(state = ProfileUiState(isLoading = false), actions = previewActions)
}
