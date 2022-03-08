package camp.nextstep.edu.github.util

import camp.nextstep.edu.github.data.util.GsonConverter
import camp.nextstep.edu.github.data.network.GitHubService
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit

internal object TestGitHubService {
    fun getGitHubService(server: MockWebServer): GitHubService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverter.getConverterFactory())
            .baseUrl(server.url(""))
            .build()
            .create(GitHubService::class.java)
    }
}