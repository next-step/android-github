package com.example.data.data_source

import com.example.data.model.NetworkRepositoryResource

internal interface NetworkDataSource {
    suspend fun getRepositories(): List<NetworkRepositoryResource>
}
