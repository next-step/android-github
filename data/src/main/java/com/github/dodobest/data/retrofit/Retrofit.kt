package com.github.dodobest.data.retrofit

import com.github.dodobest.domain.GithubData
import retrofit2.http.GET

interface Retrofit {
    @GET(API.SEARCH_PUBLIC_REPOSITORY)
    fun getRepositories() : List<GithubData>
}