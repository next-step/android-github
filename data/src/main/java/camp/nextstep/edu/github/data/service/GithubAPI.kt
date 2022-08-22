package camp.nextstep.edu.github.data.service

import camp.nextstep.edu.github.data.model.GithubStorageResponse
import retrofit2.http.GET

internal interface GithubAPI {
    @GET("/repositories")
    suspend fun getRepositories(): List<GithubStorageResponse>
}