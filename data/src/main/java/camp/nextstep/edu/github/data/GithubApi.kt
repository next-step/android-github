package camp.nextstep.edu.github.data

import retrofit2.Response
import retrofit2.http.GET

internal interface GithubApi {

    @GET("repositories")
    suspend fun getGithubRepositories(): Response<List<GithubRepositoryResponse>>

}