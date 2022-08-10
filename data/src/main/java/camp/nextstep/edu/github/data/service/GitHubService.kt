package camp.nextstep.edu.github.data.service

import camp.nextstep.edu.github.data.model.GitHubRepositoryEntity
import retrofit2.http.GET

internal interface GitHubService {
    @GET("repositories")
    suspend fun getRepositories(): List<GitHubRepositoryEntity>

    companion object {
        const val BASE_URL = "https://api.github.com/"
    }
}
