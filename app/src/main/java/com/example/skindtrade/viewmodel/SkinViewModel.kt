package com.example.skintrade.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.skintrade.data.SkinEntity
import com.example.skintrade.repo.SkinRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SkinViewModel(app: Application) : AndroidViewModel(app) {

    private val repository = SkinRepository(app)

    private val _skins = MutableStateFlow<List<SkinEntity>>(emptyList())
    val skins: StateFlow<List<SkinEntity>> = _skins

    init {
        cargarSkins()
    }

    private fun cargarSkins() {
        viewModelScope.launch {
            repository.obtenerSkins().collect {
                _skins.value = it
            }
        }
    }

    fun seedSiVacio() {
        viewModelScope.launch {
            repository.seedSiVacio()
        }
    }
}

