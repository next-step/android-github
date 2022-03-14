package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.model.toModelList
import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.Github

internal class GithubRepositoryImpl(
    private val githubService: GithubService = NetworkModule.getGitService()
) : GithubRepository {
    override suspend fun getRepository(): Result<List<Github>> {
        val response = githubService.getRepositories()
        if (response.isSuccessful) {
            val githubRepos = response.body()?.toModelList().orEmpty()
            return Result.success(githubRepos)
        }
        return Result.failure(Exception())
    }
}