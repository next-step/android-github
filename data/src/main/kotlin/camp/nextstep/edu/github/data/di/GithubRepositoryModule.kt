package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.repository.GithubRepositoryImpl
import camp.nextstep.edu.github.domain.repository.GithubRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal abstract class GithubRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsGithubRepository(githubRepositoryImpl: GithubRepositoryImpl) : GithubRepository
}