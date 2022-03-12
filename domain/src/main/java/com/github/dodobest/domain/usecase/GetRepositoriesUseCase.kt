package com.github.dodobest.domain.usecase

import com.github.dodobest.domain.GithubData
import com.github.dodobest.domain.TaskRepository

class GetRepositoriesUseCase(private val taskRepository: TaskRepository) {
    operator fun invoke(): List<GithubData> {
        return taskRepository.getRepositories()
    }
}