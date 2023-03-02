package com.example.domain.repository

import com.example.domain.model.RepositoryResource

interface GitHubRepository {
    suspend fun getRepositories(): List<RepositoryResource>
}
