package camp.nextstep.edu.github.domain

interface GithubRepoRepository {
    suspend fun getRepositories(): Result<List<GithubRepository>>
}