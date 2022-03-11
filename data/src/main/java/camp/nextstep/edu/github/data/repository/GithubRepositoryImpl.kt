package camp.nextstep.edu.github.data.repository

import camp.nextstep.edu.github.data.remote.model.mapToDomain
import camp.nextstep.edu.github.data.remote.service.GithubService
import camp.nextstep.edu.github.domain.Resource
import camp.nextstep.edu.github.domain.model.Repositories
import camp.nextstep.edu.github.domain.repository.GithubRepository

internal class GithubRepositoryImpl(
    private val githubService: GithubService
) : GithubRepository {
    override suspend fun getRepositories(): Resource<Repositories> {
        return try {
            val result = githubService.getRepositories().map { it.mapToDomain() }
            Resource.Success(Repositories(items = result))
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}
