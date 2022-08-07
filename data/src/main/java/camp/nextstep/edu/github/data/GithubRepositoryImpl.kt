package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.GithubService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class GithubRepositoryImpl: GithubRepository {
    companion object {
        private const val BASE_URL = "https://api.github.com"
    }

    private fun retrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override suspend fun getGithubService(): GithubService {
        return retrofit().create(GithubService::class.java)
    }
}