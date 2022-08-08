package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.Repositories

internal class DefaultGitHubRepository(
    private val gitHubService: GitHubService
) : GithubRepository {
    override suspend fun loadRepositories(): Repositories = gitHubService.listRepos()
        .map(RepoModel::toDomain)
        .let { Repositories(it) }
}