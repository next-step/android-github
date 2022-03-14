package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.model.toModelList
import camp.nextstep.edu.github.domain.GitRepository
import camp.nextstep.edu.github.domain.GitResponseData

internal class GitRepositoryImpl(
    private val githubService: GitService = NetworkModule.getGitService()
) : GitRepository {
    override suspend fun getRepository(): Result<List<GitResponseData>> {
        val response = githubService.getRepositories()
        if (response.isSuccessful) {
            val githubRepos = response.body()?.toModelList().orEmpty()
            return Result.success(githubRepos)
        }
        return Result.failure(Exception())
    }
}