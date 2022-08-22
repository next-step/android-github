package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.datasource.GithubRemoteDataSource
import camp.nextstep.edu.github.data.datasource.GithubRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindGithubRemoteDataSource(
        githubRemoteDataSourceImpl: GithubRemoteDataSourceImpl
    ): GithubRemoteDataSource
}