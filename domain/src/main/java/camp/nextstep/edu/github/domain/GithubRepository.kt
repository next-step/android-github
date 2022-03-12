package camp.nextstep.edu.github.domain

interface GithubRepository {
    suspend fun fetchGithubRepos(): Result<List<GithubRepoModel>>
}