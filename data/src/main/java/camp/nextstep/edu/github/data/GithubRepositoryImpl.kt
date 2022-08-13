package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepo
import camp.nextstep.edu.github.domain.GithubRepository

internal class GithubRepositoryImpl(
    private val apiService: GithubApiService
): GithubRepository {
    override suspend fun getRepo(): List<GithubRepo> {
        return apiService.repositories().map(GithubRepoResponse::toDomain)
    }
}