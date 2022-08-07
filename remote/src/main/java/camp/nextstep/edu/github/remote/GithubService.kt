package camp.nextstep.edu.github.remote

import camp.nextstep.edu.github.data.DataException
import camp.nextstep.edu.github.data.GitRepoRepository
import retrofit2.HttpException
import retrofit2.create
import retrofit2.http.GET
import camp.nextstep.edu.github.data.GitRepo as DataGitRepo

internal class GithubService(
    private val service: GithubRetrofitService = RetrofitProvider.get().create()
) : GitRepoRepository {

    override suspend fun getGitRepos(): List<DataGitRepo> {
        try {
            return service.getRepositories().map { with(it) { DataGitRepo(fullName, description) } }
        } catch (e: HttpException) {
            throw DataException(e.message())
        } catch (e: Throwable) {
            throw DataException(e.message.orEmpty())
        }
    }
}

internal interface GithubRetrofitService {
    @GET("/repositories")
    suspend fun getRepositories(): List<GitRepo>
}

object Injector {
    fun getGitRepoRepository(): GitRepoRepository {
        return GithubService()
    }
}