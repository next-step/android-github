package camp.nextstep.edu.github.remote

import camp.nextstep.edu.github.data.DataException
import camp.nextstep.edu.github.data.GitRepoRepository
import retrofit2.HttpException
import camp.nextstep.edu.github.data.GitRepo as DataGitRepo

internal class RemoteGitRepoRepository(
    private val service: GithubService = RetrofitProvider.getGithubService()
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

object Injector {
    fun getGitRepoRepository(): GitRepoRepository {
        return RemoteGitRepoRepository()
    }
}