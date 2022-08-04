package camp.nextstep.edu.github.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET

internal class GithubService(
    private val retrofit: Retrofit,
) {

    private val service: GithubRetrofitService = retrofit.create()

    suspend fun getRepositories(): List<GithubRepository> {
        return service.getRepositories()
    }
}

internal interface GithubRetrofitService {
    @GET("/repositories")
    suspend fun getRepositories(): List<GithubRepository>
}

internal val retrofit = Retrofit.Builder()
    .baseUrl("https://api.github.com")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()