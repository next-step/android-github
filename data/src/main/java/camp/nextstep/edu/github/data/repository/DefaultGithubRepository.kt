package camp.nextstep.edu.github.data.repository

import camp.nextstep.edu.github.data.service.GithubService
import camp.nextstep.edu.github.data.entity.RepositoryMapper
import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.Repository

internal class DefaultGithubRepository(
    private val githubService: GithubService,
    private val repositoryMapper: RepositoryMapper,
) : GithubRepository {

    override suspend fun getRepositories(): List<Repository> =
        githubService.getRepositories().map(repositoryMapper::toDomain)
}
