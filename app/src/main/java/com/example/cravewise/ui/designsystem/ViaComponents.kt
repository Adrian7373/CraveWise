package com.example.cravewise.ui.designsystem

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.cravewise.R
import com.example.cravewise.ui.theme.CraveTheme
import com.example.cravewise.ui.theme.CraveWiseTheme

/*
 * Via the panda. One character, one look (flat sticker, ink outline, white sticker border,
 * tomato cap, saffron scarf). Every Via in the app is the avatar or one of these poses.
 * Don't stretch, recolor or redraw the artwork; add a pose by generating it in the same style.
 */

/** Full-body sticker poses (transparent background, white sticker border baked in). */
enum class ViaPose(@param:DrawableRes val drawable: Int, val description: String) {
    /** Greetings and tips: the Home hero, onboarding. */
    Hello(R.drawable.via_hello, "Via the panda waving hello"),

    /** Empty, no-results and error states. */
    Thinking(R.drawable.via_thinking, "Via the panda puzzling over a noodle bowl"),

    /** Shopping list. */
    Shopping(R.drawable.via_shopping, "Via the panda carrying a shopping basket"),

    /** Done, picked, finished: cook mode's last page, quiz results. */
    Celebrate(R.drawable.via_celebrate, "Via the panda cheering with a bowl of noodles"),
}

/** Width / height of the pose artwork, so callers can size by height and keep the aspect. */
private const val POSE_ASPECT = 0.88f

/** A full-body Via pose, sized by its [height]. Decorative by default next to Via's own words. */
@Composable
fun ViaFigure(
    pose: ViaPose,
    height: Dp,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
) {
    Image(
        painter = painterResource(pose.drawable),
        contentDescription = contentDescription,
        contentScale = ContentScale.Fit,
        modifier = modifier.size(width = height * POSE_ASPECT, height = height),
    )
}

/** Via's face: the head-and-scarf crop on a saffron disc with the ink outline. */
@Composable
fun ViaMascot(size: Dp, modifier: Modifier = Modifier) {
    val extras = CraveTheme.extras
    Image(
        painter = painterResource(extras.mascot),
        contentDescription = "Via the panda",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(size)
            .clip(extras.mascotShape)
            .background(extras.mascotBackdrop)
            .border(extras.borderWidth, extras.borderColor, extras.mascotShape),
    )
}

/** Which side of the bubble Via is on; the tail points that way. */
enum class BubbleTail { Start, End }

/**
 * A rounded speech bubble with a small tail near the bottom of one side. Used through
 * [ViaSpeechBubble], so the outline and sticker shadow follow the tail.
 */
class SpeechBubbleShape(
    private val tail: BubbleTail,
    private val corner: Dp = 22.dp,
    private val tailWidth: Dp = 14.dp,
    private val tailHeight: Dp = 16.dp,
) : Shape {
    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density): Outline =
        with(density) {
            val tw = tailWidth.toPx()
            val th = tailHeight.toPx()
            val leftTail = (tail == BubbleTail.Start) == (layoutDirection == LayoutDirection.Ltr)
            val bodyLeft = if (leftTail) tw else 0f
            val bodyRight = if (leftTail) size.width else size.width - tw
            val r = corner.toPx().coerceAtMost(size.height / 2)
            val body = Path().apply {
                addRoundRect(RoundRect(bodyLeft, 0f, bodyRight, size.height, CornerRadius(r)))
            }
            // Base sits inside the body, above the rounded corner; the tip pokes out level with
            // the base's lower edge, like a comic bubble.
            val baseBottom = (size.height - r).coerceAtLeast(th)
            val baseTop = baseBottom - th
            val inset = r * 0.6f
            val tri = Path().apply {
                if (leftTail) {
                    moveTo(bodyLeft + inset, baseTop)
                    lineTo(0f, baseBottom)
                    lineTo(bodyLeft + inset, baseBottom)
                } else {
                    moveTo(bodyRight - inset, baseTop)
                    lineTo(size.width, baseBottom)
                    lineTo(bodyRight - inset, baseBottom)
                }
                close()
            }
            Outline.Generic(Path.combine(PathOperation.Union, body, tri))
        }
}

/** A sticker speech bubble. Pass the words, or any content (e.g. a tip plus a link). */
@Composable
fun ViaSpeechBubble(
    tail: BubbleTail,
    modifier: Modifier = Modifier,
    color: Color = CraveTheme.extras.cardColor,
    content: @Composable ColumnScope.() -> Unit,
) {
    val tailWidth = 14.dp
    CraveSurface(modifier = modifier, shape = SpeechBubbleShape(tail, tailWidth = tailWidth), color = color) {
        Column(
            Modifier.padding(
                PaddingValues(
                    start = 14.dp + if (tail == BubbleTail.Start) tailWidth else 0.dp,
                    end = 14.dp + if (tail == BubbleTail.End) tailWidth else 0.dp,
                    top = 12.dp,
                    bottom = 12.dp,
                ),
            ),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            content = content,
        )
    }
}

