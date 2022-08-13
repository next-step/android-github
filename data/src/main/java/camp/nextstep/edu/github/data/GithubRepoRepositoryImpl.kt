package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepoRepository
import camp.nextstep.edu.github.domain.GithubRepositoryData

internal class GithubRepoRepositoryImpl(private val githubNetworkService: GithubNetworkService) :
    GithubRepoRepository {
    override suspend fun getRepositories(): List<GithubRepositoryData> {
        return githubNetworkService
            .getRepositories()
            .map { GithubRepositoryData(it.fullName, it.description ?: "") }
    }
}