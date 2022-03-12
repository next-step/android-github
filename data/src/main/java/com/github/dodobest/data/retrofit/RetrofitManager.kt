package com.github.dodobest.data.retrofit

import com.github.dodobest.domain.GithubData

class RetrofitManager(
    private val retrofit : Retrofit = RetrofitClient().getRetrofit(API.BASE_URL).create(Retrofit::class.java)
) {
    fun getRepositories(): List<GithubData> {
        return retrofit.getRepositories()
    }
}