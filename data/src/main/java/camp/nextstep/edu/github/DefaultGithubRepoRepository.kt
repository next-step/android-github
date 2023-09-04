package camp.nextstep.edu.github

class DefaultGithubRepoRepository(
	private val githubService: GithubService,
) : GitHubRepoRepository {

	override suspend fun getGithubRepos(): List<GithubRepoResource> {
		return githubService.getRepositories().map { it.asResource() }
	}
}