package camp.nextstep.edu.github.data.datasource.remote

import camp.nextstep.edu.github.data.datasource.GithubDataSource
import camp.nextstep.edu.github.data.datasource.remote.response.mappers.ResponseRepositoryMapper
import camp.nextstep.edu.github.data.datasource.remote.service.GithubService
import camp.nextstep.edu.github.data.di.MapperModule
import camp.nextstep.edu.github.data.di.ServiceModule
import camp.nextstep.edu.github.domain.model.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class RemoteGithubDataSource @Inject constructor(
    private val githubService: GithubService,
    private val responseRepositoryMapper: ResponseRepositoryMapper
) : GithubDataSource {

    override fun getReposotories(): Flow<List<Repository>> = flow {
        githubService.getRepositories()
            .map(responseRepositoryMapper::mapToDomain)
            .also { emit(it) }
    }
}