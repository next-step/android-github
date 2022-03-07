package camp.nextstep.edu.github.domain.di

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.usecase.GetGithubRepositoriesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetGithubRepositoriesUseCase(githubRepository: GithubRepository): GetGithubRepositoriesUseCase =
        GetGithubRepositoriesUseCase(githubRepository)
}