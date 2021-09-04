package com.nextstep.edu.github.domain

import com.nextstep.edu.github.domain.dto.RepositoryItemDto

interface GithubRepository {

    suspend fun fetchRepositories(): List<RepositoryItemDto>
}
