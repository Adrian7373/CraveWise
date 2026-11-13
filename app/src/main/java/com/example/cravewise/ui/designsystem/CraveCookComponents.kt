package com.example.cravewise.ui.designsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Pause
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.Remove
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material.icons.outlined.TimerOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.liveRegion
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cravewise.domain.NutrientAmounts
import com.example.cravewise.ui.theme.CraveTheme
import java.util.Locale
import kotlin.math.roundToInt

// ---------------------------------------------------------------------------------------------
// Layout: tablets and wide windows
// ---------------------------------------------------------------------------------------------

/** Window-width breakpoints and readable widths. Use these instead of ad-hoc numbers. */
object CraveLayout {
    /** Screen gutter on phones. */
    val Gutter: Dp = 20.dp

    /** Text-heavy single-column screens never get wider than this; extra space becomes margin. */
    val ReadableWidth: Dp = 720.dp

    /** At or above this width a screen may split into two columns (recipe detail, cook mode). */
    val TwoColumnWidth: Dp = 720.dp

    /** Minimum width of one recipe card in an adaptive grid. */
    val CardMinWidth: Dp = 320.dp

    /** Gutter that centers a [ReadableWidth] column inside [available], never below [Gutter]. */
    fun gutterFor(available: Dp): Dp = maxOf(Gutter, (available - ReadableWidth) / 2)
}

/**
 * Fills the width on phones; on wider windows caps the content at [CraveLayout.ReadableWidth] and
 * centers it, so single-column screens don't stretch into long lines on tablets. Apply it to a
 * screen's main `LazyColumn` (keep the usual 20dp gutter in its content padding).
 */
fun Modifier.readableWidth(): Modifier =
    fillMaxSize().wrapContentWidth(Alignment.CenterHorizontally).widthIn(max = CraveLayout.ReadableWidth)

// ---------------------------------------------------------------------------------------------
// Cooking
// ---------------------------------------------------------------------------------------------

/** − N servings + stepper. Flat container; the two buttons are the actions. */
@Composable
fun ServingsStepper(
    value: Int,
    onValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    min: Int = 1,
    max: Int = 24,
) {
    val label = if (value == 1) "1 serving" else "$value servings"
    CraveSurface(modifier, shape = CraveTheme.extras.chipShape, hardShadow = false) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { onValueChange(value - 1) }, enabled = value > min) {
                Icon(Icons.Outlined.Remove, contentDescription = "Fewer servings")
            }
            Text(
                label,
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .widthIn(min = 96.dp)
                    .semantics { liveRegion = LiveRegionMode.Polite },
            )
            IconButton(onClick = { onValueChange(value + 1) }, enabled = value < max) {
                Icon(Icons.Outlined.Add, contentDescription = "More servings")
            }
        }
    }
}

/** Segmented progress through a recipe's steps. [current] is 0-based. */
@Composable
fun StepProgress(current: Int, total: Int, modifier: Modifier = Modifier) {
    val cs = MaterialTheme.colorScheme
    Row(
        modifier
            .fillMaxWidth()
            .semantics { contentDescription = "Step ${current + 1} of $total" },
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        repeat(total) { i ->
            Box(
                Modifier
                    .weight(1f)
                    .height(6.dp)
                    .background(if (i <= current) cs.primary else cs.outlineVariant, CraveTheme.extras.chipShape),
            )
        }
    }
}

enum class CookTimerState { Running, Paused, Done }

/**
 * A kitchen timer: label, big clock, pause/resume, +1 min and dismiss. Running timers are saffron;
 * a finished one turns tomato so it reads from across the kitchen.
 */
