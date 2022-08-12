package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.NetworkRepository

internal class NetworkRepositoryImpl(
    private val githubApi: GithubApi = GithubApi.create()
) : NetworkRepository {

    override suspend fun getGithubRepositories(): List<GithubRepository> {
        return githubApi.getGithubRepositories().map { it.toDomain() }
    }

}