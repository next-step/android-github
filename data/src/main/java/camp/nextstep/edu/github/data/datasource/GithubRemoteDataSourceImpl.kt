package camp.nextstep.edu.github.data.datasource

import camp.nextstep.edu.github.data.di.IoDispatcher
import camp.nextstep.edu.github.data.model.mapper.toDomain
import camp.nextstep.edu.github.data.service.GithubAPI
import camp.nextstep.edu.github.domain.model.GithubStorage
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class GithubRemoteDataSourceImpl @Inject constructor(
    private val githubAPI: GithubAPI,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : GithubRemoteDataSource {
    override suspend fun getRepositories(): Result<List<GithubStorage>> = runCatching {
        withContext(ioDispatcher) {
            githubAPI.getRepositories().toDomain()
        }
    }
}