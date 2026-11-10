package com.example.cravewise.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// "Noodle Pop" palette: tomato red, saffron yellow and ink-navy outlines on a peach-cream canvas.
// Only this file should contain raw hex values. Everything else reads MaterialTheme.colorScheme
// or CraveTheme.extras.

internal val InkNavy = Color(0xFF1E1B2E)
internal val PaperCream = Color(0xFFF6EDE4)
internal val Saffron = Color(0xFFFFC233)

/** Flat background baked into the Via artwork (res/drawable-nodpi/via.png). */
internal val ViaBackdrop = Color(0xFFF5E2D2)

internal val LightColors: ColorScheme = lightColorScheme(
    primary = Color(0xFFD23B1F),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFFFDAD2),
    onPrimaryContainer = Color(0xFF3D0700),
    secondary = Saffron,
    onSecondary = InkNavy,
    secondaryContainer = Saffron,
    onSecondaryContainer = InkNavy,
    tertiary = Color(0xFF3442A6),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFDEE1FF),
    onTertiaryContainer = Color(0xFF0B1450),
    background = Color(0xFFFFF3E6),
    onBackground = InkNavy,
    surface = Color(0xFFFFF3E6),
    onSurface = InkNavy,
    surfaceVariant = Color(0xFFF5E2D2),
    onSurfaceVariant = Color(0xFF4E4757),
    surfaceContainerLowest = Color(0xFFFFFFFF),
    surfaceContainerLow = Color(0xFFFFF9F2),
    surfaceContainer = Color(0xFFFBEBDD),
    surfaceContainerHigh = Color(0xFFF5E2D2),
    surfaceContainerHighest = Color(0xFFEFD9C6),
    outline = InkNavy,
    outlineVariant = Color(0xFFE5CFBC),
    error = Color(0xFFBA1A1A),
)

internal val DarkColors: ColorScheme = darkColorScheme(
    primary = Color(0xFFFF8A70),
    onPrimary = Color(0xFF4A0B00),
    primaryContainer = Color(0xFF8E2410),
    onPrimaryContainer = Color(0xFFFFDAD2),
    secondary = Saffron,
    onSecondary = InkNavy,
    secondaryContainer = Saffron,
    onSecondaryContainer = InkNavy,
    tertiary = Color(0xFFBAC3FF),
    onTertiary = Color(0xFF16237A),
    tertiaryContainer = Color(0xFF2E3B95),
    onTertiaryContainer = Color(0xFFDEE1FF),
    background = Color(0xFF16141F),
    onBackground = PaperCream,
    surface = Color(0xFF16141F),
    onSurface = PaperCream,
    surfaceVariant = Color(0xFF3B3748),
    onSurfaceVariant = Color(0xFFCBC3D6),
    surfaceContainerLowest = Color(0xFF110F18),
    surfaceContainerLow = Color(0xFF1D1A28),
    surfaceContainer = Color(0xFF221F2E),
    surfaceContainerHigh = Color(0xFF2C2939),
    surfaceContainerHighest = Color(0xFF373344),
    outline = PaperCream,
    outlineVariant = Color(0xFF3B3748),
    error = Color(0xFFFFB4AB),
)

internal val PopFlavorColors = FlavorColors(
    salty = Color(0xFF4DA3FF),
    sweet = Color(0xFFFF7EB6),
    sour = Color(0xFFC6E03A),
    bitter = Color(0xFF6B8F3A),
    umami = Color(0xFFB0662E),
    spicy = Color(0xFFFF5A3C),
)
