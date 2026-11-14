package com.example.cravewise.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cravewise.R

/** The six flavor axes carried by every recipe (scores 0–5). */
enum class Flavor(val label: String) {
    Salty("Salty"), Sweet("Sweet"), Sour("Sour"), Bitter("Bitter"), Umami("Umami"), Spicy("Spicy"),
}

@Immutable
data class FlavorColors(
    val salty: Color,
    val sweet: Color,
    val sour: Color,
    val bitter: Color,
    val umami: Color,
    val spicy: Color,
) {
    operator fun get(flavor: Flavor): Color = when (flavor) {
        Flavor.Salty -> salty
        Flavor.Sweet -> sweet
        Flavor.Sour -> sour
        Flavor.Bitter -> bitter
        Flavor.Umami -> umami
        Flavor.Spicy -> spicy
    }
}

/**
 * Brand tokens Material 3 doesn't model. Read them through [CraveTheme.extras].
 * The "sticker" look is one border weight plus one solid offset shadow, applied by CraveSurface.
 */
@Immutable
data class CraveExtras(
    @param:DrawableRes val mascot: Int,
    val mascotBackdrop: Color,
    val mascotShape: Shape,
    val buttonShape: Shape,
    val chipShape: Shape,
    val borderWidth: Dp,
    val borderColor: Color,
    val hardShadowOffset: Dp,
    val hardShadowColor: Color,
    val cardColor: Color,
    val flavor: FlavorColors,
)

val LocalCraveExtras = staticCompositionLocalOf<CraveExtras> {
    error("CraveExtras not provided. Wrap content in CraveWiseTheme.")
}

/** Access point for brand tokens, mirroring `MaterialTheme.colorScheme`. */
object CraveTheme {
    val extras: CraveExtras
        @Composable @ReadOnlyComposable
        get() = LocalCraveExtras.current
}

internal val CraveShapes = Shapes(
    extraSmall = RoundedCornerShape(8.dp),
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(22.dp),
    extraLarge = RoundedCornerShape(28.dp),
)

private fun extrasFor(colors: ColorScheme, dark: Boolean) = CraveExtras(
    mascot = R.drawable.via_avatar,
    // Same saffron disc as the launcher icon, so the avatar reads as the app's face.
    mascotBackdrop = colors.secondaryContainer,
    mascotShape = RoundedCornerShape(28.dp),
    buttonShape = RoundedCornerShape(16.dp),
    chipShape = CircleShape,
    borderWidth = 2.dp,
    borderColor = colors.outline,
    hardShadowOffset = 4.dp,
    hardShadowColor = colors.outline,
    cardColor = if (dark) colors.surfaceContainerHigh else colors.surfaceContainerLowest,
    flavor = PopFlavorColors,
)

/**
 * CraveWise "Noodle Pop" theme. Brand colors are fixed on purpose (no dynamic color), so food
 * imagery and Via always sit on the same palette.
 */
@Composable
fun CraveWiseTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) DarkColors else LightColors
    MaterialTheme(colorScheme = colors, typography = CraveTypography, shapes = CraveShapes) {
        CompositionLocalProvider(LocalCraveExtras provides extrasFor(colors, darkTheme), content = content)
    }
}
