package com.learncompose.drawingpractice.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// Màu không có slot tương ứng trong Material colorScheme.
@Immutable
data class ExtendedColors(
    val screenBackground: Color,
    val headerGradientStart: Color,
    val headerGradientEnd: Color,
    val textLabel: Color,
)

private val LightExtendedColors = ExtendedColors(
    screenBackground = ScreenBackgroundLight,
    headerGradientStart = HeaderGradientStartLight,
    headerGradientEnd = HeaderGradientEndLight,
    textLabel = TextLabel,
)

private val DarkExtendedColors = ExtendedColors(
    screenBackground = ScreenBackgroundDark,
    headerGradientStart = HeaderGradientStartDark,
    headerGradientEnd = HeaderGradientEndDark,
    textLabel = TextLabelDark,
)

val LocalExtendedColors = staticCompositionLocalOf { LightExtendedColors }

val MaterialTheme.extendedColors: ExtendedColors
    @Composable
    @ReadOnlyComposable
    get() = LocalExtendedColors.current

private val DarkColorScheme = darkColorScheme(
    primary = BrandBlueLight,
    onPrimary = OnBrandDark,
    surface = SurfaceDark,
    onSurface = TextPrimaryDark,
    onSurfaceVariant = TextSecondaryDark,
    background = SurfaceDark,
    onBackground = TextPrimaryDark,
    error = DangerRedDark,
)

private val LightColorScheme = lightColorScheme(
    primary = BrandBlue,
    onPrimary = OnBrand,
    surface = SurfaceLight,
    onSurface = TextPrimary,
    onSurfaceVariant = TextSecondary,
    background = SurfaceLight,
    onBackground = TextPrimary,
    error = DangerRed,
)

@Composable
fun DrawingPracticeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Tắt màu theo wallpaper để mọi máy dùng cùng brand (BrandBlue).
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val extendedColors = if (darkTheme) DarkExtendedColors else LightExtendedColors

    CompositionLocalProvider(LocalExtendedColors provides extendedColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}