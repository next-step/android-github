package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.datasource.RemoteDataSource
import camp.nextstep.edu.github.data.datasource.remote.GithubDataSource

internal object DataSourceModule {

    val githubDataSource: RemoteDataSource = provideGithubDataSource()

    private fun provideGithubDataSource(): RemoteDataSource = GithubDataSource()
}