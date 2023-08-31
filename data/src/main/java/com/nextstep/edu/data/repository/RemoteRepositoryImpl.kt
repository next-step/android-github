package com.nextstep.edu.data.repository

import com.nextstep.edu.data.GithubService
import com.nextstep.edu.data.model.toDomain
import com.nextstep.edu.domain.model.Repository
import com.nextstep.edu.domain.repository.RemoteRepository

internal class RemoteRepositoryImpl(
    private val githubService: GithubService
): RemoteRepository {
    override suspend fun getRepositories(): List<Repository> {
        return githubService.getRepositories().toDomain()
    }
}
