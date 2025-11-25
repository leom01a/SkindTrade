package com.example.skintrade.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.skintrade.R
import com.example.skintrade.navigation.Rutas

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "SkinTrade CS2",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )
                    )
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.skin_example),
                contentDescription = "Skin"
            )

            Spacer(Modifier.height(12.dp))

            Button(onClick = { navController.navigate(Rutas.Registro.ruta) }) {
                Text("Registrar usuario", style = MaterialTheme.typography.bodyLarge)
            }

            Spacer(Modifier.height(12.dp))

            Button(onClick = { navController.navigate(Rutas.Catalogo.ruta) }) {
                Text("Ver catálogo de skins", style = MaterialTheme.typography.bodyLarge)
            }

            Spacer(Modifier.height(12.dp))

            Button(onClick = { navController.navigate(Rutas.Resumen.ruta) }) {
                Text("Ver último usuario registrado", style = MaterialTheme.typography.bodyLarge)
            }

            Spacer(Modifier.height(12.dp))


            Button(onClick = { navController.navigate(Rutas.Carrito.ruta) }) {
                Text("Ver carrito", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}
