package com.github.dodobest.domain.usecase

import com.github.dodobest.domain.GithubData
import com.github.dodobest.domain.GithubRepository

class GetRepositoriesUseCase(private val githubRepository: GithubRepository) {
    operator fun invoke(onSuccess: (List<GithubData>) -> Unit, onFailure: (Throwable) -> Unit) {
        githubRepository.getRepositories(onSuccess, onFailure)
    }
}