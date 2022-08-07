package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GitHubRepository
import camp.nextstep.edu.github.domain.GitHubRepositoryItem

internal class GitHubRepositoryImpl(private val gitHubService: GitHubService) : GitHubRepository {
    override suspend fun getGitHubRepositoryList(): List<GitHubRepositoryItem> {
        return gitHubService.getGitHubRepositoryList().map { it.toGitHubRepositoryItem() }
    }

    companion object {
        fun getInstance(gitHubService: GitHubService): GitHubRepository =
            GitHubRepositoryImpl(gitHubService)
    }
}