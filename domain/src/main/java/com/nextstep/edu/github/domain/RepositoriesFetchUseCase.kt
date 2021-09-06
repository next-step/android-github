package com.nextstep.edu.github.domain

import com.nextstep.edu.github.domain.dto.RepositoryItemDto

class RepositoriesFetchUseCase(
    private val githubRepository: GithubRepository
) : UseCase<Result<List<RepositoryItemDto>>> {

    override suspend fun execute(): Result<List<RepositoryItemDto>> = runCatching {
        githubRepository.fetchRepositories()
    }
}
