package camp.nextstep.edu.github.data.network

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.network.GitHubDataSource

internal class GithubRepositoriesDataSource(
    private val gitHubService: GitHubService
) : GitHubDataSource {
    override suspend fun fetchRepositories(): List<GithubRepository> {
        return gitHubService.getRepositories()
    }
}