package com.nextstep.edu.domain.usecase

import com.nextstep.edu.domain.model.Repository
import com.nextstep.edu.domain.repository.RemoteRepository
import javax.inject.Inject

class GetRepositoryUseCase @Inject constructor(
    private val repository: RemoteRepository
) {
    suspend operator fun invoke(): Result<List<Repository>> {
        return runCatching { repository.getRepositories() }
    }
}
