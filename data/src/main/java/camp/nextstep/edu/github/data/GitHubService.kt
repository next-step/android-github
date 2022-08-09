package camp.nextstep.edu.github.data

import retrofit2.Response
import retrofit2.http.GET

internal interface GitHubService {
    @GET("repositories")
    suspend fun getGitHubRepositoryList(): Response<List<GitHubRepositoryResponse>>
}