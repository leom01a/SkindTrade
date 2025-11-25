package com.example.skintrade.remote

import retrofit2.Response
import retrofit2.http.GET

interface DogApi {
    @GET("breeds/image/random")
    suspend fun getRandomDog(): Response<DogResponse>
}
