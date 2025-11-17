package com.example.skintrade.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color   // 👈 ESTA ES LA IMPORTANTE
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = PurplePrimary,
    secondary = PurpleDark,
    tertiary = PurpleLight,
    background = GraySurface,
    surface = WhitePure,
    onPrimary = WhitePure,
    onSecondary = WhitePure,
    onBackground = TextPrimary,
    onSurface = TextPrimary
)

private val DarkColorScheme = darkColorScheme(
    primary = PurpleDark,
    secondary = PurplePrimary,
    tertiary = PurpleLight,
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    onPrimary = WhitePure,
    onSecondary = WhitePure,
    onBackground = WhitePure,
    onSurface = WhitePure
)

@Composable
fun SkinTradeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
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

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
