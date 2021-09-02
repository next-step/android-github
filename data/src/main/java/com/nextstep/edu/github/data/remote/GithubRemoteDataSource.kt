package com.nextstep.edu.github.data.remote

import com.nextstep.edu.github.domain.entity.RepositoryItem

interface GithubRemoteDataSource {

    suspend fun fetchRepositories(): List<RepositoryItem>
}
