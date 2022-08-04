package camp.nextstep.edu.github.data

import retrofit2.http.GET


/**
 * Created by link.js on 2022. 08. 05..
 */
interface GithubService {
    @GET("/repositories")
    fun getRepositories(): List<RepositoryDto>
}