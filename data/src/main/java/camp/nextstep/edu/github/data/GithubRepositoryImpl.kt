package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.remote.GithubRemoteDataSource
import camp.nextstep.edu.github.data.remote.response.RepoResponse
import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class GithubRepositoryImpl(
    private val remoteDataSource: GithubDataSource = GithubRemoteDataSource()
) : GithubRepository {
    override suspend fun loadRepos(): Result<List<Repo>> = withContext(Dispatchers.IO) {
        return@withContext try {
            val repos = remoteDataSource.loadRepos().map(RepoResponse::toEntity)
            Result.success(repos)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
