package com.example.skintrade.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.skintrade.viewmodel.UsuarioViewModel
@Composable
fun ResumenScreen(viewModel: UsuarioViewModel = viewModel()) {
    val state = viewModel.uiState.collectAsState().value

    Column(Modifier.padding(16.dp)) {
        Text("Resumen de usuario", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))
        Text("Nombre: ${state.nombre}")
        Text("Correo: ${state.correo}")
        Text("Dirección: ${state.direccion}")
    }
}
