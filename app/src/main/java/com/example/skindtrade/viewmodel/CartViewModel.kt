package com.example.skintrade.viewmodel

import androidx.lifecycle.ViewModel
import com.example.skintrade.data.SkinEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CartViewModel : ViewModel() {

    private val _items = MutableStateFlow<List<SkinEntity>>(emptyList())
    val items: StateFlow<List<SkinEntity>> = _items

    fun agregarAlCarrito(skin: SkinEntity) {
        val actual = _items.value.toMutableList()
        actual.add(skin)
        _items.value = actual
    }

    fun quitarDelCarrito(skin: SkinEntity) {
        val actual = _items.value.toMutableList()
        actual.remove(skin)
        _items.value = actual
    }

    fun limpiarCarrito() {
        _items.value = emptyList()
    }

    fun total(): Double {
        // 👇 Ajusta el campo de precio según tu SkinEntity
        return _items.value.sumOf { it.precio }
    }
}
