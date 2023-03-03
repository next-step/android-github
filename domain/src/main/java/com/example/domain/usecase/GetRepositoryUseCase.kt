package com.example.domain.usecase

import com.example.domain.model.RepositoryResource
import com.example.domain.repository.GitHubRepository

class GetRepositoryUseCase(private val repository: GitHubRepository) {
    suspend operator fun invoke(): List<RepositoryResource> = repository.getRepositories()
}
