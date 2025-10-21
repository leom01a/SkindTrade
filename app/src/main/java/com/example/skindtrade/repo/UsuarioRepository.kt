package com.example.skintrade.repo

import com.example.skintrade.data.UsuarioDao
import com.example.skintrade.data.UsuarioEntity

class UsuarioRepository(private val usuarioDao: UsuarioDao) {

    suspend fun guardarUsuario(usuario: UsuarioEntity) {
        usuarioDao.insertarUsuario(usuario)
    }

    suspend fun obtenerUltimoUsuario(): UsuarioEntity? {
        return usuarioDao.obtenerUltimoUsuario()
    }
}
