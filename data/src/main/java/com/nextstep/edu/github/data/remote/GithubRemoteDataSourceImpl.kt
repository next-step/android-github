package com.nextstep.edu.github.data.remote

import com.nextstep.edu.github.data.entity.RepositoryItem

internal class GithubRemoteDataSourceImpl(
    private val githubService: GithubService
): GithubRemoteDataSource {

    override suspend fun fetchRepositories(): List<RepositoryItem> =
        githubService.fetchRepositories()
}
