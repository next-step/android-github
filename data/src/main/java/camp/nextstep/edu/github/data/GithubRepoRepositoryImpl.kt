package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepoRepository
import camp.nextstep.edu.github.domain.GithubRepositoryResponse
import javax.inject.Inject

internal class GithubRepoRepositoryImpl @Inject constructor(private val githubNetworkService: GithubNetworkService) :
    GithubRepoRepository {
    override suspend fun getRepositories(): Result<List<GithubRepositoryResponse>> {
        val result = getRepositoriesResult()
        if (result.isFailure)
            return Result.failure(result.exceptionOrNull()!!)
        return Result.success(result.getOrNull()!!.map(GithubRepositoryDTO::toDomain))
    }

    private suspend fun getRepositoriesResult() =
        runCatching {
            githubNetworkService.getRepositories()
        }.onSuccess {
            Result.success(it)
        }.onFailure {
            Result.failure<GithubRepositoryDTO>(it)
        }
}