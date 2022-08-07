package camp.nextstep.edu.github.data.repository

import camp.nextstep.edu.github.data.mapper.toDomain
import camp.nextstep.edu.github.data.retrofit.GithubService
import camp.nextstep.edu.github.domain.model.Repository
import camp.nextstep.edu.github.domain.repository.GithubRepository

internal class GithubRepositoryImpl(
    private val githubService: GithubService
) : GithubRepository {

    override suspend fun fetchRepositoryList(): Result<List<Repository>> {
        return runCatching {
            githubService.fetchRepositoryList().map { it.toDomain() }
        }
    }
}
