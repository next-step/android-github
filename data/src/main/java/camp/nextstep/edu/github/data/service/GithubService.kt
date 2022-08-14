package camp.nextstep.edu.github.data.service

import camp.nextstep.edu.github.data.model.GithubRemoteStorageResponse
import retrofit2.http.GET

interface GithubService {
    @GET("/repositories")
    suspend fun getRepositories(): List<GithubRemoteStorageResponse>
}