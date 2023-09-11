package com.example.githubdomain

interface GitHubRepository {
    suspend fun getGitHubRepoData(): List<GithubRepoData>
}
