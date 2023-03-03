package com.example.data.retrofit

import com.example.data.model.NetworkRepositoryResource
import retrofit2.http.GET

internal interface RetrofitNetworkApi {
    @GET("repositories")
    suspend fun getRepositories(): List<NetworkRepositoryResource>
}
