package camp.nextstep.edu.github.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object GithubNetwork {
    private const val GITHUB_BASE_URL = "https://api.github.com/"
    val githubService: GithubNetworkService by lazy {
        Retrofit.Builder()
            .baseUrl(GITHUB_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubNetworkService::class.java)
    }
}