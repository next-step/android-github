package com.example.data.repository

import com.example.data.datasource.DataSourceModule
import com.example.data.datasource.NetworkDataSource
import com.example.domain.repository.GitHubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object RepositoryModule {

    @Provides
    fun buildGitHubRepository(networkDataSource: NetworkDataSource): GitHubRepository {
        return GitHubRepositoryImpl(networkDataSource)
    }
}
