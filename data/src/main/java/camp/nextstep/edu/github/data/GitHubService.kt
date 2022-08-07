package camp.nextstep.edu.github.data

import retrofit2.http.GET

internal interface GitHubService {
    @GET("repositories")
    suspend fun getGitHubRepositoryList(): List<GitHubRepositoryResponse>
}