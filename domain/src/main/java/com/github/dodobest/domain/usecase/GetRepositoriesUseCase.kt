package com.github.dodobest.domain.usecase

import com.github.dodobest.domain.GithubRepository
import com.github.dodobest.domain.RetrofitManager

class GetRepositoriesUseCase(private val retrofitManager: RetrofitManager) {
    operator fun invoke(): List<GithubRepository> {
        return retrofitManager.getRepositories()
    }
}