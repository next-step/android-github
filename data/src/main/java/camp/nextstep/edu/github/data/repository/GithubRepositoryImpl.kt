package camp.nextstep.edu.github.data.repository

import camp.nextstep.edu.github.data.service.GithubService
import camp.nextstep.edu.github.domain.repository.GithubRepository
import camp.nextstep.edu.github.domain.model.GithubRepositoryInfo
import javax.inject.Inject

internal class GithubRepositoryImpl @Inject constructor(
    private val githubApi: GithubService
): GithubRepository {
    override suspend fun getRepositories(): List<GithubRepositoryInfo> {
        return githubApi.getRepositories().map { it.toDomainModel() }
    }
}
