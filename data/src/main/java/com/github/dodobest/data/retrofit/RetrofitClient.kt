package com.github.dodobest.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private lateinit var retrofitClient: Retrofit

    fun getClient(baseUrl: String): Retrofit {
        if (::retrofitClient.isInitialized) {
            return retrofitClient
        }

        retrofitClient = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofitClient
    }
}