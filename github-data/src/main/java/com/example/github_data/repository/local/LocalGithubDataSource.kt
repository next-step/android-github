package com.example.github_data.repository.local

import com.example.github_data.room.GithubRepoEntity

interface LocalGithubDataSource {
    suspend fun getGitHubRepo(): List<GithubRepoEntity>
}
