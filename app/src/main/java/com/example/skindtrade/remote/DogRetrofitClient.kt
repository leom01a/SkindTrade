package com.example.skintrade.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DogRetrofitClient {

    private const val BASE_URL_DOG = "https://dog.ceo/api/"

    val api: DogApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL_DOG)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogApi::class.java)
    }
}
