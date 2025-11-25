package com.example.skintrade.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skintrade.remote.DogRetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {

    private val _imageUrl = MutableStateFlow<String?>(null)
    val imageUrl: StateFlow<String?> = _imageUrl

    fun cargarPerro() {
        viewModelScope.launch {
            try {
                val response = DogRetrofitClient.api.getRandomDog()
                if (response.isSuccessful) {
                    _imageUrl.value = response.body()?.message
                } else {
                    _imageUrl.value = null
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _imageUrl.value = null
            }
        }
    }
}
