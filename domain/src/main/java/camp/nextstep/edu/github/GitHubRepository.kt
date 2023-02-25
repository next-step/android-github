package camp.nextstep.edu.github

interface GitHubRepository {
    suspend fun getGitHubInfo() : List<GitHubRepositoryInfo>
}