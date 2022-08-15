package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GitHubRepository
import camp.nextstep.edu.github.domain.GitHubRepositoryItem
import javax.inject.Inject

internal class GitHubRepositoryImpl @Inject constructor(private val gitHubService: GitHubService) :
    GitHubRepository {

    override suspend fun getGitHubRepositoryList(): Result<List<GitHubRepositoryItem>> {
        val response = gitHubService.getGitHubRepositoryList()
        if (response.isSuccessful) {
            val gitHubRepositoryList =
                response.body()?.map { it.toGitHubRepositoryItem() } ?: return Result.failure(
                    NullPointerException()
                )
            return Result.success(gitHubRepositoryList)
        }
        return Result.failure(Exception())
    }
}