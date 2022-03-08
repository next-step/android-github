package camp.nextstep.edu.github.data.network

import camp.nextstep.edu.github.data.util.GsonConverter
import retrofit2.Retrofit

internal object GitHubNetwork {
    private const val GIT_HUB_BASE_URL = "https://api.github.com"
    private var gitHubServiceInstance: GitHubService? = null

    fun getGitHubService(): GitHubService {
        return gitHubServiceInstance
            ?: getRetrofit().create(GitHubService::class.java)
                .also { gitHubService -> gitHubServiceInstance = gitHubService }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(GIT_HUB_BASE_URL)
            .addConverterFactory(GsonConverter.getConverterFactory())
            .build()
    }
}