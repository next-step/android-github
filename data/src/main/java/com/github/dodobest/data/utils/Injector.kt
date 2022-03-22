package com.github.dodobest.data.utils

import com.github.dodobest.data.GithubRepositoryImpl
import com.github.dodobest.data.retrofit.GithubDataResponse
import com.github.dodobest.data.retrofit.RetrofitClient
import com.github.dodobest.data.retrofit.RetrofitManagerImpl
import com.github.dodobest.domain.GithubData
import com.github.dodobest.domain.GithubRepository
import com.github.dodobest.domain.RetrofitManager
import retrofit2.Retrofit

object Injector {
    fun provideGithubRepository(retrofitManager: RetrofitManager): GithubRepository {
        return GithubRepositoryImpl(retrofitManager)
    }

    fun provideRetrofitManager(retrofit: Retrofit): RetrofitManager {
        return RetrofitManagerImpl(retrofit)
    }

    fun provideRetrofit(): Retrofit {
        return RetrofitClient.getRetrofit()
    }
}