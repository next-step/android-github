package com.nextstep.edu.github.data

import com.nextstep.edu.github.data.remote.GithubRemoteDataSource
import com.nextstep.edu.github.domain.GithubRepository
import com.nextstep.edu.github.domain.dto.RepositoryItemDto
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val githubRemoteDataSource: GithubRemoteDataSource
) : GithubRepository {

    override suspend fun fetchRepositories(): List<RepositoryItemDto> = githubRemoteDataSource
        .fetchRepositories()
        .toDto()
}
