package com.example.cravewise.ui.quiz

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material.icons.outlined.Shuffle
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
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
import com.example.cravewise.domain.Craving
import com.example.cravewise.domain.DecideQuiz
import com.example.cravewise.domain.QuizAnswers
import com.example.cravewise.domain.QuizPick
import com.example.cravewise.domain.TimeBudget
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.model.Mood
import com.example.cravewise.domain.model.Protein
import com.example.cravewise.ui.designsystem.CraveButton
import com.example.cravewise.ui.designsystem.CraveButtonVariant
import com.example.cravewise.ui.designsystem.CraveChip
import com.example.cravewise.ui.designsystem.CravePreviews
import com.example.cravewise.ui.designsystem.FlavorChip
import com.example.cravewise.ui.designsystem.SectionHeader
import com.example.cravewise.ui.designsystem.ViaEmptyState
import com.example.cravewise.ui.designsystem.ViaSays
import com.example.cravewise.ui.recipe.PreviewRecipes
import com.example.cravewise.ui.recipe.RecipeSummaryCard
import com.example.cravewise.ui.theme.CraveWiseTheme
import com.example.cravewise.ui.theme.Flavor

@Composable
fun DecideQuizScreen(
    onBack: () -> Unit,
    onRecipeClick: (String) -> Unit,
    onOpenProfile: () -> Unit,
    viewModel: DecideQuizViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    DecideQuizScreen(
        state = state,
        actions = QuizActions(
            onBack = { if (!viewModel.back()) onBack() },
            onNext = viewModel::next,
            onMealType = viewModel::setMealType,
            onTime = viewModel::setTime,
            onMood = viewModel::setMood,
            onToggleCraving = viewModel::toggleCraving,
            onAnyCraving = viewModel::clearCravings,
            onProtein = viewModel::setProtein,
            onUsePantry = viewModel::setUsePantry,
            onShuffle = viewModel::shuffle,
            onStartOver = viewModel::startOver,
            onRecipeClick = onRecipeClick,
            onOpenProfile = onOpenProfile,
        ),
    )
}

