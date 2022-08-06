package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.Repository

internal class GithubRepositoryImpl(
    private val githubService: GithubService,
    private val repositoryMapper: RepositoryMapper,
) : GithubRepository {

    override suspend fun getRepositories(): List<Repository> =
        githubService.getRepositories().map(repositoryMapper::toDomain)
}
