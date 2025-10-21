package com.example.skintrade.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SkinDao {
    @Query("SELECT * FROM skins")
    fun obtenerSkins(): Flow<List<SkinEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarSkins(skins: List<SkinEntity>)
}
