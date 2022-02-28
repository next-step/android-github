package camp.nextstep.edu.github.data.datasource.remote

import camp.nextstep.edu.github.data.datasource.RemoteDataSource
import camp.nextstep.edu.github.data.datasource.remote.response.mappers.ResponseRepositoryMapper
import camp.nextstep.edu.github.data.datasource.remote.service.GithubService
import camp.nextstep.edu.github.data.di.MapperModule
import camp.nextstep.edu.github.data.di.ServiceModule
import camp.nextstep.edu.github.domain.model.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class GithubDataSource(
    private val githubService: GithubService = ServiceModule.githubService,
    private val responseRepositoryMapper: ResponseRepositoryMapper = MapperModule.responseRepositoryMapper
) : RemoteDataSource {

    override fun getReposotories(): Flow<List<Repository>> = flow {
        val responseRepositoryList = githubService.getRepositories()
        val repositoryList = responseRepositoryList.map(responseRepositoryMapper::mapToDomain)

        emit(repositoryList)
    }
}