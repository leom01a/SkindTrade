package com.example.skintrade.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.skintrade.data.UsuarioEntity

@Dao
interface UsuarioDao {

    @Insert
    suspend fun insertarUsuario(usuario: UsuarioEntity)

    @Query("SELECT * FROM usuarios ORDER BY id DESC LIMIT 1")
    suspend fun obtenerUltimoUsuario(): UsuarioEntity?
}
