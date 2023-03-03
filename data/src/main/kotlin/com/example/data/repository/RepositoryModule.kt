package com.example.data.repository

import com.example.data.datasource.DataSourceModule
import com.example.domain.repository.GitHubRepository

internal object RepositoryModule {

    fun buildGitHubRepository(): GitHubRepository {
        val networkDataSource = DataSourceModule.buildNetworkDataSource()
        return GitHubRepositoryImpl(networkDataSource)
    }
}
