package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository

internal class DefaultGitHubRepository(
    private val gitHubService: GitHubService
) : GithubRepository {
    override suspend fun loadRepositories() = gitHubService.listRepos().let(RepositoriesMapper::mapToDomain)
}