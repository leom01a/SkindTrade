package com.example.skintrade.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.skintrade.model.UsuarioUiState
import com.example.skintrade.model.UsuarioErrores

class UsuarioViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UsuarioUiState())
    val uiState: StateFlow<UsuarioUiState> = _uiState

    private val _errores = MutableStateFlow(UsuarioErrores())
    val errores: StateFlow<UsuarioErrores> = _errores

    fun actualizarCampo(campo: String, valor: String) {
        when (campo) {
            "nombre" -> _uiState.value = _uiState.value.copy(nombre = valor)
            "correo" -> _uiState.value = _uiState.value.copy(correo = valor)
            "clave" -> _uiState.value = _uiState.value.copy(clave = valor)
            "direccion" -> _uiState.value = _uiState.value.copy(direccion = valor)
        }
    }

    fun validarFormulario(): Boolean {
        val errores = UsuarioErrores(
            nombre = if (_uiState.value.nombre.isBlank()) "Nombre requerido" else null,
            correo = if (!_uiState.value.correo.contains("@")) "Correo inválido" else null,
            clave = if (_uiState.value.clave.length < 4) "Clave muy corta" else null,
            direccion = if (_uiState.value.direccion.isBlank()) "Dirección requerida" else null
        )
        _errores.value = errores
        return listOf(
            errores.nombre,
            errores.correo,
            errores.clave,
            errores.direccion
        ).all { it == null }
    }
}
