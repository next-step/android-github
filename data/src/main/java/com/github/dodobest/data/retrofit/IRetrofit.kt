package com.github.dodobest.data.retrofit

import com.github.dodobest.data.utils.API
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET

interface IRetrofit {
    @GET(API.SEARCH_PUBLIC_REPOSITORY)
    fun getRepositories() : Call<JsonElement>
}