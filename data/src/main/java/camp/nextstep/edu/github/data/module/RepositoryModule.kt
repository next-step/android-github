package camp.nextstep.edu.github.data.module

import camp.nextstep.edu.github.data.GitHubRepositoryImpl
import camp.nextstep.edu.github.data.GitHubService
import camp.nextstep.edu.github.domain.GitHubRepository
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
    fun bindsGitHubRepository(
        gitHubService: GitHubService
    ): GitHubRepository {
        return GitHubRepositoryImpl(
            gitHubService
        )
    }
}