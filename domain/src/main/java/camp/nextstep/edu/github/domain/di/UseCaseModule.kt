package camp.nextstep.edu.github.domain.di

import camp.nextstep.edu.github.domain.GetGithubRepositoriesUseCase
import camp.nextstep.edu.github.domain.GithubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGithubUseCase(githubRepository: GithubRepository): GetGithubRepositoriesUseCase {
        return GetGithubRepositoriesUseCase(githubRepository)
    }
}