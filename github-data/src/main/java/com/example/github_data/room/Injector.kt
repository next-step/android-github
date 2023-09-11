package com.example.github_data.room

import com.example.github_data.repository.GithubRepositoryImpl
import com.example.github_data.repository.local.LocalGithubDataSource
import com.example.github_data.repository.remote.RemoteGithubDataSource
import com.example.githubdomain.GitHubRepository

object Injector {
    fun providesGithubRepoRepository(localGithubDataSource: LocalGithubDataSource, remoteGithubDataSource: RemoteGithubDataSource): GitHubRepository {
        return GithubRepositoryImpl(localGithubDataSource, remoteGithubDataSource)
    }
}
