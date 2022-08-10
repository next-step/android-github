package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataInjector {
    fun provideGithubRepository(baseUrl: String): GithubRepository {
        return GithubRepositoryImpl(provideGithubService(baseUrl))
    }

    private fun provideGithubService(baseUrl: String): GithubService =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubService::class.java)
}