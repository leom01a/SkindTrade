package com.example.skintrade.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.skintrade.navigation.Rutas
import com.example.skintrade.viewmodel.UsuarioViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistroScreen(
    navController: NavController,
    viewModel: UsuarioViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var clave by remember { mutableStateOf("") }   // solo visual
    var direccion by remember { mutableStateOf("") }
    var esDueno by remember { mutableStateOf(false) }

    // Rol según el switch
    val rol = if (esDueno) "DUENO" else "CLIENTE"

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Registro de usuario") })
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Nombre
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(12.dp))

            // Correo
            OutlinedTextField(
                value = correo,
                onValueChange = { correo = it },
                label = { Text("Correo electrónico") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(12.dp))

            // Contraseña (no se guarda aún)
            OutlinedTextField(
                value = clave,
                onValueChange = { clave = it },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(12.dp))

            // Dirección
            OutlinedTextField(
                value = direccion,
                onValueChange = { direccion = it },
                label = { Text("Dirección") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(20.dp))

            // Switch de rol
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("¿Eres dueño?")
                Spacer(modifier = Modifier.width(8.dp))
                Switch(
                    checked = esDueno,
                    onCheckedChange = { esDueno = it }
                )
            }

            Spacer(Modifier.height(30.dp))

            // Botón Guardar
            Button(
                onClick = {
                    if (nombre.isNotBlank() && correo.isNotBlank() && direccion.isNotBlank()) {
                        viewModel.guardarUsuario(nombre, correo, direccion, rol)
                        navController.navigate(Rutas.Resumen.ruta)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp)
            ) {
                Text("Guardar")
            }
        }
    }
}

