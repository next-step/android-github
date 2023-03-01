package com.example.domain.repositories

import com.example.domain.models.RepositoryModel

interface GitHubRepository {
    suspend fun getRepositories(): List<RepositoryModel>
}
