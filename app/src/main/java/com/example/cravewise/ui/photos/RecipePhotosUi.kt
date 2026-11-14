package com.example.cravewise.ui.photos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DeleteOutline
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.example.cravewise.data.photos.PhotoJob
import com.example.cravewise.data.photos.RecipePhotosState
import com.example.cravewise.ui.designsystem.CraveButton
import com.example.cravewise.ui.designsystem.CraveButtonVariant
import com.example.cravewise.ui.designsystem.CravePreviews
import com.example.cravewise.ui.designsystem.CraveSurface
import com.example.cravewise.ui.designsystem.ViaSays
import com.example.cravewise.ui.theme.CraveWiseTheme

class RecipePhotosActions(
    val onDownload: () -> Unit,
    val onCancel: () -> Unit,
    val onRemove: () -> Unit,
    val onAllowMobileData: (Boolean) -> Unit,
)

/** The one-time Home ask. Replaces Home's generic Via line, so the screen still has one Via. */
@Composable
fun PhotoPrompt(state: RecipePhotosState, onDownload: () -> Unit, onNotNow: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier, verticalArrangement = Arrangement.spacedBy(12.dp)) {
        ViaSays(
            "Want real dish photos instead of my doodles? One download of about ${state.estimatedMegabytes} MB on " +
                "Wi-Fi, then they work offline.",
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            CraveButton(
                "Download photos",
                onClick = onDownload,
                variant = CraveButtonVariant.Secondary,
                icon = Icons.Outlined.Download,
                modifier = Modifier.weight(1f),
            )
            Spacer(Modifier.width(8.dp))
            TextButton(onClick = onNotNow) { Text("Not now", style = MaterialTheme.typography.labelLarge) }
        }
    }
}

/** Profile's "Recipe photos" panel: status, the one action that fits it, and the network rule. */
@Composable
fun RecipePhotosPanel(state: RecipePhotosState, actions: RecipePhotosActions, modifier: Modifier = Modifier) {
    val cs = MaterialTheme.colorScheme
    // Removing is cheap to undo in effort but not in data (~29 MB again), so it asks first.
    var confirmRemove by rememberSaveable { mutableStateOf(false) }
    if (confirmRemove) {
        RemovePhotosDialog(
            state = state,
            onConfirm = { confirmRemove = false; actions.onRemove() },
            onDismiss = { confirmRemove = false },
        )
    }
    val askFirst = actions.copyWithRemove { confirmRemove = true }
    CraveSurface(modifier.fillMaxWidth(), shape = MaterialTheme.shapes.medium, hardShadow = false) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(statusText(state), style = MaterialTheme.typography.bodyMedium)
            if (state.job == PhotoJob.Running && state.total > 0) {
                LinearProgressIndicator(
                    progress = { state.downloaded.toFloat() / state.total },
                    color = cs.primary,
                    trackColor = cs.surfaceVariant,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            PrimaryAction(state, askFirst)
            if (!state.isComplete) {
                HorizontalDivider(color = cs.outlineVariant)
                Row(
                    Modifier
                        .fillMaxWidth()
                        .toggleable(
                            value = state.allowMobileData,
                            role = Role.Switch,
                            onValueChange = actions.onAllowMobileData,
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column(Modifier.weight(1f)) {
                        Text("Use mobile data", style = MaterialTheme.typography.labelLarge)
                        Text(
                            "Off: photos only download on Wi-Fi.",
                            style = MaterialTheme.typography.bodySmall,
                            color = cs.onSurfaceVariant,
                        )
                    }
                    Spacer(Modifier.width(12.dp))
                    Switch(checked = state.allowMobileData, onCheckedChange = null)
                }
            }
            Text("Photos from TheMealDB (testing only).", style = MaterialTheme.typography.bodySmall, color = cs.onSurfaceVariant)
        }
    }
}

@Composable
private fun RemovePhotosDialog(state: RecipePhotosState, onConfirm: () -> Unit, onDismiss: () -> Unit) {
    val n = state.downloaded
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Remove recipe photos?") },
        text = {
            Text(
                "This deletes ${if (n == 1) "1 photo" else "$n photos"} (about ${removedMegabytes(n)} MB) from this phone. " +
                    "Recipes go back to my doodles. You can download the photos again any time.",
            )
        },
        confirmButton = { TextButton(onClick = onConfirm) { Text("Remove photos") } },
        dismissButton = { TextButton(onClick = onDismiss) { Text("Keep photos") } },
    )
}

