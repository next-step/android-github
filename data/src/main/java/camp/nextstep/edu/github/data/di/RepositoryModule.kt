package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.repository.DefaultGithubRepository
import camp.nextstep.edu.github.data.service.GithubService
import camp.nextstep.edu.github.data.entity.RepositoryMapper
import camp.nextstep.edu.github.domain.GithubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class RepositoryModule {

    @Provides
    @Singleton
    fun provideGithubRepository(githubService: GithubService): GithubRepository =
        DefaultGithubRepository(
            githubService = githubService,
            repositoryMapper = RepositoryMapper()
        )
}
