package com.example.skintrade.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UsuarioApi {

    @POST("usuarios")
    suspend fun crearUsuario(
        @Body request: UsuarioRequest
    ): Response<UsuarioResponse>

    @GET("usuarios/ultimo")
    suspend fun obtenerUltimo(): Response<UsuarioResponse>
}
