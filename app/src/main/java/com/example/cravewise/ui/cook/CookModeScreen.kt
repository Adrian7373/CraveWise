package com.example.cravewise.ui.cook

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.FormatListBulleted
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cravewise.domain.RecipeScaling
import com.example.cravewise.domain.cook.StepTimer
import com.example.cravewise.domain.cook.StepTimers
import com.example.cravewise.domain.model.Recipe
import com.example.cravewise.navigation.CookModeRoute
import com.example.cravewise.ui.designsystem.CookTimerCard
import com.example.cravewise.ui.designsystem.CookTimerState
import com.example.cravewise.ui.designsystem.CraveButton
import com.example.cravewise.ui.designsystem.CraveButtonVariant
import com.example.cravewise.ui.designsystem.CraveLayout
import com.example.cravewise.ui.designsystem.CravePreviews
import com.example.cravewise.ui.designsystem.CraveSurface
import com.example.cravewise.ui.designsystem.StepProgress
import com.example.cravewise.ui.designsystem.ViaEmptyState
import com.example.cravewise.ui.recipe.PreviewRecipes
import com.example.cravewise.ui.theme.CraveWiseTheme
import com.example.cravewise.ui.theme.cookStep
import kotlinx.coroutines.launch

@Composable
fun CookModeScreen(
    route: CookModeRoute,
    onExit: () -> Unit,
    viewModel: CookModeViewModel = hiltViewModel<CookModeViewModel, CookModeViewModel.Factory>(
        creationCallback = { it.create(route) },
    ),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    CookModeScreen(
        state = state,
        actions = CookModeActions(
            onExit = onExit,
            onStartTimer = viewModel::startTimer,
            onPauseResume = viewModel::pauseOrResume,
            onAddMinute = viewModel::addMinute,
            onDismissTimer = viewModel::dismiss,
            onToggleIngredient = viewModel::toggleIngredient,
        ),
    )
}

class CookModeActions(
    val onExit: () -> Unit,
    val onStartTimer: (stepIndex: Int, timer: StepTimer) -> Unit,
    val onPauseResume: (Long) -> Unit,
    val onAddMinute: (Long) -> Unit,
    val onDismissTimer: (Long) -> Unit,
    val onToggleIngredient: (Int) -> Unit,
)

