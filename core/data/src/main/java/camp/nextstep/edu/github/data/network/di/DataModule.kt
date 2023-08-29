package camp.nextstep.edu.github.data.network.di

import camp.nextstep.edu.github.data.network.GithubRepositoriesDataSource
import camp.nextstep.edu.github.domain.network.GithubDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {

    @Binds
    internal abstract fun bindDataSource(dataSource: GithubRepositoriesDataSource): GithubDataSource
}
