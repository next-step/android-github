package camp.nextstep.edu.github.data.remote.network

import camp.nextstep.edu.github.data.remote.response.RepoResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface GithubService {

    @GET("repositories")
    suspend fun loadRepos(): List<RepoResponse>

    companion object {
        private const val GITHUB_URL = "https://api.github.com"
        val instance: GithubService = Retrofit.Builder()
            .baseUrl(GITHUB_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}
