package camp.nextstep.edu.github.data.repository

import camp.nextstep.edu.github.data.mapper.toDomain
import camp.nextstep.edu.github.data.retrofit.GithubService
import camp.nextstep.edu.github.data.retrofit.RetrofitModule
import camp.nextstep.edu.github.domain.model.Repository
import camp.nextstep.edu.github.domain.repository.GithubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class GithubRepositoryImpl(
    private val githubService: GithubService = RetrofitModule.githubService
) : GithubRepository {

    override suspend fun fetchRepositoryList(): Result<List<Repository>> {
        return runCatching {
            githubService.fetchRepositoryList().map { it.toDomain() }
        }
    }
}
