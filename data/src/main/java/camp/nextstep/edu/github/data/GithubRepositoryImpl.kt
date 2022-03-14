package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepoModel
import camp.nextstep.edu.github.domain.GithubRepository
import javax.inject.Inject

internal class GithubRepositoryImpl @Inject constructor(
    private val githubService: GithubService
) : GithubRepository {

    override suspend fun fetchGithubRepos(): Result<List<GithubRepoModel>> {
        val response = githubService.fetchGithubRepos()
        if (response.isSuccessful) {
            val githubRepos = response.body()?.toModelList().orEmpty()
            return Result.success(githubRepos)
        }

        return Result.failure(Exception())
    }
}