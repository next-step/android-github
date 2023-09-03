package com.example.github_data.room

import com.example.github_data.GitHubRepositoryImpl
import com.example.github_domain.GitHubRepository

object Injector {
    fun providesGithubRepoRepository(githubRepoDao: GithubRepoDao): GitHubRepository {
        return GitHubRepositoryImpl(githubRepoDao)
    }
}
