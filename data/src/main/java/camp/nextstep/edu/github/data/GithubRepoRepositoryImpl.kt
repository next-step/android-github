package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepoRepository
import camp.nextstep.edu.github.domain.GithubRepositoryData
import javax.inject.Inject

internal class GithubRepoRepositoryImpl @Inject constructor(private val githubNetworkService: GithubNetworkService) :
    GithubRepoRepository {
    override suspend fun getRepositories(): List<GithubRepositoryData> {
        return githubNetworkService
            .getRepositories()
            .map(GithubRepositoryDTO::toDomain)
    }
}