@Composable
fun CookTimerCard(
    label: String,
    clock: String,
    state: CookTimerState,
    onPauseResume: () -> Unit,
    onAddMinute: () -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val cs = MaterialTheme.colorScheme
    val (container, content) = when (state) {
        CookTimerState.Running -> cs.secondaryContainer to cs.onSecondaryContainer
        CookTimerState.Paused -> CraveTheme.extras.cardColor to cs.onSurface
        CookTimerState.Done -> cs.primary to cs.onPrimary
    }
    CraveSurface(
        modifier.width(196.dp),
        shape = MaterialTheme.shapes.medium,
        color = container,
        contentColor = content,
        hardShadow = state != CookTimerState.Paused,
    ) {
        Column(Modifier.padding(start = 12.dp, top = 4.dp, bottom = 4.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    if (state == CookTimerState.Done) Icons.Outlined.TimerOff else Icons.Outlined.Timer,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                )
                Spacer(Modifier.width(6.dp))
                Text(
                    label,
                    style = MaterialTheme.typography.labelMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f),
                )
                IconButton(onClick = onDismiss) {
                    Icon(Icons.Outlined.Close, contentDescription = "Dismiss $label timer", modifier = Modifier.size(18.dp))
                }
            }
            Text(
                if (state == CookTimerState.Done) "Time's up!" else clock,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.semantics {
                    if (state == CookTimerState.Done) liveRegion = LiveRegionMode.Assertive
                },
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (state != CookTimerState.Done) {
                    IconButton(onClick = onPauseResume) {
                        Icon(
                            if (state == CookTimerState.Running) Icons.Outlined.Pause else Icons.Outlined.PlayArrow,
                            contentDescription = if (state == CookTimerState.Running) "Pause $label timer" else "Resume $label timer",
                        )
                    }
                }
                TextButton(onClick = onAddMinute) {
                    Text("+1 min", style = MaterialTheme.typography.labelLarge, color = LocalContentColor.current)
                }
            }
        }
    }
}

// ---------------------------------------------------------------------------------------------
// Nutrition
// ---------------------------------------------------------------------------------------------

/**
 * Estimated nutrition per serving: kcal headline, protein/carbs/fat bars (bar length = share of
 * energy), then fiber, sugar and sodium, plus how many ingredients the estimate covers. Pass
 * [perServing] = null for the "unavailable" state. Static info, so no sticker shadow.
 *
 * @param totalKcal whole-recipe energy at [servings], shown when the recipe is scaled.
 */
@Composable
fun NutritionPanel(
    perServing: NutrientAmounts?,
    coveredLines: Int,
    totalLines: Int,
    modifier: Modifier = Modifier,
    servings: Int? = null,
    totalKcal: Double? = null,
) {
    val cs = MaterialTheme.colorScheme
    CraveSurface(modifier.fillMaxWidth(), hardShadow = false) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Row(verticalAlignment = Alignment.Bottom) {
                Text("Nutrition", style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1f))
                if (perServing != null) {
                    Text("per serving", style = MaterialTheme.typography.labelMedium, color = cs.onSurfaceVariant)
                }
            }
            if (perServing == null) {
                Row(verticalAlignment = Alignment.Top) {
                    Icon(Icons.Outlined.Info, contentDescription = null, tint = cs.onSurfaceVariant, modifier = Modifier.size(20.dp))
                    Spacer(Modifier.width(8.dp))
                    Text(
                        "Not enough data for this one: we could weigh $coveredLines of $totalLines ingredients, " +
                            "so we'd rather not guess.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = cs.onSurfaceVariant,
                    )
                }
                return@Column
            }
            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.semantics(mergeDescendants = true) {},
            ) {
                Text(formatWhole(perServing.kcal), style = MaterialTheme.typography.headlineMedium)
                Spacer(Modifier.width(6.dp))
                Text("kcal", style = MaterialTheme.typography.labelLarge, modifier = Modifier.padding(bottom = 4.dp))
            }
            val energy = (perServing.protein * 4 + perServing.carbs * 4 + perServing.fat * 9).coerceAtLeast(1.0)
            MacroBar("Protein", perServing.protein, (perServing.protein * 4 / energy).toFloat(), cs.primary)
            MacroBar("Carbs", perServing.carbs, (perServing.carbs * 4 / energy).toFloat(), cs.secondary)
            MacroBar("Fat", perServing.fat, (perServing.fat * 9 / energy).toFloat(), cs.tertiary)
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                MinorFact("Fiber", "${formatGrams(perServing.fiber)} g")
                MinorFact("Sugar", "${formatGrams(perServing.sugar)} g")
                MinorFact("Sodium", "${formatWhole(perServing.sodium)} mg")
            }
            if (servings != null && totalKcal != null) {
                Text(
                    "Whole recipe (${if (servings == 1) "1 serving" else "$servings servings"}): ${formatWhole(totalKcal)} kcal",
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
            Text(
                "Estimated from $coveredLines of $totalLines ingredients using USDA data.",
                style = MaterialTheme.typography.labelMedium,
                color = cs.onSurfaceVariant,
            )
        }
    }
}

