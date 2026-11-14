package com.example.cravewise.ui.designsystem

import android.content.res.Configuration
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Block
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.SignalCellularAlt
import androidx.compose.material.icons.outlined.WarningAmber
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.cravewise.ui.theme.CraveTheme
import com.example.cravewise.ui.theme.Flavor
import kotlin.math.roundToInt

/** Light + dark preview pair. Every design-system component preview must use this. */
@Preview(name = "Light", showBackground = true)
@Preview(name = "Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
annotation class CravePreviews

// ---------------------------------------------------------------------------------------------
// Foundation
// ---------------------------------------------------------------------------------------------

@Composable
fun craveDefaultBorder(): BorderStroke =
    CraveTheme.extras.let { BorderStroke(it.borderWidth, it.borderColor) }

/**
 * The base for every card, button, chip and input. It draws the 2dp ink outline and the solid
 * offset "sticker" shadow, and when clickable the surface slides onto its shadow on press.
 * Build new containers on this instead of Card/Surface so depth stays consistent.
 */
@Composable
fun CraveSurface(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.large,
    color: Color = CraveTheme.extras.cardColor,
    contentColor: Color = contentColorFor(color).takeOrElse { MaterialTheme.colorScheme.onSurface },
    border: BorderStroke? = craveDefaultBorder(),
    hardShadow: Boolean = true,
    enabled: Boolean = true,
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    val extras = CraveTheme.extras
    val offset = if (hardShadow && enabled) extras.hardShadowOffset else 0.dp
    val interaction = remember { MutableInteractionSource() }
    val pressed by interaction.collectIsPressedAsState()
    val press by animateFloatAsState(if (pressed && onClick != null) 1f else 0f, label = "press")

    val depth = if (offset > 0.dp) {
        Modifier
            .padding(end = offset, bottom = offset)
            .drawBehind {
                val o = offset.toPx()
                val outline = shape.createOutline(size, layoutDirection, this)
                translate(o, o) { drawOutline(outline, extras.hardShadowColor) }
            }
            .offset {
                val shift = (offset.toPx() * press).roundToInt()
                IntOffset(shift, shift)
            }
    } else {
        Modifier
    }

    if (onClick != null) {
        Surface(
            onClick = onClick,
            modifier = modifier.then(depth),
            enabled = enabled,
            shape = shape,
            color = color,
            contentColor = contentColor,
            border = border,
            interactionSource = interaction,
            content = content,
        )
    } else {
        Surface(
            modifier = modifier.then(depth),
            shape = shape,
            color = color,
            contentColor = contentColor,
            border = border,
            content = content,
        )
    }
}

// ---------------------------------------------------------------------------------------------
// Buttons
// ---------------------------------------------------------------------------------------------

enum class CraveButtonVariant { Primary, Secondary, Outline }

/** Primary = tomato (one per screen), Secondary = saffron, Outline = quiet/tertiary action. */
@Composable
fun CraveButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: CraveButtonVariant = CraveButtonVariant.Primary,
    icon: ImageVector? = null,
    enabled: Boolean = true,
) {
    val cs = MaterialTheme.colorScheme
    val (container, content) = when (variant) {
        CraveButtonVariant.Primary -> cs.primary to cs.onPrimary
        CraveButtonVariant.Secondary -> cs.secondaryContainer to cs.onSecondaryContainer
        CraveButtonVariant.Outline -> cs.surface to cs.onSurface
    }
    CraveSurface(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier.alpha(if (enabled) 1f else 0.4f),
        shape = CraveTheme.extras.buttonShape,
        color = container,
        contentColor = content,
        hardShadow = variant != CraveButtonVariant.Outline,
    ) {
        Row(
            modifier = Modifier.heightIn(min = 52.dp).padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            if (icon != null) {
                Icon(icon, contentDescription = null, modifier = Modifier.size(20.dp))
                Spacer(Modifier.width(8.dp))
            }
            Text(text, style = MaterialTheme.typography.labelLarge)
        }
    }
}

// ---------------------------------------------------------------------------------------------
// Chips & tags
// ---------------------------------------------------------------------------------------------

