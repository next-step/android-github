package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.datasource.GithubDataSource
import camp.nextstep.edu.github.data.di.DataSourceModule
import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.model.Repositories
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

internal class DefaultGithubRepository(
    private val remoteDataSource: GithubDataSource = DataSourceModule.githubDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : GithubRepository {

    override fun getRepositories(): Flow<Repositories> = remoteDataSource.getReposotories()
        .map { Repositories(it) }
        .flowOn(dispatcher)
}