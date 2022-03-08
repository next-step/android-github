package camp.nextstep.edu.github.data.network

import camp.nextstep.edu.github.data.network.response.Repositories
import retrofit2.Response
import retrofit2.http.GET

internal interface GitHubService {
    @GET("repositories")
    suspend fun getRepositories(): Response<Repositories>
}