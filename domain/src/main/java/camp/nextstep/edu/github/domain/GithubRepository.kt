package camp.nextstep.edu.github.domain

interface GithubRepository {
    suspend fun getRepositories(): List<Repo>
}