package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.Repositories

/**
 * Created by link.js on 2022. 08. 05..
 */
internal class GithubRepositoryImpl : GithubRepository {
    override suspend fun getRepositories(): Repositories {
        return Repositories(GithubServiceFactory.githubApi.getRepositories().map { it.toDomain() })
    }
}