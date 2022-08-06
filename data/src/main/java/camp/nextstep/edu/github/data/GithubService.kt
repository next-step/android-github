package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GitRepoRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET
import camp.nextstep.edu.github.domain.GitRepo as DomainGitRepo

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

internal class GithubService(
    private val retrofit: Retrofit
) : GitRepoRepository {

    constructor() : this(RETROFIT)

    private val service: GithubRetrofitService = retrofit.create()

    suspend fun getRepositories(): List<GitRepo> {
        return service.getRepositories()
    }

    override suspend fun getGitRepos(): List<DomainGitRepo> {
        return getRepositories().map { with(it) { DomainGitRepo(fullName, description) } }
    }
}

internal interface GithubRetrofitService {
    @GET("/repositories")
    suspend fun getRepositories(): List<GitRepo>
