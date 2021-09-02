package com.nextstep.edu.github.data.remote

import com.nextstep.edu.github.domain.RepositoryItem

interface GithubRemoteDataSource {

    suspend fun fetchRepositories(): List<RepositoryItem>
}
