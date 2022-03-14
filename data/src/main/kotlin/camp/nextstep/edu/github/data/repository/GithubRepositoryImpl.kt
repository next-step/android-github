package camp.nextstep.edu.github.data.repository

import camp.nextstep.edu.github.data.remote.GithubService
import camp.nextstep.edu.github.domain.model.GithubRepoModel
import camp.nextstep.edu.github.domain.repository.GithubRepository

internal class GithubRepositoryImpl(private val githubService: GithubService) : GithubRepository {
    override suspend fun getRepositories(): List<GithubRepoModel> {
        val response = githubService.getRepositories()
        return response.map { it.convertToDomain() }
    }

}