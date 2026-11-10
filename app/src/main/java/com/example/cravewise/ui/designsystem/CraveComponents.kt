package com.example.cravewise.ui.designsystem

import android.content.res.Configuration
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.SignalCellularAlt
import androidx.compose.material.icons.outlined.WarningAmber
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
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

/** Selectable filter chip (flavors, cuisines, diets, quiz answers). Selected = saffron + shadow. */
@Composable
fun CraveChip(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    leading: (@Composable () -> Unit)? = null,
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
                selected -> {
                    Icon(Icons.Filled.Check, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(6.dp))
                }
                leading != null -> {
                    leading()
                    Spacer(Modifier.width(8.dp))
                }
            }
            Text(text, style = MaterialTheme.typography.labelLarge)
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

/**
 * Recipe card for browse, pantry results and search. The tinted icon tile stands in for a photo
 * until the dataset lands; swap it for an AsyncImage then and keep the divider below it.
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
) {
    val extras = CraveTheme.extras
    CraveSurface(onClick = onClick, modifier = modifier.fillMaxWidth()) {
        Column {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(Brush.linearGradient(listOf(accent.copy(alpha = 0.40f), accent.copy(alpha = 0.12f)))),
            ) {
                Icon(art, contentDescription = null, tint = accent, modifier = Modifier.size(56.dp).align(Alignment.Center))
                if (matchPercent != null) {
                    MatchBadge(matchPercent, Modifier.align(Alignment.TopStart).padding(12.dp))
                }
            }
            HorizontalDivider(thickness = extras.borderWidth, color = extras.borderColor)
            Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(cuisine, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                Text(title, style = MaterialTheme.typography.titleLarge, maxLines = 2, overflow = TextOverflow.Ellipsis)
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    MetaItem(Icons.Outlined.Schedule, "$minutes min")
                    MetaItem(Icons.Outlined.SignalCellularAlt, difficulty)
                    Spacer(Modifier.weight(1f))
                    SpiceMeter(spiceLevel, iconSize = 14.dp)
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
) {
    val cs = MaterialTheme.colorScheme
    CraveSurface(modifier = modifier.fillMaxWidth(), shape = CraveTheme.extras.buttonShape) {
        Row(Modifier.height(56.dp).padding(horizontal = 18.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Outlined.Search, contentDescription = null, tint = cs.onSurfaceVariant)
            Spacer(Modifier.width(12.dp))
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
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

// ---------------------------------------------------------------------------------------------
// Via the panda
// ---------------------------------------------------------------------------------------------

/** Via, framed on the artwork's own backdrop color with the ink outline. */
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

/** Via speaking: avatar + speech bubble. Use for tips, quiz prompts and guidance. */
@Composable
fun ViaSays(message: String, modifier: Modifier = Modifier, avatarSize: Dp = 56.dp) {
    Row(modifier, verticalAlignment = Alignment.Bottom) {
        ViaMascot(avatarSize)
        Spacer(Modifier.width(10.dp))
        CraveSurface(
            shape = MaterialTheme.shapes.large.copy(bottomStart = CornerSize(4.dp)),
            modifier = Modifier.weight(1f),
        ) {
            Text(message, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(14.dp))
        }
    }
}

/** Empty / no-results state starring Via. Always offer a next step. */
@Composable
fun ViaEmptyState(
    title: String,
    body: String,
    actionLabel: String,
    onAction: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        ViaMascot(160.dp)
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
