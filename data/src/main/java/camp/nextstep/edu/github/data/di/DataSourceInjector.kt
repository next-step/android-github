package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.datasource.GithubRemoteDataSource
import camp.nextstep.edu.github.data.datasource.GithubRemoteDataSourceImpl
import camp.nextstep.edu.github.data.service.GithubService

object DataSourceInjector {
    fun providesGithubRemoteDataSource(githubService: GithubService): GithubRemoteDataSource =
        GithubRemoteDataSourceImpl(githubService)
}