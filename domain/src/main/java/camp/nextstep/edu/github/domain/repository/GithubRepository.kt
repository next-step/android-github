package camp.nextstep.edu.github.domain.repository

interface GithubRepository {

    suspend fun getRepositories(): List<Repository>
}
