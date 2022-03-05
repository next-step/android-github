package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.datasource.GithubDataSource
import camp.nextstep.edu.github.data.datasource.remote.RemoteGithubDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindsGithubDataSource(githubDataSource: RemoteGithubDataSource): GithubDataSource
}