class QuizActions(
    val onBack: () -> Unit,
    val onNext: () -> Unit,
    val onMealType: (MealType?) -> Unit,
    val onTime: (TimeBudget?) -> Unit,
    val onMood: (Mood?) -> Unit,
    val onToggleCraving: (Craving) -> Unit,
    val onAnyCraving: () -> Unit,
    val onProtein: (Protein?) -> Unit,
    val onUsePantry: (Boolean) -> Unit,
    val onShuffle: () -> Unit,
    val onStartOver: () -> Unit,
    val onRecipeClick: (String) -> Unit,
    val onOpenProfile: () -> Unit,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DecideQuizScreen(state: DecideQuizUiState, actions: QuizActions) {
    val cs = MaterialTheme.colorScheme
    // System back steps through the quiz like the top-bar arrow; on question 1 it leaves.
    BackHandler(enabled = state.showResults || state.step > 0) { actions.onBack() }

    Scaffold(
        containerColor = cs.background,
        topBar = {
            TopAppBar(
                title = { Text("Help me decide", style = MaterialTheme.typography.headlineSmall) },
                navigationIcon = {
                    IconButton(onClick = actions.onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = cs.background),
            )
        },
        bottomBar = {
            if (!state.isLoading && !state.showResults) {
                CraveButton(
                    if (state.isLastQuestion) "Show my picks" else "Next",
                    onClick = actions.onNext,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 16.dp),
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
            if (state.showResults) results(state, actions) else question(state, actions)
        }
    }
}

private fun LazyListScope.question(state: DecideQuizUiState, actions: QuizActions) {
    val question = state.question ?: return
    item("progress") {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                "Question ${state.step + 1} of ${state.questions.size}",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
            )
            LinearProgressIndicator(
                progress = { (state.step + 1f) / state.questions.size },
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
    item("via-${question.name}") { ViaSays(question.prompt) }
    item("options-${question.name}") { QuestionOptions(question, state, actions) }
}

private val QuizQuestion.prompt: String
    get() = when (this) {
        QuizQuestion.Meal -> "What are we making?"
        QuizQuestion.Time -> "How much time have you got?"
        QuizQuestion.Mood -> "What's the mood tonight?"
        QuizQuestion.Craving -> "What are you craving? Pick as many as you like."
        QuizQuestion.Protein -> "Any protein you fancy?"
        QuizQuestion.Pantry -> "Should I lean on what's already in your kitchen?"
    }

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun QuestionOptions(question: QuizQuestion, state: DecideQuizUiState, actions: QuizActions) {
    val a = state.answers
    FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        when (question) {
            QuizQuestion.Meal -> SingleChoice(state.mealTypes, a.mealType, { it.label }, actions.onMealType)
            QuizQuestion.Time -> SingleChoice(TimeBudget.entries, a.time, { "Up to ${it.label}" }, actions.onTime)
            QuizQuestion.Mood -> SingleChoice(state.moods, a.mood, { it.label }, actions.onMood)
            QuizQuestion.Protein -> SingleChoice(state.proteins, a.protein, { it.label }, actions.onProtein)
            QuizQuestion.Craving -> {
                CraveChip("Any", selected = a.cravings.isEmpty(), onClick = actions.onAnyCraving)
                Craving.entries.forEach { craving ->
                    FlavorChip(craving.flavor, selected = craving in a.cravings, onClick = { actions.onToggleCraving(craving) })
                }
            }
            QuizQuestion.Pantry -> {
                CraveChip("Yes, use my kitchen", selected = a.usePantry, onClick = { actions.onUsePantry(true) })
                CraveChip("No, anything goes", selected = !a.usePantry, onClick = { actions.onUsePantry(false) })
            }
        }
    }
}

/** "Any" plus one chip per option; tapping the selected chip goes back to Any. */
@Composable
private fun <T> SingleChoice(options: List<T>, selected: T?, label: (T) -> String, onSelect: (T?) -> Unit) {
    CraveChip("Any", selected = selected == null, onClick = { onSelect(null) })
    options.forEach { option ->
        CraveChip(label(option), selected = option == selected, onClick = { onSelect(if (option == selected) null else option) })
    }
}

private val Craving.flavor: Flavor
    get() = when (this) {
        Craving.Salty -> Flavor.Salty
        Craving.Sweet -> Flavor.Sweet
        Craving.Sour -> Flavor.Sour
        Craving.Umami -> Flavor.Umami
        Craving.Spicy -> Flavor.Spicy
    }

private fun LazyListScope.results(state: DecideQuizUiState, actions: QuizActions) {
    val showcase = state.showcase
    if (showcase == null) {
        item("empty") {
            if (state.hiddenByProfile) {
                ViaEmptyState(
                    title = "Hidden by your profile",
                    body = "I found matches, but none of them fit your food profile. Try different answers, or check your profile.",
                    actionLabel = "Review my profile",
                    onAction = actions.onOpenProfile,
                )
            } else {
                ViaEmptyState(
                    title = "Nothing ticks every box",
                    body = "No recipe fits that meal and time combo yet. Let's loosen things up and try again.",
                    actionLabel = "Start over",
                    onAction = actions.onStartOver,
                )
            }
        }
        return
    }
    item("via") { ViaSays("Ta-da! Here's my top pick for you.") }
    item("top-${showcase.top.recipe.id}") { PickCard(showcase.top, actions.onRecipeClick) }
    item("buttons") {
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            CraveButton(
                "Shuffle",
                onClick = actions.onShuffle,
                variant = CraveButtonVariant.Secondary,
                icon = Icons.Outlined.Shuffle,
                modifier = Modifier.weight(1f),
            )
            CraveButton(
                "Start over",
                onClick = actions.onStartOver,
                variant = CraveButtonVariant.Outline,
                icon = Icons.Outlined.Refresh,
                modifier = Modifier.weight(1f),
            )
        }
    }
    if (showcase.runnersUp.isNotEmpty()) {
        item("runners-header") { SectionHeader("Also worth a try", modifier = Modifier.padding(top = 16.dp)) }
        items(showcase.runnersUp, key = { "runner-${it.recipe.id}" }) { pick -> PickCard(pick, actions.onRecipeClick) }
    }
}

@Composable
private fun PickCard(pick: QuizPick, onRecipeClick: (String) -> Unit) {
    RecipeSummaryCard(
        recipe = pick.recipe,
        onClick = { onRecipeClick(pick.recipe.id) },
        footer = {
            Text(
                "Why this: ${pick.reasons.joinToString(" · ")}",
                style = MaterialTheme.typography.labelLarge,
            )
        },
    )
}

// ---------------------------------------------------------------------------------------------
// Previews
// ---------------------------------------------------------------------------------------------

private val previewActions = QuizActions({}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {})

private val previewQuestions = QuizQuestion.entries

@CravePreviews
@Composable
private fun QuizQuestionPreview() = CraveWiseTheme {
    DecideQuizScreen(
        state = DecideQuizUiState(
            isLoading = false,
            questions = previewQuestions,
            step = 3,
            answers = QuizAnswers(cravings = setOf(Craving.Umami, Craving.Salty)),
        ),
        actions = previewActions,
    )
}

@CravePreviews
@Composable
private fun QuizResultsPreview() = CraveWiseTheme {
    val answers = QuizAnswers(mood = Mood.Comfort, cravings = setOf(Craving.Umami))
    val picks = DecideQuiz.rank(PreviewRecipes.summaries, answers)
    DecideQuizScreen(
        state = DecideQuizUiState(
            isLoading = false,
            questions = previewQuestions,
            answers = answers,
            showResults = true,
            showcase = DecideQuiz.showcase(picks, 0),
        ),
        actions = previewActions,
    )
}

@CravePreviews
@Composable
private fun QuizHiddenPreview() = CraveWiseTheme {
    DecideQuizScreen(
        state = DecideQuizUiState(isLoading = false, questions = previewQuestions, showResults = true, hiddenByProfile = true),
        actions = previewActions,
    )
}
