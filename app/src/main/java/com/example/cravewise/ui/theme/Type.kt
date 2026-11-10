package com.example.cravewise.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Uses the platform sans-serif so previews render offline. To brand it, bundle a font in
// res/font (suggested: Bricolage Grotesque or Baloo 2 for headings, Inter for body) and swap
// the two families below. Nothing else needs to change.
private val HeadingFamily = FontFamily.SansSerif
private val BodyFamily = FontFamily.SansSerif

private fun TextStyle.heading() =
    copy(fontFamily = HeadingFamily, fontWeight = FontWeight.Black, letterSpacing = (-0.5).sp)

private fun TextStyle.title() = copy(fontFamily = HeadingFamily, fontWeight = FontWeight.ExtraBold)
private fun TextStyle.body() = copy(fontFamily = BodyFamily)
private fun TextStyle.label() = copy(fontFamily = BodyFamily, fontWeight = FontWeight.Bold)

internal val CraveTypography: Typography = Typography().run {
    Typography(
        displayLarge = displayLarge.heading(),
        displayMedium = displayMedium.heading(),
        displaySmall = displaySmall.heading(),
        headlineLarge = headlineLarge.heading(),
        headlineMedium = headlineMedium.heading(),
        headlineSmall = headlineSmall.heading(),
        titleLarge = titleLarge.title(),
        titleMedium = titleMedium.title(),
        titleSmall = titleSmall.title(),
        bodyLarge = bodyLarge.body(),
        bodyMedium = bodyMedium.body(),
        bodySmall = bodySmall.body(),
        labelLarge = labelLarge.label(),
        labelMedium = labelMedium.label(),
        labelSmall = labelSmall.label(),
    )
}
