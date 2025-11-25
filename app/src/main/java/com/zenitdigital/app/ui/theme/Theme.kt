package com.zenitdigital.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush

private val DarkColors = darkColorScheme(
    primary = PrimaryBlue,
    onPrimary = onPrimary,
    secondary = SecondaryCyan,
    background = Midnight,
    surface = DeepSurface,
    onSurface = ColorPalettes.onSurface,
    tertiary = AccentGreen
)

private val LightColors = lightColorScheme(
    primary = PrimaryBlue,
    onPrimary = onPrimary,
    secondary = SecondaryCyan,
    background = ColorPalettes.surfaceLight,
    surface = ColorPalettes.surfaceLight,
    onSurface = ColorPalettes.onSurface,
    tertiary = AccentGreen
)

object ColorPalettes {
    val surfaceLight = androidx.compose.ui.graphics.Color(0xFFF2F6FA)
    val onSurface = androidx.compose.ui.graphics.Color(0xFFE5ECF3)
}

val onPrimary = androidx.compose.ui.graphics.Color.White

val heroGradient: Brush
    @Composable
    get() = Brush.linearGradient(
        listOf(PrimaryBlue, SecondaryCyan)
    )

@Composable
fun ZenitDigitalTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme: ColorScheme = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colorScheme,
        typography = ZenTypography,
        content = content
    )
}
