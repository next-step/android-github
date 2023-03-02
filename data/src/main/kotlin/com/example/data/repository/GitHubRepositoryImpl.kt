package com.example.data.repository

import com.example.data.data_source.NetworkDataSource
import com.example.domain.model.RepositoryResource
import com.example.domain.repository.GitHubRepository

internal class GitHubRepositoryImpl(private val dataSource: NetworkDataSource) : GitHubRepository {
    override suspend fun getRepositories(): List<RepositoryResource> {
        return dataSource.getRepositories().map { it.toRepositoryResource() }
    }
}
