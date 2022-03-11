package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.model.GithubResponse
import retrofit2.http.GET

internal interface GithubService {
    @GET("repositories")
    suspend fun getGithubRepositories(): List<GithubResponse>
}
