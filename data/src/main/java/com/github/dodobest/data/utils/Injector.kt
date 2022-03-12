package com.github.dodobest.data.utils

import com.github.dodobest.data.GithubRepositoryImpl
import com.github.dodobest.data.retrofit.RetrofitManager
import com.github.dodobest.domain.GithubRepository

object Injector {
    fun provideTaskRepository(): GithubRepository {
        return GithubRepositoryImpl(RetrofitManager())
    }
}