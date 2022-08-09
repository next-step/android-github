package camp.nextstep.edu.github.remote

import camp.nextstep.edu.github.data.DataException
import camp.nextstep.edu.github.data.GitRepoRepository
import retrofit2.HttpException
import javax.inject.Inject
import camp.nextstep.edu.github.data.GitRepo as DataGitRepo

internal class RemoteGitRepoRepository @Inject constructor(
    private val service: GithubService
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
