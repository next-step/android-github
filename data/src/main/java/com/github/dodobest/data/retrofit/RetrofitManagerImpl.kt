package com.github.dodobest.data.retrofit

import com.github.dodobest.data.utils.API
import com.github.dodobest.domain.GithubRepository
import com.github.dodobest.domain.RetrofitClient
import com.github.dodobest.domain.RetrofitManager

internal class RetrofitManagerImpl(
    private val retrofitEntity : RetrofitEntity = RetrofitClientImpl().getRetrofit(API.BASE_URL).create(RetrofitEntity::class.java)
) : RetrofitManager{
    override fun getRepositories(): List<GithubRepository> {
        return retrofitEntity.getRepositories()
    }
}