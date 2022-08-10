package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepositories
import camp.nextstep.edu.github.domain.GithubRepository
import javax.inject.Inject

internal class DefaultGitHubRepository @Inject constructor(
    private val gitHubService: GithubService
) : GithubRepository {
    override suspend fun loadRepositories(): GithubRepositories = gitHubService.listRepos()
        .map(GithubRepositoryResponse::toDomain)
        .let { GithubRepositories(it) }
}