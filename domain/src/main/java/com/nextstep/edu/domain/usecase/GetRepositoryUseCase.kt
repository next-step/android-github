package com.nextstep.edu.domain.usecase

import com.nextstep.edu.domain.model.Repository
import com.nextstep.edu.domain.repository.RemoteRepository

class GetRepositoryUseCase(
    private val repository: RemoteRepository
) {
    suspend operator fun invoke(): Result<List<Repository>> {
        return runCatching { repository.getRepositories() }
    }
}
