package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.NetworkRepository

internal class NetworkRepositoryImpl : NetworkRepository {

    override suspend fun getGithubRepositories(): List<GithubRepository> {
        return GithubApi.create().getGithubRepositories().map { it.toDomain() }
    }

}