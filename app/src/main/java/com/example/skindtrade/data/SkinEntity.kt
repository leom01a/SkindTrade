package com.example.skintrade.data



import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "skins")
data class SkinEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val precio: Double,
    val imagenRes: Int
)
