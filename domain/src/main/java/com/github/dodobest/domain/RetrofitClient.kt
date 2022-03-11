package com.github.dodobest.domain

interface RetrofitClient {
    fun getRetrofit(baseUrl: String): MyRetrofit
}