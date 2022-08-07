package camp.nextstep.edu.github.domain

/**
 * Created by link.js on 2022. 08. 05..
 */
interface GithubRepository {
    suspend fun getRepositories(): List<Repository>
}