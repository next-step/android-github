package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.datasource.remote.response.mappers.ResponseRepositoryMapper
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
    fun provideResponseRepositoryMapper(): ResponseRepositoryMapper = ResponseRepositoryMapper()
}