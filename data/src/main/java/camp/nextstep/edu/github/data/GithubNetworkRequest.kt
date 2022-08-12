package camp.nextstep.edu.github.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object GithubNetworkRequest {
    private const val GITHUB_BASE_URL = "https://api.github.com/"
    fun getGithubService(): GithubService =
        Retrofit.Builder()
            .baseUrl(GITHUB_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubService::class.java)
}