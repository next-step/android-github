package com.example.domain.usecase

import com.example.domain.model.RepositoryResource
import com.example.domain.repository.GitHubRepository
import javax.inject.Inject

class GetRepositoryUseCase @Inject constructor(val repository: GitHubRepository) {
    suspend operator fun invoke(): List<RepositoryResource> = repository.getRepositories()
}
