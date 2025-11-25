package com.example.skintrade

import com.example.skintrade.data.SkinEntity
import com.example.skintrade.viewmodel.CartViewModel
import org.junit.Assert.assertEquals
import org.junit.Test

class CartViewModelTest {

    @Test
    fun totalEsCeroCuandoCarritoVacio() {
        val viewModel = CartViewModel()

        val total = viewModel.total()

        assertEquals(0.0, total, 0.0001)
    }

    @Test
    fun agregarSkinsCalculaBienElTotal() {
        val viewModel = CartViewModel()

        val skin1 = SkinEntity(
            id = 1,
            nombre = "AK-47 | Redline",
            precio = 10.0,
            imagenRes = 0
        )

        val skin2 = SkinEntity(
            id = 2,
            nombre = "AWP | Dragon Lore",
            precio = 90.0,
            imagenRes = 0
        )

        viewModel.agregarAlCarrito(skin1)
        viewModel.agregarAlCarrito(skin2)

        val total = viewModel.total()

        assertEquals(100.0, total, 0.0001)
    }

    @Test
    fun limpiarCarritoDejaTotalEnCero() {
        val viewModel = CartViewModel()

        val skin = SkinEntity(
            id = 1,
            nombre = "M4A1-S | Printstream",
            precio = 50.0,
            imagenRes = 0
        )

        viewModel.agregarAlCarrito(skin)
        viewModel.limpiarCarrito()

        val total = viewModel.total()

        assertEquals(0.0, total, 0.0001)
        assertEquals(0, viewModel.items.value.size)
    }
}
