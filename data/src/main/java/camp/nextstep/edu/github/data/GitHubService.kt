package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

internal interface GithubService {
    @GET("repositories")
    suspend fun listRepos(): List<GithubRepositoryResponse>
}