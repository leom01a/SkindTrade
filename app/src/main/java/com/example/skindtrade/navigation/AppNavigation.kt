package com.example.skintrade.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.skintrade.ui.screens.*
import com.example.skintrade.viewmodel.UsuarioViewModel
import com.example.skintrade.viewmodel.CartViewModel

sealed class Rutas(val ruta: String) {
    object Home : Rutas("home")
    object Registro : Rutas("registro")
    object Resumen : Rutas("resumen")
    object Catalogo : Rutas("catalogo")
    object Carrito : Rutas("carrito")
}

@Composable
fun AppNavigation(navController: NavHostController) {

    // ViewModels compartidos entre pantallas
    val usuarioViewModel: UsuarioViewModel = viewModel()
    val cartViewModel: CartViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Rutas.Home.ruta
    ) {
        composable(Rutas.Home.ruta) {
            HomeScreen(navController)
        }

        composable(Rutas.Registro.ruta) {
            RegistroScreen(navController, usuarioViewModel)
        }

        composable(Rutas.Resumen.ruta) {
            ResumenScreen(usuarioViewModel)
        }

        composable(Rutas.Catalogo.ruta) {
            CatalogoScreen(
                cartViewModel = cartViewModel
            )
        }

        composable(Rutas.Carrito.ruta) {
            CarritoScreen(
                cartViewModel = cartViewModel
            )
        }
    }
}
