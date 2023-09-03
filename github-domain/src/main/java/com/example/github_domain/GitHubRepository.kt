package com.example.github_domain

interface GitHubRepository {
    fun insertGitHubRepository()

    fun getGitHubRepoData(): List<GithubRepoData>
}
