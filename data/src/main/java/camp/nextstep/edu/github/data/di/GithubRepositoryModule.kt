package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.GitHubRepositoryImpl
import camp.nextstep.edu.github.domain.repository.GitHubRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class GithubRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindGithubRepository(gitHubRepositoryImpl: GitHubRepositoryImpl): GitHubRepository
}