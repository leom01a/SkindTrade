package com.example.skintrade.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.skintrade.ui.screens.*

sealed class Rutas(val ruta: String) {
    object Home : Rutas("home")
    object Registro : Rutas("registro")
    object Resumen : Rutas("resumen")
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Rutas.Home.ruta) {
        composable(Rutas.Home.ruta) { HomeScreen(navController) }
        composable(Rutas.Registro.ruta) { RegistroScreen(navController) }
        composable(Rutas.Resumen.ruta) { ResumenScreen() }
    }
}
