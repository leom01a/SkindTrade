package com.example.skintrade.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.skintrade.viewmodel.CartViewModel
import com.example.skintrade.viewmodel.SkinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogoScreen(
    viewModel: SkinViewModel = viewModel(),
    cartViewModel: CartViewModel = viewModel()   // 👈 NUEVO: ViewModel del carrito
) {
    val skins = viewModel.skins.collectAsState().value
    var datosCargados by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        if (!datosCargados) {
            viewModel.seedSiVacio()
            datosCargados = true
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Catálogo de Skins") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (skins.isEmpty()) {
                CircularProgressIndicator()
                Spacer(Modifier.height(8.dp))
                Text("Cargando catálogo...", style = MaterialTheme.typography.bodyMedium)
            } else {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    items(skins) { skin ->
                        AnimatedVisibility(visible = true) {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                elevation = CardDefaults.cardElevation(8.dp)
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.padding(12.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = skin.imagenRes),
                                        contentDescription = skin.nombre,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(180.dp),
                                        contentScale = ContentScale.Crop
                                    )
                                    Spacer(Modifier.height(8.dp))
                                    Text(
                                        text = skin.nombre,
                                        style = MaterialTheme.typography.titleMedium.copy(
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                    Text(
                                        text = "Precio: ${skin.precio} USD",
                                        style = MaterialTheme.typography.bodyMedium
                                    )

                                    Spacer(Modifier.height(12.dp))

                                    // 👇 NUEVO: botón para agregar al carrito
                                    Button(
                                        onClick = {
                                            cartViewModel.agregarAlCarrito(skin)
                                        },
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Text("Agregar al carrito")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
