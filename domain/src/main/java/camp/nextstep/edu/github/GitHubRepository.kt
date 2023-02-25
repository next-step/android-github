package camp.nextstep.edu.github

interface GitHubRepository {
    suspend fun getGitHubRepositoryInfo() : List<GitHubRepositoryInfo>
}