package com.example.skintrade.ui.utils

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.window.layout.WindowMetricsCalculator

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun rememberWindowSizeClass(): String {
    val context = LocalContext.current
    val windowMetrics = WindowMetricsCalculator.getOrCreate().computeCurrentWindowMetrics(context)
    val widthDp = with(LocalDensity.current) { windowMetrics.bounds.width() / density }

    return when {
        widthDp < 600 -> "Compacta"
        widthDp < 840 -> "Mediana"
        else -> "Expandida"
    }
}
