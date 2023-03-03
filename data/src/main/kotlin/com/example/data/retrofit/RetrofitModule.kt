package com.example.data.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal object RetrofitModule {

    private const val BASE_URL = "https://api.github.com/"

    private fun buildClient() = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    @OptIn(ExperimentalSerializationApi::class)
    private fun buildRetrofit(): Retrofit {
        val contentType = "application/json".toMediaType()
        val json = Json {
            ignoreUnknownKeys = true
        }
        return Retrofit.Builder()
            .client(buildClient())
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    fun buildRetrofitNetworkApi(): RetrofitNetworkApi =
        buildRetrofit().create(RetrofitNetworkApi::class.java)
}
