package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GitHubRepository
import camp.nextstep.edu.github.domain.GitHubRepositoryItem

internal class GitHubRepositoryImpl(private val gitHubService: GitHubService) : GitHubRepository {
    override suspend fun getGitHubRepositoryList(): Result<List<GitHubRepositoryItem>> =
        runCatching {
            gitHubService.getGitHubRepositoryList().body()?.map {
                it.toGitHubRepositoryItem()
            } ?: throw NullPointerException()
        }
}