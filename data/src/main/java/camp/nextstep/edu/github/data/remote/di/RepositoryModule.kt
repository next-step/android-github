package camp.nextstep.edu.github.data.remote.di

import camp.nextstep.edu.github.data.remote.service.GithubService
import camp.nextstep.edu.github.data.repository.GithubRepositoryImpl
import camp.nextstep.edu.github.domain.repository.GithubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RepositoryModule {

    @Provides
    @Singleton
    fun provideGithubRepository(service: GithubService): GithubRepository =
        GithubRepositoryImpl(service)
}
