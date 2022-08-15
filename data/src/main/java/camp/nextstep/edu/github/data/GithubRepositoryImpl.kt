package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepositories
import camp.nextstep.edu.github.domain.GithubRepository
import javax.inject.Inject

internal class GithubRepositoryImpl @Inject constructor(
    private val apiService: GithubApiService
): GithubRepository {
    override suspend fun getRepo(): GithubRepositories {
        return GithubRepositories(apiService.repositories().map(GithubRepoResponse::toDomain))
    }
}