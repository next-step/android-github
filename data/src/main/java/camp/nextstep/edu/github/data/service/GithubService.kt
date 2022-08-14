package camp.nextstep.edu.github.data.service

import camp.nextstep.edu.github.data.model.GithubStorageResponse
import retrofit2.http.GET

interface GithubService {
    @GET("/repositories")
    suspend fun getRepositories(): List<GithubStorageResponse>
}