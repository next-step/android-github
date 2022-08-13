package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.Repositories
import javax.inject.Inject

/**
 * Created by link.js on 2022. 08. 05..
 */
internal class GithubRepositoryImpl @Inject constructor(
    private val githubApi: GithubService
) : GithubRepository {
    override suspend fun getRepositories(): Repositories {
        return Repositories(githubApi.getRepositories().map { it.toDomain() })
    }
}