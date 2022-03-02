package com.github.dodobest.data.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private lateinit var retrofitClient: Retrofit

    fun getClient(baseUrl: String): Retrofit {
        val client = OkHttpClient.Builder()

        if (::retrofitClient.isInitialized) {
            return retrofitClient
        }

        client.connectTimeout(5, TimeUnit.SECONDS)
        client.readTimeout(5, TimeUnit.SECONDS)
        client.writeTimeout(5, TimeUnit.SECONDS)
        client.retryOnConnectionFailure(true)

        retrofitClient = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()
        return retrofitClient
    }
}