package com.nextstep.edu.github.domain

import com.nextstep.edu.github.domain.entity.RepositoryItem

interface GithubRepository {

    suspend fun fetchRepositories(): List<RepositoryItem>
}
