package camp.nextstep.edu.github.data.api

import camp.nextstep.edu.github.data.model.SearchResponse
import retrofit2.Response
import retrofit2.http.GET

interface GitHubSearchApi {
    @GET("repositories")
    suspend fun searchGithub(): Response<SearchResponse>

}