package camp.nextstep.edu.github.data.network

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.network.GithubDataSource
import javax.inject.Inject

internal class GithubRepositoriesDataSource @Inject constructor(
    private val gitHubService: GithubService
) : GithubDataSource {
    override suspend fun fetchRepositories(): List<GithubRepository> {
        return gitHubService.getRepositories()
    }
}
