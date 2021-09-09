package camp.nextstep.edu.github.data.remote.service

import camp.nextstep.edu.github.data.remote.response.GithubRepoResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path

internal interface GithubService {

    @GET("/users/{username}/repos")
    suspend fun getUserRepos(
        @Path("username") userName: String,
    ): Response<List<GithubRepoResponse>>

    companion object {
        private const val BASE_URL = ""
        fun newInstance(): GithubService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}
