package com.nextstep.edu.github.data.remote

import com.nextstep.edu.github.data.entity.RepositoryItem
import javax.inject.Inject

internal class GithubRemoteDataSourceImpl @Inject constructor(
    private val githubService: GithubService
): GithubRemoteDataSource {

    override suspend fun fetchRepositories(): List<RepositoryItem> = githubService
        .fetchRepositories()
}
