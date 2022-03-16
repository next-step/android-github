package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class GithubRepositoryModule {

    @Binds
    abstract fun provideGithubRepository(repository: GithubRepositoryImpl): GithubRepository
}