package camp.nextstep.edu.github

internal class GitHubRepositoryImpl(
    private val githubService: GithubService
) : GitHubRepository {
    override suspend fun getGitHubRepositoryInfo(): List<GitHubRepositoryInfo> {
        return githubService.getGitHubRepositories().map { it.toDomainModel() }
    }
}