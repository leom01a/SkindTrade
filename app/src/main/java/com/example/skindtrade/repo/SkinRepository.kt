package com.example.skintrade.repo

import android.content.Context
import com.example.skintrade.R
import com.example.skintrade.data.SkinEntity
import com.example.skintrade.data.db.AppDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class SkinRepository(context: Context) {

    private val skinDao = AppDatabase.getInstance(context).skinDao()

    fun obtenerSkins(): Flow<List<SkinEntity>> = skinDao.obtenerSkins()

    suspend fun insertarSkin(skin: SkinEntity) = skinDao.insertarSkins(listOf(skin))

    suspend fun seedSiVacio() {
        val existentes = skinDao.obtenerSkins().first()
        if (existentes.isEmpty()) {
            val skins = listOf(
                SkinEntity(nombre = "AK-47 Redline", precio = 25.0, imagenRes = R.drawable.ak47_redline),
                SkinEntity(nombre = "AWP Asiimov", precio = 75.0, imagenRes = R.drawable.awp_asiimov),
                SkinEntity(nombre = "Glock Watermelon", precio = 7.5, imagenRes = R.drawable.glock_watermelon)
            )
            skinDao.insertarSkins(skins)
        }
    }
}


