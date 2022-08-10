package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.Repo

internal class GithubRepositoryImpl(
    private val gitHubService: GithubService
) : GithubRepository {

    override suspend fun getRepositories(): List<Repo> {
        return gitHubService.listRepos().map { Repo(it.fullName, it.description) }
    }
}