package camp.nextstep.edu.github.domain.di

import camp.nextstep.edu.github.domain.repository.GithubRepository
import camp.nextstep.edu.github.domain.usecase.GetGithubStorageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GithubStorageUseCaseModule {

    @Provides
    @Singleton
    fun provideGetGithubStorageUseCase(githubRepository: GithubRepository): GetGithubStorageUseCase =
        GetGithubStorageUseCase(githubRepository)
}