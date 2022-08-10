package camp.nextstep.edu.github.data

import retrofit2.http.GET

internal interface ApiService {
    @GET("repositories")
    suspend fun getRepositories(): List<RepositoryDTO>
}