package com.example.skintrade.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.skintrade.ui.screens.*
import com.example.skintrade.viewmodel.UsuarioViewModel

sealed class Rutas(val ruta: String) {
    object Home : Rutas("home")
    object Registro : Rutas("registro")
    object Resumen : Rutas("resumen")
    object Catalogo : Rutas("catalogo")
}

@Composable
fun AppNavigation(navController: NavHostController) {
    val usuarioViewModel: UsuarioViewModel = viewModel() //

    NavHost(navController = navController, startDestination = Rutas.Home.ruta) {
        composable(Rutas.Home.ruta) { HomeScreen(navController) }
        composable(Rutas.Registro.ruta) { RegistroScreen(navController, usuarioViewModel) }
        composable(Rutas.Resumen.ruta) { ResumenScreen(usuarioViewModel) }
        composable(Rutas.Catalogo.ruta) { CatalogoScreen() }
    }
}
