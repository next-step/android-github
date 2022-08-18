package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.NetworkRepositoryImpl
import camp.nextstep.edu.github.domain.NetworkRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsRepository(networkRepositoryImpl: NetworkRepositoryImpl): NetworkRepository

}