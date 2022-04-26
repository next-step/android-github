package camp.nextstep.edu.github.di

import camp.nextstep.edu.github.RepositoryAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryAdapterModule {
    @Provides
    fun providesRepositoryAdapter(): RepositoryAdapter = RepositoryAdapter()
}