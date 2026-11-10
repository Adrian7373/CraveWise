package com.example.cravewise.ui.onboarding

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cravewise.domain.model.Allergen
import com.example.cravewise.domain.model.FoodProfile
import com.example.cravewise.ui.designsystem.CraveButton
import com.example.cravewise.ui.designsystem.CraveButtonVariant
import com.example.cravewise.ui.designsystem.CravePreviews
import com.example.cravewise.ui.designsystem.ViaSays
import com.example.cravewise.ui.profile.AllergyEditor
import com.example.cravewise.ui.profile.DietEditor
import com.example.cravewise.ui.profile.HatedIngredientsEditor
import com.example.cravewise.ui.profile.ProfileActions
import com.example.cravewise.ui.profile.ProfileUiState
import com.example.cravewise.ui.profile.ProfileViewModel
import com.example.cravewise.ui.profile.SpiceEditor
import com.example.cravewise.ui.theme.CraveWiseTheme

private enum class OnboardingStep(val title: String, val via: String) {
    Allergies("Any allergies?", "Hi, I'm Via! First things first: anything you need to stay away from?"),
    Diet("Do you follow a diet?", "Got it. Any diets I should stick to? Pick as many as you like."),
    Hated("Any ingredients you hate?", "No judgement here. Tell me what never belongs on your plate."),
    Spice("How much heat?", "Last one! How spicy can you handle it?"),
}

/**
 * First-run setup. Every change saves immediately, so "Skip" just ends the flow and keeps
 * whatever was picked so far. Everything stays editable on the Profile tab.
 */
@Composable
fun OnboardingScreen(viewModel: ProfileViewModel = hiltViewModel()) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    OnboardingScreen(
        state = state,
        actions = ProfileActions(
            onToggleAllergen = viewModel::toggleAllergen,
            onToggleDiet = viewModel::toggleDiet,
            onQueryChange = viewModel::onQueryChange,
            onSubmitQuery = viewModel::submitQuery,
            onAddHated = viewModel::addHated,
            onRemoveHated = viewModel::removeHated,
            onSetMaxSpice = viewModel::setMaxSpice,
            onOpenFavorites = {},
            onOpenDesignSystem = {},
        ),
        onFinish = viewModel::completeOnboarding,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingScreen(
    state: ProfileUiState,
    actions: ProfileActions,
    onFinish: () -> Unit,
    initialStep: Int = 0,
) {
    val cs = MaterialTheme.colorScheme
    val steps = OnboardingStep.entries
    var index by rememberSaveable { mutableIntStateOf(initialStep) }
    val step = steps[index]
    val isLast = index == steps.lastIndex

    BackHandler(enabled = index > 0) { index-- }

    Scaffold(
        containerColor = cs.background,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Step ${index + 1} of ${steps.size}",
                        style = MaterialTheme.typography.labelLarge,
                        color = cs.primary,
                    )
                },
                actions = {
                    TextButton(onClick = onFinish) { Text("Skip", style = MaterialTheme.typography.labelLarge) }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = cs.background),
            )
        },
        bottomBar = {
            Row(
                Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
                    .padding(horizontal = 20.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                if (index > 0) {
                    CraveButton(
                        "Back",
                        onClick = { index-- },
                        variant = CraveButtonVariant.Outline,
                        modifier = Modifier.weight(1f),
                    )
                }
                CraveButton(
                    if (isLast) "Let's eat!" else "Next",
                    onClick = { if (isLast) onFinish() else index++ },
                    modifier = Modifier.weight(if (index > 0) 1.6f else 1f),
                )
            }
        },
    ) { padding ->
        if (state.isLoading) {
            Box(Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
            return@Scaffold
        }
        LazyColumn(
            contentPadding = PaddingValues(
                start = 20.dp,
                end = 20.dp,
                top = padding.calculateTopPadding() + 4.dp,
                bottom = padding.calculateBottomPadding() + 24.dp,
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize(),
        ) {
            item("progress") {
                LinearProgressIndicator(
                    progress = { (index + 1f) / steps.size },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            item("via-$index") { ViaSays(step.via) }
            item("title-$index") {
                Column(Modifier.padding(top = 8.dp)) {
                    Text(step.title, style = MaterialTheme.typography.headlineMedium)
                    Text(
                        "Optional. You can change this any time in Profile.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = cs.onSurfaceVariant,
                    )
                }
            }
            item("editor-$index") {
                val profile = state.profile
                when (step) {
                    OnboardingStep.Allergies -> AllergyEditor(profile.allergens, actions.onToggleAllergen)
                    OnboardingStep.Diet -> DietEditor(profile.diets, actions.onToggleDiet)
                    OnboardingStep.Hated -> HatedIngredientsEditor(
                        hated = state.hated,
                        query = state.query,
                        suggestions = state.suggestions,
                        onQueryChange = actions.onQueryChange,
                        onSubmit = actions.onSubmitQuery,
                        onAdd = actions.onAddHated,
                        onRemove = actions.onRemoveHated,
                    )
                    OnboardingStep.Spice -> SpiceEditor(profile.maxSpice, actions.onSetMaxSpice)
                }
            }
        }
    }
}

private val previewActions = ProfileActions({}, {}, {}, {}, {}, {}, {}, {}, {})

@CravePreviews
@Composable
private fun OnboardingAllergiesPreview() = CraveWiseTheme {
    OnboardingScreen(
        state = ProfileUiState(isLoading = false, profile = FoodProfile(allergens = setOf(Allergen.Peanuts))),
        actions = previewActions,
        onFinish = {},
    )
}

@CravePreviews
@Composable
private fun OnboardingSpicePreview() = CraveWiseTheme {
    OnboardingScreen(
        state = ProfileUiState(isLoading = false, profile = FoodProfile(maxSpice = 2)),
        actions = previewActions,
        onFinish = {},
        initialStep = 3,
    )
}
