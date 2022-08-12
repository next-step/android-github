package camp.nextstep.edu.github.domain

interface NetworkRepository {

    suspend fun getGithubRepositories(): List<GithubRepository>

}