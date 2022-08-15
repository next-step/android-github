package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepoRepository
import camp.nextstep.edu.github.domain.GithubRepositoryResponse
import javax.inject.Inject

internal class GithubRepoRepositoryImpl @Inject constructor(private val githubNetworkService: GithubNetworkService) :
    GithubRepoRepository {
    override suspend fun getRepositories(): List<GithubRepositoryResponse> {
        return githubNetworkService
            .getRepositories()
            .map(GithubRepositoryDTO::toDomain)
    }
}