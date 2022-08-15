package camp.nextstep.edu.github.domain

import kotlin.Result


interface NetworkRepository {

    suspend fun getGithubRepositories(): Result<List<GithubRepository>>

}