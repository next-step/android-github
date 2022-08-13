package camp.nextstep.edu.github.domain

interface GithubRepository {
    suspend fun getRepo(): List<GithubRepo>
}