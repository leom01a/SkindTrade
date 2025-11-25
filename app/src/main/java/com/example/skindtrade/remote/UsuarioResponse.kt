package com.example.skintrade.remote

data class UsuarioResponse(
    val id: Long,
    val nombre: String,
    val correo: String,
    val direccion: String,
    val rol: String
)
