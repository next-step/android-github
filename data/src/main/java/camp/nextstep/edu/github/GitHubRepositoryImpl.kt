package camp.nextstep.edu.github

internal class GitHubRepositoryImpl(
    private val retrofitService: GithubService
) : GitHubRepository {
    override suspend fun getGitHubInfo(): List<GitHubRepositoryInfo> {
        return retrofitService.getGitHubRepositories().map { it.toGitHubInfoModel() }
    }
}