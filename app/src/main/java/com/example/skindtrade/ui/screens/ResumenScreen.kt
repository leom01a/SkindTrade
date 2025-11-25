package com.example.skintrade.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.skintrade.viewmodel.DogViewModel
import com.example.skintrade.viewmodel.UsuarioViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResumenScreen(
    usuarioViewModel: UsuarioViewModel = viewModel(),
    dogViewModel: DogViewModel = viewModel()
) {
    val usuario by usuarioViewModel.usuario.collectAsState()
    val dogImageUrl by dogViewModel.imageUrl.collectAsState()

    // Al entrar a la pantalla:
    // 1) carga el último usuario de Room
    // 2) pide una imagen a la API externa
    LaunchedEffect(Unit) {
        usuarioViewModel.cargarUltimoUsuario()
        dogViewModel.cargarPerro()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Resumen de usuario") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (usuario == null) {
                Text("No hay usuario registrado.")
            } else {
                Text("Nombre: ${usuario?.nombre}")
                Text("Correo: ${usuario?.correo}")
                Text("Dirección: ${usuario?.direccion}")
                Text("Rol: ${usuario?.rol}")
                Spacer(Modifier.height(24.dp))

                Text("Perro aleatorio :")
                Spacer(Modifier.height(12.dp))

                if (dogImageUrl != null) {
                    AsyncImage(
                        model = dogImageUrl,
                        contentDescription = "Perro aleatorio",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )
                } else {
                    Text("Cargando imagen...")
                }
            }
        }
    }
}
