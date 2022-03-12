package com.github.dodobest.domain.usecase

import com.github.dodobest.domain.GithubData
import com.github.dodobest.domain.GithubRepository
import com.github.dodobest.domain.RESPONSE_STATE

class GetRepositoriesUseCase(private val githubRepository: GithubRepository) {
    operator fun invoke(completion: (RESPONSE_STATE, List<GithubData>) -> Unit) {
        githubRepository.getRepositories(completion)
    }
}