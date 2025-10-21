package com.example.skintrade.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.skintrade.data.UsuarioEntity
import com.example.skintrade.data.UsuarioDao
import com.example.skintrade.data.SkinEntity
import com.example.skintrade.data.SkinDao

@Database(
    entities = [UsuarioEntity::class, SkinEntity::class],
    version = 3, // Aumenta versión si ya existía otra
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
    abstract fun skinDao(): SkinDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "skindtrade_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}