/**
 * Hands-free cooking: one step per page in big type, timers found in the text, and the scaled
 * ingredients as a tick-off list (bottom sheet on phones, side panel on tablets). The screen stays
 * on, and leaving with timers running asks first because they stop with cook mode.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CookModeScreen(state: CookModeUiState, actions: CookModeActions) {
    KeepScreenOn()
    val cs = MaterialTheme.colorScheme
    val recipe = state.recipe
    val stepCount = recipe?.steps?.size ?: 0
    // One page per step plus the "done" page.
    val pager = rememberPagerState { stepCount + 1 }
    var showIngredients by rememberSaveable { mutableStateOf(false) }
    var confirmExit by rememberSaveable { mutableStateOf(false) }
    val requestExit = { if (state.hasActiveTimers) confirmExit = true else actions.onExit() }
    BackHandler(enabled = state.hasActiveTimers) { confirmExit = true }

    BoxWithConstraints(Modifier.fillMaxSize()) {
        val wide = maxWidth >= CraveLayout.TwoColumnWidth
        val gutter = if (wide) 24.dp else CraveLayout.gutterFor(maxWidth)
        Scaffold(
            containerColor = cs.background,
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(onClick = requestExit) {
                            Icon(Icons.Outlined.Close, contentDescription = "Exit cook mode")
                        }
                    },
                    title = {
                        Column {
                            Text(
                                recipe?.title.orEmpty(),
                                style = MaterialTheme.typography.titleMedium,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )
                            if (stepCount > 0) {
                                Text(
                                    if (pager.currentPage < stepCount) "Step ${pager.currentPage + 1} of $stepCount" else "All done",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = cs.onSurfaceVariant,
                                )
                            }
                        }
                    },
                    actions = {
                        if (!wide && recipe != null) {
                            IconButton(onClick = { showIngredients = true }) {
                                Icon(Icons.AutoMirrored.Outlined.FormatListBulleted, contentDescription = "Ingredients")
                            }
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = cs.background),
                )
            },
        ) { padding ->
            Box(Modifier.fillMaxSize().padding(padding)) {
                when {
                    state.isLoading -> CircularProgressIndicator(Modifier.align(Alignment.Center))
                    recipe == null -> ViaEmptyState(
                        title = "This recipe wandered off",
                        body = "It may have left the cookbook in an update. Let's find you another one.",
                        actionLabel = "Exit cook mode",
                        onAction = actions.onExit,
                        modifier = Modifier.align(Alignment.Center),
                    )
                    stepCount == 0 -> ViaEmptyState(
                        title = "No steps to follow",
                        body = "This one came without a method. Check the original recipe for how it's done.",
                        actionLabel = "Back to recipe",
                        onAction = actions.onExit,
                        modifier = Modifier.align(Alignment.Center),
                    )
                    wide -> Row(Modifier.fillMaxSize()) {
                        IngredientChecklist(
                            recipe = recipe,
                            scale = state.scale,
                            servings = state.servings,
                            checked = state.checkedIngredients,
                            onToggle = actions.onToggleIngredient,
                            modifier = Modifier
                                .width(360.dp)
                                .fillMaxHeight()
                                .padding(start = gutter, bottom = 16.dp),
                        )
                        CookPane(state, recipe, pager, actions, gutter, Modifier.weight(1f))
                    }
                    else -> CookPane(state, recipe, pager, actions, gutter, Modifier.fillMaxSize())
                }
            }
        }
    }

    if (showIngredients && recipe != null) {
        ModalBottomSheet(onDismissRequest = { showIngredients = false }, containerColor = cs.background) {
            IngredientChecklist(
                recipe = recipe,
                scale = state.scale,
                servings = state.servings,
                checked = state.checkedIngredients,
                onToggle = actions.onToggleIngredient,
                modifier = Modifier.padding(horizontal = 20.dp).padding(bottom = 24.dp),
            )
        }
    }

    if (confirmExit) {
        val n = state.timers.size
        AlertDialog(
            onDismissRequest = { confirmExit = false },
            title = { Text("Leave cook mode?") },
            text = { Text(if (n == 1) "Your timer will stop." else "Your $n timers will stop.") },
            confirmButton = {
                TextButton(onClick = { confirmExit = false; actions.onExit() }) { Text("Leave") }
            },
            dismissButton = {
                TextButton(onClick = { confirmExit = false }) { Text("Keep cooking") }
            },
        )
    }
}

@Composable
private fun CookPane(
    state: CookModeUiState,
    recipe: Recipe,
    pager: PagerState,
    actions: CookModeActions,
    gutter: Dp,
    modifier: Modifier = Modifier,
) {
    val scope = rememberCoroutineScope()
    val steps = recipe.steps
    val page = pager.currentPage
    Column(modifier) {
        StepProgress(
            current = page.coerceAtMost(steps.lastIndex),
            total = steps.size,
            modifier = Modifier.padding(horizontal = gutter),
        )
        if (state.timers.isNotEmpty()) {
            LazyRow(
                contentPadding = PaddingValues(horizontal = gutter),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(top = 16.dp),
            ) {
                items(state.timers, key = { it.id }) { timer ->
                    CookTimerCard(
                        label = timer.label,
                        clock = timer.clock,
                        state = timer.state,
                        onPauseResume = { actions.onPauseResume(timer.id) },
                        onAddMinute = { actions.onAddMinute(timer.id) },
                        onDismiss = { actions.onDismissTimer(timer.id) },
                    )
                }
            }
        }
        HorizontalPager(
            state = pager,
            key = { it },
            modifier = Modifier.weight(1f).fillMaxWidth(),
        ) { index ->
            if (index < steps.size) {
                StepPage(index, steps[index], state, actions, gutter)
            } else {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    ViaEmptyState(
                        title = "Slurp-worthy!",
                        body = "That's every step. Plate it up and dig in, chef.",
                        actionLabel = "Back to recipe",
                        onAction = actions.onExit,
                    )
                }
            }
        }
        if (page < steps.size) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = gutter, end = gutter, top = 8.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                if (page > 0) {
                    CraveButton(
                        "Back",
                        onClick = { scope.launch { pager.animateScrollToPage(page - 1) } },
                        variant = CraveButtonVariant.Outline,
                        modifier = Modifier.weight(1f),
                    )
                }
                CraveButton(
                    if (page == steps.lastIndex) "Finish" else "Next step",
                    onClick = { scope.launch { pager.animateScrollToPage(page + 1) } },
                    modifier = Modifier.weight(1.4f),
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun StepPage(index: Int, text: String, state: CookModeUiState, actions: CookModeActions, gutter: Dp) {
    val cs = MaterialTheme.colorScheme
    val found = state.stepTimers.getOrNull(index).orEmpty()
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = gutter, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        Text("Step ${index + 1}", style = MaterialTheme.typography.headlineSmall, color = cs.primary)
        Text(highlightTimers(text, found, cs.primary), style = MaterialTheme.typography.cookStep)
        if (found.isNotEmpty()) {
            FlowRow(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                found.forEach { timer ->
                    val running = state.timerFor(index, timer)
                    CraveButton(
                        if (running == null) "Start ${timer.label} timer" else "Timer on · ${running.clock}",
                        onClick = { actions.onStartTimer(index, timer) },
                        variant = CraveButtonVariant.Secondary,
                        icon = Icons.Outlined.Timer,
                        enabled = running == null,
                    )
                }
            }
        }
    }
}

/** Bold + tomato on the durations, so the timer buttons below map back to the text. */
private fun highlightTimers(text: String, timers: List<StepTimer>, color: Color): AnnotatedString =
    buildAnnotatedString {
        var cursor = 0
        timers.sortedBy { it.range.first }.forEach { t ->
            if (t.range.first < cursor) return@forEach
            append(text.substring(cursor, t.range.first))
            withStyle(SpanStyle(color = color, fontWeight = FontWeight.Bold)) {
                append(text.substring(t.range.first, t.range.last + 1))
            }
            cursor = t.range.last + 1
        }
        append(text.substring(cursor))
    }

