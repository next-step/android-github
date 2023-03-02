package com.example.data.repository

import com.example.data.data_source.DataSourceModule
import com.example.domain.repository.GitHubRepository

internal object RepositoryModule {

    fun buildGitHubRepository(): GitHubRepository {
        val networkDataSource = DataSourceModule.buildNetworkDataSource()
        return GitHubRepositoryImpl(networkDataSource)
    }
}
