package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.datasource.GithubDataSource
import camp.nextstep.edu.github.data.datasource.remote.RemoteGithubDataSource

internal object DataSourceModule {

    val githubDataSource: GithubDataSource = provideGithubDataSource()

    private fun provideGithubDataSource(): GithubDataSource = RemoteGithubDataSource()
}