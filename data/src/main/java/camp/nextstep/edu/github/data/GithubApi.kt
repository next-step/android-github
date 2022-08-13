package camp.nextstep.edu.github.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

internal interface GithubApi {

    @GET("repositories")
    suspend fun getGithubRepositories(): List<GithubRepositoryResponse>

    companion object {

        private const val BASE_URL = "https://api.github.com/"

        fun create(): GithubApi = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(GithubApi::class.java)
    }

}