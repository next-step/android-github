package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.GithubService
import camp.nextstep.edu.github.domain.Repo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class GithubRepositoryImpl(
    private val gitHubService: GithubService
) : GithubRepository {
//    fun getGithubService(): GithubService {
//        return retrofit().create(GithubService::class.java)
//    }

    override suspend fun getRepositories(): List<Repo> {
        TODO("Not yet implemented")
    }
}