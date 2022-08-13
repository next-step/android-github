package camp.nextstep.edu.github.data

import retrofit2.http.GET

internal interface GithubApiService {
    @GET("/repositories")
    suspend fun repositories(): List<GithubRepoResponse>
}