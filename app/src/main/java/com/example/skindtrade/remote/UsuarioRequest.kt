package com.example.skintrade.remote

data class UsuarioRequest(
    val nombre: String,
    val correo: String,
    val direccion: String,
    val rol: String
)
