package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.Repository

/**
 * Created by link.js on 2022. 08. 05..
 */
internal class GithubRepositoryImpl : GithubRepository {
    override suspend fun getRepositories(): List<Repository> {
        return GithubServiceFactory.githubApi.getRepositories().map { it.toDomain() }
    }
}