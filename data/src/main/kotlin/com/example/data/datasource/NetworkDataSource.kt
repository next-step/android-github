package com.example.data.datasource

import com.example.data.model.NetworkRepositoryResource

internal interface NetworkDataSource {
    suspend fun getRepositories(): List<NetworkRepositoryResource>
}
