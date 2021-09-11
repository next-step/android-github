package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.remote.service.GithubService
import camp.nextstep.edu.github.domain.entity.GithubRepo
import camp.nextstep.edu.github.domain.exception.NotFoundUserException
import camp.nextstep.edu.github.domain.repository.GithubRepoRepository

/**
 * Created By Malibin
 * on 9월 09, 2021
 */

internal class RealGithubRepoRepository(
    private val githubService: GithubService,
) : GithubRepoRepository {

    override suspend fun getRepositoriesOf(userName: String): Result<List<GithubRepo>> {
        val response = githubService.getUserRepos(userName)
        if (response.isSuccessful) {
            val githubRepos = response.body()?.map { it.toGithubRepo() }
                ?: return Result.failure(IllegalStateException("get Repositories request failed"))
            return Result.success(githubRepos)
        }
        return Result.failure(NotFoundUserException())
    }
}
