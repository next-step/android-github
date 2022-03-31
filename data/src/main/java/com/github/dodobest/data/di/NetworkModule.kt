package com.github.dodobest.data.di

import com.github.dodobest.data.retrofit.API.BASE_URL
import com.github.dodobest.data.retrofit.GithubApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@InstallIn(SingletonComponent::class)
@Module
internal object NetworkModule {
    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder()
                .connectTimeout(2, TimeUnit.SECONDS)
                .readTimeout(2, TimeUnit.SECONDS)
                .writeTimeout(2, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build())
            .build()
    }

    @Provides
    fun provideGithubApiService(retrofit: Retrofit) : GithubApiService {
        return retrofit.create(GithubApiService::class.java)
    }
}