package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.model.GitResponse
import retrofit2.Response
import retrofit2.http.GET

interface GithubService {

    @GET("repositories")
    suspend fun getRepositories(): Response<List<GitResponse>>

}