package camp.nextstep.edu.github.data

import retrofit2.http.GET

internal interface GithubNetworkService {
    @GET("repositories")
    suspend fun getRepositories(): List<GithubRepositoryDTO>
}