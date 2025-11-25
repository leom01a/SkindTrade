package com.example.skintrade.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.skintrade.viewmodel.CartViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarritoScreen(
    cartViewModel: CartViewModel = viewModel()
) {
    val items by cartViewModel.items.collectAsState()
    val total = cartViewModel.total()

    // Estado del mensaje de compra
    var compraRealizada by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Carrito de compras") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {

            if (items.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Tu carrito está vacío.")
                }
            } else {

                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {
                    items(items) { skin ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 6.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Image(
                                    painter = painterResource(id = skin.imagenRes),
                                    contentDescription = skin.nombre,
                                    modifier = Modifier.size(64.dp)
                                )

                                Spacer(Modifier.width(12.dp))

                                Column {
                                    Text("Skin: ${skin.nombre}")
                                    Text("Precio: $${skin.precio}")
                                }
                            }
                        }
                    }
                }

                Spacer(Modifier.height(16.dp))

                Text(
                    "Total: $${total}",
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(Modifier.height(12.dp))

                // BOTÓN CONFIRMAR COMPRA
                Button(
                    onClick = {
                        cartViewModel.limpiarCarrito()
                        compraRealizada = true // 👉 activa el mensaje
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Confirmar compra")
                }
            }

            // ⭐ MENSAJE DE COMPRA REALIZADA
            if (compraRealizada) {
                AlertDialog(
                    onDismissRequest = { compraRealizada = false },
                    title = { Text("Compra realizada") },
                    text = { Text("Su compra se realizó con éxito.") },
                    confirmButton = {
                        TextButton(onClick = { compraRealizada = false }) {
                            Text("OK")
                        }
                    }
                )
            }
        }
    }
}
