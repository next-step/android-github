package camp.nextstep.edu.github.domain

interface GithubRepository {

    suspend fun getRepository(): Result<List<Github>>

}