/** Scaled ingredients to tick off while prepping. Ticks are kept for the whole cook session. */
@Composable
private fun IngredientChecklist(
    recipe: Recipe,
    scale: Double,
    servings: Int,
    checked: Set<Int>,
    onToggle: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val cs = MaterialTheme.colorScheme
    Column(modifier, verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Column {
            Text(
                if (servings == 1) "For 1 serving" else "For $servings servings",
                style = MaterialTheme.typography.labelMedium,
                color = cs.primary,
            )
            Text("Ingredients", style = MaterialTheme.typography.headlineSmall)
        }
        CraveSurface(Modifier.fillMaxWidth().weight(1f, fill = false), hardShadow = false) {
            Column(Modifier.verticalScroll(rememberScrollState()).padding(vertical = 4.dp)) {
                recipe.ingredients.forEachIndexed { i, line ->
                    if (i > 0) HorizontalDivider(color = cs.outlineVariant, modifier = Modifier.padding(horizontal = 12.dp))
                    val done = i in checked
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .heightIn(min = 48.dp)
                            .toggleable(value = done, role = Role.Checkbox, onValueChange = { onToggle(i) })
                            .padding(horizontal = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Checkbox(checked = done, onCheckedChange = null, modifier = Modifier.padding(12.dp))
                        val measure = RecipeScaling.measure(line, scale)
                        Text(
                            buildString {
                                if (measure.isNotBlank()) append(measure).append("  ")
                                append(line.rawName.replaceFirstChar { it.titlecase() })
                            },
                            style = MaterialTheme.typography.bodyLarge,
                            color = if (done) cs.onSurfaceVariant else cs.onSurface,
                            textDecoration = if (done) TextDecoration.LineThrough else null,
                            modifier = Modifier.weight(1f).padding(end = 12.dp),
                        )
                    }
                }
            }
        }
    }
}

/** Cooking means messy hands: don't let the screen time out while cook mode is open. */
@Composable
private fun KeepScreenOn() {
    val view = LocalView.current
    DisposableEffect(view) {
        view.keepScreenOn = true
        onDispose { view.keepScreenOn = false }
    }
}

// ---------------------------------------------------------------------------------------------
// Previews
// ---------------------------------------------------------------------------------------------

private val previewActions = CookModeActions({}, { _, _ -> }, {}, {}, {}, {})

private fun previewState() = PreviewRecipes.recipe.let { r ->
    CookModeUiState(
        isLoading = false,
        recipe = r,
        servings = r.servings,
        stepTimers = r.steps.map(StepTimers::find),
        timers = listOf(
            CookTimerUi(1, "Step 1 · 20 min", 0, "17:42", CookTimerState.Running),
            CookTimerUi(2, "Step 2 · 5 min", 1, "0:00", CookTimerState.Done),
        ),
        checkedIngredients = setOf(0),
    )
}

@CravePreviews
@Composable
private fun CookModePreview() = CraveWiseTheme { CookModeScreen(previewState(), previewActions) }

@Preview(name = "Tablet", device = "spec:width=1280dp,height=800dp,dpi=240", showBackground = true)
@Composable
private fun CookModeTabletPreview() = CraveWiseTheme { CookModeScreen(previewState(), previewActions) }

@CravePreviews
@Composable
private fun CookModeMissingPreview() = CraveWiseTheme {
    CookModeScreen(CookModeUiState(isLoading = false), previewActions)
}
