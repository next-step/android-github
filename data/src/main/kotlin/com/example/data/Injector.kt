package com.example.data

import com.example.data.repository.RepositoryModule
import com.example.domain.repository.GitHubRepository

object Injector {
    fun providerGitHubRepository(): GitHubRepository = RepositoryModule.buildGitHubRepository()
}
