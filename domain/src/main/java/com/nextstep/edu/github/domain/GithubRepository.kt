package com.nextstep.edu.github.domain

interface GithubRepository {

    suspend fun fetchRepositories(): List<RepositoryItem>
}
