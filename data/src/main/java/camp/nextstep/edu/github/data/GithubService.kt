package camp.nextstep.edu.github.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET

private val OKHTTP = OkHttpClient.Builder()
    .addInterceptor(
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    )
    .build()

private val RETROFIT = Retrofit.Builder()
    .client(OKHTTP)
    .baseUrl("https://api.github.com")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

class GithubService(
    private val retrofit: Retrofit
) {

    constructor() : this(RETROFIT)

    private val service: GithubRetrofitService = retrofit.create()

    suspend fun getRepositories(): List<GithubRepository> {
        return service.getRepositories()
    }
}

internal interface GithubRetrofitService {
    @GET("/repositories")
    suspend fun getRepositories(): List<GithubRepository>
}