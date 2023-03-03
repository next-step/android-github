package com.example.data.retrofit

import com.example.data.datasource.NetworkDataSource
import com.example.data.model.NetworkRepositoryResource

internal class RetrofitNetwork(private val retrofitNetworkApi: RetrofitNetworkApi) : NetworkDataSource {
    override suspend fun getRepositories(): List<NetworkRepositoryResource> =
        retrofitNetworkApi.getRepositories()
}
