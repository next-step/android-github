package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepoModel
import camp.nextstep.edu.github.domain.GithubRepository

internal class GithubRepositoryImpl(
    private val githubService: GithubService = NetworkModule.githubService
) : GithubRepository {

    override suspend fun fetchGithubRepos(): Result<List<GithubRepoModel>> {
        val response = githubService.fetchGithubRepos()
        if (response.isSuccessful) {
            val githubRepos = response.body()?.toModelList() ?: return Result.failure(Exception())
            return Result.success(githubRepos)
        }

        return Result.failure(Exception())
    }
}