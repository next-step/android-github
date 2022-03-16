package camp.nextstep.edu.github.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class IoDispatcherModule {
    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO
}