/** Same per-photo estimate as the download copy, at least 1 MB so it never reads "0 MB". */
internal fun removedMegabytes(photos: Int): Int =
    (photos * RecipePhotosState.APPROX_PHOTO_KB / 1024).coerceAtLeast(1)

private fun RecipePhotosActions.copyWithRemove(onRemove: () -> Unit) =
    RecipePhotosActions(onDownload = onDownload, onCancel = onCancel, onRemove = onRemove, onAllowMobileData = onAllowMobileData)

@Composable
private fun PrimaryAction(state: RecipePhotosState, actions: RecipePhotosActions) {
    val full = Modifier.fillMaxWidth()
    when {
        state.isBusy -> CraveButton("Cancel download", onClick = actions.onCancel, variant = CraveButtonVariant.Outline, modifier = full)
        state.isComplete -> CraveButton(
            "Remove photos",
            onClick = actions.onRemove,
            variant = CraveButtonVariant.Outline,
            icon = Icons.Outlined.DeleteOutline,
            modifier = full,
        )
        else -> Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            CraveButton(
                when {
                    state.job == PhotoJob.Failed -> "Try again"
                    state.downloaded > 0 -> "Download the rest"
                    else -> "Download photos"
                },
                onClick = actions.onDownload,
                variant = CraveButtonVariant.Secondary,
                icon = if (state.job == PhotoJob.Failed) Icons.Outlined.Refresh else Icons.Outlined.Download,
                modifier = full,
            )
            if (state.downloaded > 0) {
                CraveButton(
                    "Remove photos",
                    onClick = actions.onRemove,
                    variant = CraveButtonVariant.Outline,
                    icon = Icons.Outlined.DeleteOutline,
                    modifier = full,
                )
            }
        }
    }
}

/** Says what's on the phone and what happens next, in one or two sentences. */
fun statusText(s: RecipePhotosState): String = when {
    s.job == PhotoJob.Running -> "Downloading ${s.downloaded} of ${s.total} photos. You can leave the app; it keeps going."
    s.job == PhotoJob.WaitingForNetwork && s.allowMobileData -> "Waiting for a connection. Photos download as soon as you're online."
    s.job == PhotoJob.WaitingForNetwork -> "Waiting for Wi-Fi. Photos download as soon as you're connected."
    s.job == PhotoJob.Failed ->
        "${s.failed} ${if (s.failed == 1) "photo" else "photos"} couldn't download. Check your connection and try again."
    s.isComplete -> "All ${s.total} photos are on this phone and work offline."
    s.downloaded > 0 -> "${s.downloaded} of ${s.total} photos downloaded. The rest show my doodles."
    else -> "Recipes show my doodles for now. Download real photos for all ${s.total} recipes: " +
        "about ${s.estimatedMegabytes} MB, once, then they work offline."
}

/** Short status for the Profile section eyebrow. */
fun eyebrowText(s: RecipePhotosState): String = when {
    s.job == PhotoJob.Running -> "Downloading"
    s.job == PhotoJob.WaitingForNetwork -> "Waiting"
    s.isComplete -> "Downloaded"
    s.downloaded > 0 -> "${s.downloaded} of ${s.total}"
    else -> "Off"
}

// ---------------------------------------------------------------------------------------------
// Previews
// ---------------------------------------------------------------------------------------------

private val previewActions = RecipePhotosActions({}, {}, {}, {})

@CravePreviews
@Composable
private fun PhotosPanelOffPreview() = CraveWiseTheme {
    RecipePhotosPanel(RecipePhotosState(total = 789), previewActions, Modifier.padding(16.dp))
}

@CravePreviews
@Composable
private fun PhotosPanelRunningPreview() = CraveWiseTheme {
    RecipePhotosPanel(RecipePhotosState(total = 789, downloaded = 312, job = PhotoJob.Running), previewActions, Modifier.padding(16.dp))
}

@CravePreviews
@Composable
private fun PhotosPanelFailedPreview() = CraveWiseTheme {
    RecipePhotosPanel(
        RecipePhotosState(total = 789, downloaded = 781, job = PhotoJob.Failed, failed = 8),
        previewActions,
        Modifier.padding(16.dp),
    )
}

@CravePreviews
@Composable
private fun PhotoPromptPreview() = CraveWiseTheme {
    PhotoPrompt(RecipePhotosState(total = 789), onDownload = {}, onNotNow = {}, modifier = Modifier.padding(16.dp))
}
