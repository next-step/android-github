package camp.nextstep.edu.github.data.datasource.remote.service

import camp.nextstep.edu.github.data.datasource.remote.response.ResponseRepository
import retrofit2.http.GET

internal interface GithubService {

    @GET("repositories")
    suspend fun getRepositories(): List<ResponseRepository>

    companion object {
        const val BASE_ENDPOINT = "https://api.github.com/"
    }
}