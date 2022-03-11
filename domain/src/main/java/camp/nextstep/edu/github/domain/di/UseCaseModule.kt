package camp.nextstep.edu.github.domain.di

import camp.nextstep.edu.github.domain.repository.GithubRepository
import camp.nextstep.edu.github.domain.usecase.GithubRepositoryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object UseCaseModule {

    @Provides
    @Singleton
    fun provideGithubRepositoryUseCase(githubRepository: GithubRepository): GithubRepositoryUseCase =
        GithubRepositoryUseCase(githubRepository)
}
