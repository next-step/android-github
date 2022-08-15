package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.datasource.GithubRemoteDataSource
import camp.nextstep.edu.github.data.datasource.GithubRemoteDataSourceImpl
import camp.nextstep.edu.github.data.service.GithubAPI
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

object DataSourceInjector {
    fun providesGithubRemoteDataSource(
        githubAPI: GithubAPI,
        ioDispatcher: CoroutineDispatcher = Dispatchers.IO
    ): GithubRemoteDataSource =
        GithubRemoteDataSourceImpl(githubAPI, ioDispatcher)
}