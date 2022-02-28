package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.datasource.remote.service.GithubService
import retrofit2.Retrofit

internal object ServiceModule {

    val githubService = provideGithubService(NetworkModule.retrofit)

    private fun provideGithubService(retrofit: Retrofit): GithubService {
        return retrofit.create(GithubService::class.java)
    }
}