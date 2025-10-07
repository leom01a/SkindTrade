package com.example.skintrade.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.skintrade.navigation.Rutas
import com.example.skintrade.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("SkinTrade CS2") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Imagen de ejemplo
            Image(
                painter = painterResource(id = R.drawable.skin_example),
                contentDescription = "Skin"
            )

            Spacer(Modifier.height(12.dp))

            // Botón para navegar
            Button(onClick = { navController.navigate(Rutas.Registro.ruta) }) {
                Text("Registrar usuario")
            }
        }
    }
}
