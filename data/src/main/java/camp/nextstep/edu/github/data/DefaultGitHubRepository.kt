package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import retrofit2.await

internal class DefaultGitHubRepository(
    private val gitHubService: GitHubService
) : GithubRepository {
    override suspend fun loadRepositories() = gitHubService.listRepos().await().let(RepositoriesMapper::mapToDomain)
}