/** Via speaking: avatar + speech bubble. Use for tips, quiz prompts and guidance. */
@Composable
fun ViaSays(message: String, modifier: Modifier = Modifier, avatarSize: Dp = 56.dp) {
    Row(modifier, verticalAlignment = Alignment.Bottom) {
        ViaMascot(avatarSize)
        Spacer(Modifier.width(6.dp))
        ViaSpeechBubble(BubbleTail.Start, Modifier.weight(1f)) {
            Text(message, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

/** Empty / no-results / error state starring a full-body Via. Always offer a next step. */
@Composable
fun ViaEmptyState(
    title: String,
    body: String,
    actionLabel: String,
    onAction: () -> Unit,
    modifier: Modifier = Modifier,
    pose: ViaPose = ViaPose.Thinking,
) {
    Column(
        modifier = modifier.fillMaxWidth().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        ViaFigure(pose, height = 180.dp)
        Text(title, style = MaterialTheme.typography.headlineSmall, textAlign = TextAlign.Center)
        Text(
            body,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
        )
        Spacer(Modifier.height(4.dp))
        CraveButton(actionLabel, onClick = onAction)
    }
}

/** About 30% of the window height, kept between a phone-landscape floor and a tablet ceiling. */
@Composable
fun viaHeroHeight(): Dp {
    val window = LocalWindowInfo.current.containerSize
    val height = with(LocalDensity.current) { window.height.toDp() }
    return (height * 0.3f).coerceIn(228.dp, 320.dp)
}

/**
 * The Home hero: a saffron sticker panel with a big Via peeking up from the bottom edge and
 * talking through a speech bubble. Via pops in once per visit; everything else is still.
 *
 * @param headline short greeting, one line on a phone.
 * @param bubble what Via says, plus at most one small action under it.
 * @param actions an optional row under the bubble (one button, or a button and a text link).
 */
@Composable
fun ViaHero(
    headline: String,
    modifier: Modifier = Modifier,
    pose: ViaPose = ViaPose.Hello,
    minHeight: Dp = viaHeroHeight(),
    actions: (@Composable () -> Unit)? = null,
    bubble: @Composable ColumnScope.() -> Unit,
) {
    val cs = MaterialTheme.colorScheme
    // Via is sized from the hero and bleeds ~12% past the bottom edge, so it reads as peeking up.
    val viaHeight = minHeight * 0.86f
    val viaWidth = viaHeight * POSE_ASPECT
    val bleed = viaHeight * 0.12f
    var played by rememberSaveable { mutableStateOf(false) }
    // Previews and screenshots never run effects, so Via starts fully shown there.
    val still = LocalInspectionMode.current
    val pop = remember { Animatable(if (played || still) 1f else 0f) }
    LaunchedEffect(Unit) {
        if (!played) {
            pop.animateTo(1f, spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow))
            played = true
        }
    }
    CraveSurface(
        modifier = modifier.fillMaxWidth(),
        color = cs.secondaryContainer,
        contentColor = cs.onSecondaryContainer,
        hardShadow = false,
    ) {
        Box(Modifier.fillMaxWidth().heightIn(min = minHeight)) {
            ViaFigure(
                pose,
                height = viaHeight,
                contentDescription = pose.description,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset(x = (-8).dp, y = bleed)
                    .graphicsLayer {
                        val p = pop.value
                        alpha = p.coerceIn(0f, 1f)
                        scaleX = 0.8f + 0.2f * p
                        scaleY = 0.8f + 0.2f * p
                        translationY = (1f - p) * 24.dp.toPx()
                        transformOrigin = androidx.compose.ui.graphics.TransformOrigin(0.5f, 1f)
                    },
            )
            Column(
                Modifier.fillMaxWidth().padding(start = 20.dp, top = 20.dp, bottom = 20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                // Via's head sits below the headline row, so the greeting can use the full width.
                Text(headline, style = MaterialTheme.typography.headlineSmall, modifier = Modifier.padding(end = 20.dp))
                Column(
                    Modifier.fillMaxWidth().padding(end = viaWidth * 0.62f),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    ViaSpeechBubble(BubbleTail.End, Modifier.fillMaxWidth(), content = bubble)
                    if (actions != null) actions()
                }
            }
        }
    }
}

// ---------------------------------------------------------------------------------------------
// Previews
// ---------------------------------------------------------------------------------------------

@CravePreviews
@Composable
private fun ViaHeroPreview() = CraveWiseTheme {
    CravePreviewSurface {
        ViaHero(
            headline = "Good evening, chef!",
            minHeight = 240.dp,
            actions = { TextButton(onClick = {}) { Text("Another tip", style = MaterialTheme.typography.labelLarge) } },
        ) {
            Text("Feeding a crowd? Change the servings on any recipe and I'll scale every amount.", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@CravePreviews
@Composable
private fun ViaPosesPreview() = CraveWiseTheme {
    CravePreviewSurface {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.Bottom) {
            ViaMascot(56.dp)
            ViaPose.entries.forEach { ViaFigure(it, height = 96.dp) }
        }
    }
}

@CravePreviews
@Composable
private fun ViaSaysPreview() = CraveWiseTheme {
    CravePreviewSurface {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            ViaSays("Tell me what's in your fridge and I'll find something slurp-worthy!")
            ViaEmptyState("Your basket's looking light", "Add missing ingredients from any recipe.", "Browse recipes", {}, pose = ViaPose.Shopping)
        }
    }
}
