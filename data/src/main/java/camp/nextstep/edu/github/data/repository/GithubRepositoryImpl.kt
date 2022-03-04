package camp.nextstep.edu.github.data.repository

import camp.nextstep.edu.github.data.remote.model.mapToDomain
import camp.nextstep.edu.github.data.remote.service.GithubService
import camp.nextstep.edu.github.domain.model.Repository
import camp.nextstep.edu.github.domain.repository.GithubRepository

internal class GithubRepositoryImpl(
    private val githubService: GithubService
) : GithubRepository {
    override suspend fun getRepositories(): List<Repository> {
        val result = githubService.getRepositories()
        return result.map { it.mapToDomain() }
    }
}