/**
 * Selectable filter chip (flavors, cuisines, diets, quiz answers). Selected = saffron + shadow.
 * A [trailingIcon] (e.g. Close on a removable pantry item) replaces the selected check mark.
 */
@Composable
fun CraveChip(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    leading: (@Composable () -> Unit)? = null,
    trailingIcon: ImageVector? = null,
    trailingIconDescription: String? = null,
) {
    val cs = MaterialTheme.colorScheme
    CraveSurface(
        onClick = onClick,
        modifier = modifier,
        shape = CraveTheme.extras.chipShape,
        color = if (selected) cs.secondaryContainer else CraveTheme.extras.cardColor,
        contentColor = if (selected) cs.onSecondaryContainer else cs.onSurface,
        hardShadow = selected,
    ) {
        Row(
            modifier = Modifier.height(36.dp).padding(horizontal = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            when {
                selected && trailingIcon == null -> {
                    Icon(Icons.Filled.Check, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(6.dp))
                }
                leading != null -> {
                    leading()
                    Spacer(Modifier.width(8.dp))
                }
            }
            Text(text, style = MaterialTheme.typography.labelLarge)
            if (trailingIcon != null) {
                Spacer(Modifier.width(6.dp))
                Icon(trailingIcon, contentDescription = trailingIconDescription, modifier = Modifier.size(16.dp))
            }
        }
    }
}

@Composable
fun FlavorChip(flavor: Flavor, selected: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {
    val dot = CraveTheme.extras.flavor[flavor]
    CraveChip(
        text = flavor.label,
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        leading = { Box(Modifier.size(10.dp).clip(CircleShape).background(dot)) },
    )
}

/** Small static tag (diet, cuisine, allergen). Flat on purpose: tags are info, not actions. */
@Composable
fun CraveTag(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.tertiaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onTertiaryContainer,
    icon: ImageVector? = null,
) {
    Surface(modifier = modifier, shape = CraveTheme.extras.chipShape, color = color, contentColor = contentColor) {
        Row(Modifier.padding(horizontal = 10.dp, vertical = 4.dp), verticalAlignment = Alignment.CenterVertically) {
            if (icon != null) {
                Icon(icon, contentDescription = null, modifier = Modifier.size(14.dp))
                Spacer(Modifier.width(4.dp))
            }
            Text(text, style = MaterialTheme.typography.labelMedium)
        }
    }
}

/** Ingredient you have (filled + check) vs. one you're missing (outlined + add). */
@Composable
fun IngredientPill(name: String, have: Boolean, modifier: Modifier = Modifier) {
    val cs = MaterialTheme.colorScheme
    Surface(
        modifier = modifier,
        shape = CraveTheme.extras.chipShape,
        color = if (have) cs.tertiaryContainer else Color.Transparent,
        contentColor = if (have) cs.onTertiaryContainer else cs.onSurfaceVariant,
        border = if (have) null else BorderStroke(1.dp, cs.outline.copy(alpha = 0.6f)),
    ) {
        Row(
            Modifier.padding(start = 8.dp, end = 12.dp, top = 6.dp, bottom = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                if (have) Icons.Filled.Check else Icons.Outlined.Add,
                contentDescription = if (have) "Have" else "Missing",
                modifier = Modifier.size(16.dp),
            )
            Spacer(Modifier.width(6.dp))
            Text(name, style = MaterialTheme.typography.labelLarge)
        }
    }
}

// ---------------------------------------------------------------------------------------------
// Data display
// ---------------------------------------------------------------------------------------------

/** 0–5 chili flames. */
@Composable
fun SpiceMeter(level: Int, modifier: Modifier = Modifier, max: Int = 5, iconSize: Dp = 18.dp) {
    val hot = CraveTheme.extras.flavor.spicy
    val cold = MaterialTheme.colorScheme.outlineVariant
    Row(modifier, horizontalArrangement = Arrangement.spacedBy(1.dp)) {
        repeat(max) { i ->
            Icon(
                Icons.Filled.LocalFireDepartment,
                contentDescription = null,
                tint = if (i < level) hot else cold,
                modifier = Modifier.size(iconSize),
            )
        }
    }
}

/** Horizontal bars for the six flavor scores (0–5). */
@Composable
fun FlavorProfile(scores: Map<Flavor, Int>, modifier: Modifier = Modifier) {
    val extras = CraveTheme.extras
    val track = MaterialTheme.colorScheme.surfaceContainerHighest
    Column(modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Flavor.entries.forEach { flavor ->
            val score = scores[flavor] ?: 0
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(flavor.label, style = MaterialTheme.typography.labelMedium, modifier = Modifier.width(64.dp))
                Box(Modifier.weight(1f).height(10.dp).clip(extras.chipShape).background(track)) {
                    if (score > 0) {
                        Box(
                            Modifier
                                .fillMaxWidth(score / 5f)
                                .height(10.dp)
                                .clip(extras.chipShape)
                                .background(extras.flavor[flavor]),
                        )
                    }
                }
                Text(
                    "$score",
                    style = MaterialTheme.typography.labelMedium,
                    textAlign = TextAlign.End,
                    modifier = Modifier.width(24.dp),
                )
            }
        }
    }
}

/**
 * Allergen summary for a recipe. Non-empty = errorContainer + warning icon (never color alone).
 * Empty = a neutral note that still tells people to check labels: absence is derived from the
 * ingredient list, not guaranteed.
 */
@Composable
fun AllergenNotice(allergens: List<String>, modifier: Modifier = Modifier) {
    val cs = MaterialTheme.colorScheme
    val contains = allergens.isNotEmpty()
    CraveSurface(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        color = if (contains) cs.errorContainer else cs.surfaceContainer,
        contentColor = if (contains) cs.onErrorContainer else cs.onSurfaceVariant,
        hardShadow = false,
    ) {
        Row(Modifier.padding(16.dp), verticalAlignment = Alignment.Top) {
            Icon(
                if (contains) Icons.Outlined.WarningAmber else Icons.Outlined.Info,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
            )
            Spacer(Modifier.width(12.dp))
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                if (contains) {
                    Text("Contains allergens", style = MaterialTheme.typography.titleMedium)
                    Text(allergens.joinToString(" · "), style = MaterialTheme.typography.bodyLarge)
                    Text(
                        "Based on the listed ingredients. Always check packaging.",
                        style = MaterialTheme.typography.bodySmall,
                    )
                } else {
                    Text("No common allergens listed", style = MaterialTheme.typography.titleMedium)
                    Text(
                        "None of the 14 major allergens appear in the ingredient list. Packaged items can still contain them, so check labels.",
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
            }
        }
    }
}

/**
 * Shown on a recipe that breaks the user's food profile (reachable only via an old link or a
 * favorite, since lists hide these). Safety info: errorContainer + block icon, never color alone.
 */
@Composable
fun ProfileConflictNotice(reasons: List<String>, modifier: Modifier = Modifier) {
    val cs = MaterialTheme.colorScheme
    CraveSurface(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        color = cs.errorContainer,
        contentColor = cs.onErrorContainer,
        hardShadow = false,
    ) {
        Row(Modifier.padding(16.dp), verticalAlignment = Alignment.Top) {
            Icon(Icons.Outlined.Block, contentDescription = null, modifier = Modifier.size(24.dp))
            Spacer(Modifier.width(12.dp))
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text("Doesn't fit your profile", style = MaterialTheme.typography.titleMedium)
                reasons.forEach { Text("• $it", style = MaterialTheme.typography.bodyLarge) }
            }
        }
    }
}

@Composable
fun MatchBadge(percent: Int, modifier: Modifier = Modifier) {
    CraveSurface(
        modifier = modifier,
        shape = CraveTheme.extras.chipShape,
        color = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        hardShadow = false,
    ) {
        Text(
            "$percent% match",
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
        )
    }
}

/** Backdrop pattern for [RecipeArt]; picked from the art seed so neighbouring cards differ. */
enum class RecipeArtPattern { Dots, Stripes, Rays }

/**
 * Placeholder dish art until recipes have photos: a flavor-tinted backdrop with a printed
 * pattern and an ink-outlined "plate" sticker holding the dish icon. [seed] (e.g. the recipe id's
 * hash) picks the pattern and its offset, so the same recipe always looks the same.
 */
@Composable
fun RecipeArt(
    icon: ImageVector,
    accent: Color,
    modifier: Modifier = Modifier,
    seed: Int = 0,
    plateSize: Dp = 64.dp,
) {
    val pattern = RecipeArtPattern.entries[Math.floorMod(seed, RecipeArtPattern.entries.size)]
    val shift = Math.floorMod(seed / RecipeArtPattern.entries.size, 7) / 7f
    Box(
        modifier
            .clipToBounds()
            .background(accent.copy(alpha = 0.22f))
            .drawBehind { drawArtPattern(pattern, accent.copy(alpha = 0.38f), shift) },
        contentAlignment = Alignment.Center,
    ) {
        CraveSurface(shape = CircleShape, color = accent, hardShadow = true) {
            Box(Modifier.size(plateSize), contentAlignment = Alignment.Center) {
                // Flavor accents are bright in both themes, like saffron, so they take saffron's ink.
                Icon(
                    icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier.size(plateSize * 0.56f),
                )
            }
        }
    }
}

private fun DrawScope.drawArtPattern(pattern: RecipeArtPattern, color: Color, shift: Float) {
    when (pattern) {
        RecipeArtPattern.Dots -> {
            val step = 18.dp.toPx()
            val r = 3.dp.toPx()
            var row = 0
            var y = step * shift
            while (y < size.height + step) {
                var x = if (row % 2 == 0) 0f else step / 2
                while (x < size.width + step) {
                    drawCircle(color, r, Offset(x, y))
                    x += step
                }
                y += step
                row++
            }
        }
        RecipeArtPattern.Stripes -> {
            val step = 22.dp.toPx()
            val w = 6.dp.toPx()
            var x = -size.height + step * shift
            while (x < size.width + step) {
                drawLine(color, Offset(x, size.height), Offset(x + size.height, 0f), strokeWidth = w)
                x += step
            }
        }
        RecipeArtPattern.Rays -> {
            val c = center
            val reach = size.maxDimension
            val rays = 16
            val sweep = 360f / rays
            for (i in 0 until rays step 2) {
                drawArc(
                    color = color,
                    startAngle = i * sweep + shift * sweep,
                    sweepAngle = sweep,
                    useCenter = true,
                    topLeft = Offset(c.x - reach, c.y - reach),
                    size = Size(reach * 2, reach * 2),
                )
            }
        }
    }
}

/**
 * A recipe photo cropped to fill, over its [RecipeArt]. The art shows while the photo decodes and
 * stays if it fails, so a broken file never leaves an empty box.
 */
@Composable
fun RecipePhotoOrArt(
    photo: Any?,
    icon: ImageVector,
    accent: Color,
    seed: Int,
    modifier: Modifier = Modifier,
    plateSize: Dp = 64.dp,
) {
    Box(modifier) {
        RecipeArt(icon, accent, Modifier.matchParentSize(), seed = seed, plateSize = plateSize)
        if (photo != null) {
            AsyncImage(
                model = photo,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize(),
            )
        }
    }
}

/**
 * Recipe card for browse, pantry results and search. Shows the downloaded [photo] when there is
 * one, else the [RecipeArt] placeholder.
 */
@Composable
fun RecipeCard(
    title: String,
    cuisine: String,
    minutes: Int,
    difficulty: String,
    spiceLevel: Int,
    art: ImageVector,
    accent: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    matchPercent: Int? = null,
    /** Seeds [RecipeArt]'s pattern, e.g. the recipe id's hash. */
    artSeed: Int = 0,
    /** A downloaded photo (any Coil model, e.g. a File). Null keeps the [RecipeArt] placeholder. */
    photo: Any? = null,
    /**
     * Pass 2 for cards side by side in a horizontal row (shelves, favorites strip): every card then
     * reserves two title lines, so the row is even and the meta lines line up.
     */
    titleMinLines: Int = 1,
    /** Extra rows under the meta line, e.g. missing-ingredient pills on pantry results. */
    footer: (@Composable ColumnScope.() -> Unit)? = null,
) {
    val extras = CraveTheme.extras
    CraveSurface(onClick = onClick, modifier = modifier.fillMaxWidth()) {
        Column {
            Box(Modifier.fillMaxWidth().height(120.dp)) {
                RecipePhotoOrArt(photo, art, accent, artSeed, Modifier.matchParentSize())
                if (matchPercent != null) {
                    MatchBadge(matchPercent, Modifier.align(Alignment.TopStart).padding(12.dp))
                }
            }
            HorizontalDivider(thickness = extras.borderWidth, color = extras.borderColor)
            Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(cuisine, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                Text(
                    title,
                    style = MaterialTheme.typography.titleLarge,
                    minLines = titleMinLines,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    MetaItem(Icons.Outlined.Schedule, "$minutes min")
                    MetaItem(Icons.Outlined.SignalCellularAlt, difficulty)
                    Spacer(Modifier.weight(1f))
                    SpiceMeter(spiceLevel, iconSize = 14.dp)
                }
                if (footer != null) {
                    Spacer(Modifier.height(6.dp))
                    footer()
                }
            }
        }
    }
}

@Composable
private fun MetaItem(icon: ImageVector, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, contentDescription = null, modifier = Modifier.size(16.dp), tint = MaterialTheme.colorScheme.onSurfaceVariant)
        Spacer(Modifier.width(4.dp))
        Text(text, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}

// ---------------------------------------------------------------------------------------------
// Inputs
// ---------------------------------------------------------------------------------------------

@Composable
fun CraveSearchField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Try \"something salty\"",
    /** Called on the keyboard's action key. Null keeps the default (Enter does nothing). */
    onSubmit: (() -> Unit)? = null,
    leadingIcon: ImageVector = Icons.Outlined.Search,
    /** Non-null shows a clear (×) button while there's text. */
    onClear: (() -> Unit)? = null,
    imeAction: ImeAction = ImeAction.Done,
) {
    val cs = MaterialTheme.colorScheme
    CraveSurface(modifier = modifier.fillMaxWidth(), shape = CraveTheme.extras.buttonShape) {
        Row(Modifier.height(56.dp).padding(horizontal = 18.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(leadingIcon, contentDescription = null, tint = cs.onSurfaceVariant)
            Spacer(Modifier.width(12.dp))
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                keyboardOptions = if (onSubmit != null) KeyboardOptions(imeAction = imeAction) else KeyboardOptions.Default,
                keyboardActions = onSubmit?.let { submit -> KeyboardActions(onDone = { submit() }, onSearch = { submit() }) }
                    ?: KeyboardActions.Default,
                textStyle = MaterialTheme.typography.bodyLarge.copy(color = cs.onSurface),
                cursorBrush = SolidColor(cs.primary),
                modifier = Modifier.weight(1f),
                decorationBox = { inner ->
                    Box(contentAlignment = Alignment.CenterStart) {
                        if (value.isEmpty()) {
                            Text(placeholder, style = MaterialTheme.typography.bodyLarge, color = cs.onSurfaceVariant)
                        }
                        inner()
                    }
                },
            )
            if (onClear != null && value.isNotEmpty()) {
                IconButton(onClick = onClear, modifier = Modifier.offset(x = 12.dp)) {
                    Icon(Icons.Outlined.Close, contentDescription = "Clear search", tint = cs.onSurfaceVariant)
                }
            }
        }
    }
}

// ---------------------------------------------------------------------------------------------
// Layout helpers
// ---------------------------------------------------------------------------------------------

@Composable
fun SectionHeader(
    title: String,
    modifier: Modifier = Modifier,
    eyebrow: String? = null,
    actionLabel: String? = null,
    onAction: () -> Unit = {},
) {
    Row(modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom) {
        Column(Modifier.weight(1f)) {
            if (eyebrow != null) {
                Text(eyebrow, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary)
            }
            Text(title, style = MaterialTheme.typography.headlineSmall)
        }
        if (actionLabel != null) {
            TextButton(onClick = onAction) { Text(actionLabel, style = MaterialTheme.typography.labelLarge) }
        }
    }
}

// Via the panda lives in ViaComponents.kt.
