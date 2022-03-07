package camp.nextstep.edu.github.di

import camp.nextstep.edu.github.main.model.mappers.UiRepositoryMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class MapperModule {

    @Provides
    @Singleton
    fun provideUiRepositoryMapper(): UiRepositoryMapper = UiRepositoryMapper()
}