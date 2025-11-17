package com.example.skintrade.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.skintrade.viewmodel.UsuarioViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResumenScreen(viewModel: UsuarioViewModel = viewModel()) {
    val usuario by viewModel.usuario.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.cargarUltimoUsuario()
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Resumen de usuario") })
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
            }
        }
    }
}

