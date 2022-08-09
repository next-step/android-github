package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.GithubService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataInjector {
    fun provideGithubRepository() : GithubRepository {
        return GithubRepositoryImpl(provideGithubService())
    }

    private fun provideGithubService(baseUrl: String = "https://api.github.com/"): GithubService = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GithubService::class.java)
}