@Composable
private fun MacroBar(label: String, grams: Double, share: Float, color: androidx.compose.ui.graphics.Color) {
    val cs = MaterialTheme.colorScheme
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.semantics(mergeDescendants = true) {
            contentDescription = "$label ${formatGrams(grams)} grams, ${(share * 100).roundToInt()} percent of energy"
        },
    ) {
        Row {
            Text(label, style = MaterialTheme.typography.labelLarge, modifier = Modifier.weight(1f))
            Text("${formatGrams(grams)} g", style = MaterialTheme.typography.labelLarge)
        }
        Box(
            Modifier
                .fillMaxWidth()
                .height(8.dp)
                .background(cs.outlineVariant, CraveTheme.extras.chipShape),
        ) {
            Box(
                Modifier
                    .fillMaxWidth(share.coerceIn(0f, 1f))
                    .height(8.dp)
                    .background(color, CraveTheme.extras.chipShape),
            )
        }
    }
}

@Composable
private fun MinorFact(label: String, value: String) {
    Column(Modifier.semantics(mergeDescendants = true) {}) {
        Text(label, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Text(value, style = MaterialTheme.typography.labelLarge)
    }
}

private fun formatWhole(value: Double): String = String.format(Locale.getDefault(), "%,d", value.roundToInt())

private fun formatGrams(value: Double): String =
    if (value < 10) String.format(Locale.getDefault(), "%.1f", value) else formatWhole(value)

// ---------------------------------------------------------------------------------------------
// Previews
// ---------------------------------------------------------------------------------------------

@CravePreviews
@Composable
private fun ServingsStepperPreview() = CravePreviewSurface {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        ServingsStepper(value = 4, onValueChange = {})
        ServingsStepper(value = 1, onValueChange = {}) // minus disabled
    }
}

internal val PreviewNutrition = NutrientAmounts(
    kcal = 512.0, protein = 31.4, carbs = 48.2, fat = 21.7, fiber = 6.3, sugar = 9.8, sodium = 840.0,
)

@CravePreviews
@Composable
private fun NutritionPanelPreview() = CravePreviewSurface {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        NutritionPanel(PreviewNutrition, coveredLines = 9, totalLines = 11)
        NutritionPanel(PreviewNutrition, coveredLines = 9, totalLines = 11, servings = 6, totalKcal = 3072.0)
        NutritionPanel(perServing = null, coveredLines = 5, totalLines = 11)
    }
}

@CravePreviews
@Composable
private fun StepProgressPreview() = CravePreviewSurface { StepProgress(current = 2, total = 6) }

@CravePreviews
@Composable
private fun CookTimerCardPreview() = CravePreviewSurface {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        CookTimerCard("Step 2 · 20 min", "17:42", CookTimerState.Running, {}, {}, {})
        CookTimerCard("Step 3 · 5 min", "3:10", CookTimerState.Paused, {}, {}, {})
        CookTimerCard("Step 4 · 45 sec", "0:00", CookTimerState.Done, {}, {}, {})
    }
}
