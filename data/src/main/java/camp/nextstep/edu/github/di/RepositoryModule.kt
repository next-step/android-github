package camp.nextstep.edu.github.di

import camp.nextstep.edu.github.GitHubRepository
import camp.nextstep.edu.github.GitHubRepositoryImpl
import camp.nextstep.edu.github.GithubService
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@dagger.Module
@InstallIn(SingletonComponent::class)
internal object RepositoryModule {

    @Provides
    fun githubRepository(githubService: GithubService) : GitHubRepository {
        return GitHubRepositoryImpl(githubService)
    }
}