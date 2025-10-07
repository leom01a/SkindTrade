package com.example.skintrade.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.skintrade.navigation.Rutas
import com.example.skintrade.viewmodel.UsuarioViewModel

@Composable
fun RegistroScreen(navController: NavController, viewModel: UsuarioViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val state by viewModel.uiState.collectAsState()
    val errores by viewModel.errores.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Registro de usuario", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = state.nombre,
            onValueChange = { viewModel.actualizarCampo("nombre", it) },
            label = { Text("Nombre") },
            isError = errores.nombre != null,
            supportingText = { errores.nombre?.let { Text(it) } }
        )

        OutlinedTextField(
            value = state.correo,
            onValueChange = { viewModel.actualizarCampo("correo", it) },
            label = { Text("Correo") },
            isError = errores.correo != null,
            supportingText = { errores.correo?.let { Text(it) } }
        )

        OutlinedTextField(
            value = state.clave,
            onValueChange = { viewModel.actualizarCampo("clave", it) },
            label = { Text("Clave") },
            isError = errores.clave != null,
            supportingText = { errores.clave?.let { Text(it) } }
        )

        OutlinedTextField(
            value = state.direccion,
            onValueChange = { viewModel.actualizarCampo("direccion", it) },
            label = { Text("Dirección") },
            isError = errores.direccion != null,
            supportingText = { errores.direccion?.let { Text(it) } }
        )

        Spacer(Modifier.height(16.dp))
        Button(onClick = {
            if (viewModel.validarFormulario()) {
                navController.navigate(Rutas.Resumen.ruta)
            }
        }) {
            Text("Guardar")
        }
    }
}
