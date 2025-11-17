package com.example.skintrade.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.skintrade.data.UsuarioEntity
import com.example.skintrade.data.db.AppDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UsuarioViewModel(app: Application) : AndroidViewModel(app) {

    private val _usuario = MutableStateFlow<UsuarioEntity?>(null)
    val usuario: StateFlow<UsuarioEntity?> = _usuario

    private val db = Room.databaseBuilder(
        app.applicationContext,
        AppDatabase::class.java,
        "skindtrade_db"
    ).build()

    fun guardarUsuario(nombre: String, correo: String, direccion: String) {
        viewModelScope.launch {
            val nuevoUsuario = UsuarioEntity(
                nombre = nombre,
                correo = correo,
                direccion = direccion
            )
            db.usuarioDao().insertarUsuario(nuevoUsuario)
        }
    }

    fun cargarUltimoUsuario() {
        viewModelScope.launch {
            val ultimo = db.usuarioDao().obtenerUltimoUsuario()
            _usuario.value = ultimo
        }
    }
}






