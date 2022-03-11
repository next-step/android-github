package com.github.dodobest.data.retrofit

import com.github.dodobest.data.utils.toMyRetrofit
import com.github.dodobest.domain.MyRetrofit
import com.github.dodobest.domain.RetrofitClient
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClientImpl : RetrofitClient {
    private lateinit var retrofitClient: Retrofit

    override fun getRetrofit(baseUrl: String): MyRetrofit {
        val client = OkHttpClient.Builder()

        if (::retrofitClient.isInitialized) {
            return retrofitClient.toMyRetrofit()
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
        return retrofitClient.toMyRetrofit()
    }
}