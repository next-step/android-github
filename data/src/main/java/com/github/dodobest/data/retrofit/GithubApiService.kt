package com.github.dodobest.data.retrofit

import com.github.dodobest.domain.GithubData
import retrofit2.Call
import retrofit2.http.GET

interface GithubApiService {
    @GET(API.SEARCH_PUBLIC_REPOSITORY)
    fun getRepositories() : Call<List<GithubDataResponse>>
}