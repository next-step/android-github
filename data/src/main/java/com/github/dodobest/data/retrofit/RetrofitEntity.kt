package com.github.dodobest.data.retrofit

import com.github.dodobest.domain.GithubRepository
import com.github.dodobest.data.utils.API
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitEntity {
    @GET(API.SEARCH_PUBLIC_REPOSITORY)
    fun getRepositories() : List<GithubRepository>
}