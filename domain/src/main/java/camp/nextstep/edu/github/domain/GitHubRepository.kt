package camp.nextstep.edu.github.domain

interface GitHubRepository {
    suspend fun getGitHubRepositoryList(): Result<List<GitHubRepositoryItem>>
}