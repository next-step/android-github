package camp.nextstep.edu.github

interface GitHubRepoRepository {
	suspend fun getGithubRepos(): List<GithubRepoResource>
}