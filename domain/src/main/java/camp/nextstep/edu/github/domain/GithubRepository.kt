package camp.nextstep.edu.github.domain

interface GithubRepository {
    suspend fun getGithubService(): GithubService
}