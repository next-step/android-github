package com.example.github.data.repository.local

import com.example.github.data.room.GithubRepoEntity
import com.example.githubdomain.GithubRepoData

interface LocalGithubDataSource {
    suspend fun getGitHubRepo(): List<GithubRepoEntity>

    fun insertGitHubRepo(gitHubRepoDataList: List<GithubRepoData>)
}
