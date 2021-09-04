package com.nextstep.edu.github.data.remote

import com.nextstep.edu.github.data.entity.RepositoryItem

internal interface GithubRemoteDataSource {

    suspend fun fetchRepositories(): List<RepositoryItem>
}
