package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface GithubRepoRepositoryModule {
    @Binds
    @Singleton
    fun bindGithubRepository(githubRepositoryImpl: GithubRepoRepositoryImpl): GithubRepoRepository
}