package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.datasource.GithubRemoteDataSource
import camp.nextstep.edu.github.data.datasource.GithubRemoteDataSourceImpl
import camp.nextstep.edu.github.data.service.GithubAPI

object DataSourceInjector {
    fun providesGithubRemoteDataSource(githubAPI: GithubAPI): GithubRemoteDataSource =
        GithubRemoteDataSourceImpl(githubAPI)
}