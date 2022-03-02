package camp.nextstep.edu.github.data.datasource.remote

import camp.nextstep.edu.github.data.datasource.GithubDataSource
import camp.nextstep.edu.github.data.datasource.remote.response.mappers.ResponseRepositoryMapper
import camp.nextstep.edu.github.data.datasource.remote.service.GithubService
import camp.nextstep.edu.github.data.di.MapperModule
import camp.nextstep.edu.github.data.di.ServiceModule
import camp.nextstep.edu.github.domain.model.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class RemoteGithubDataSource(
    private val githubService: GithubService = ServiceModule.githubService,
    private val responseRepositoryMapper: ResponseRepositoryMapper = MapperModule.responseRepositoryMapper
) : GithubDataSource {

    override fun getReposotories(): Flow<List<Repository>> = flow {
        githubService.getRepositories()
            .map(responseRepositoryMapper::mapToDomain)
            .also { emit(it) }
    }
}