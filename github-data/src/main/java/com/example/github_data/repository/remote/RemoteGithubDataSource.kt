package com.example.github_data.repository.remote

import com.example.github_data.room.GithubRepoEntity

interface RemoteGithubDataSource {
    suspend fun getGitHubRepo(): List<GithubRepoEntity>
}
