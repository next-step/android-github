package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

internal interface GitHubService {
    @GET("repositories")
    fun listRepos(): Call<List<RepoModel>>
}

object DataModule {
    fun provideGithubRepository(): GithubRepository = DefaultGitHubRepository(provideGitHubService())

    internal fun provideGitHubService(baseUrl: String = "https://api.github.com/"): GitHubService = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(GitHubService::class.java)
}