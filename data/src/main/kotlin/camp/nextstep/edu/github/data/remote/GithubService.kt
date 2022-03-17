package camp.nextstep.edu.github.data.remote

import retrofit2.http.GET

internal interface GithubService {

    @GET("repositories")
    suspend fun getRepositories(): List<GithubRepositoryData>
}