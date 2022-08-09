package camp.nextstep.edu.github.remote.di

import camp.nextstep.edu.github.data.GitRepoRepository
import camp.nextstep.edu.github.remote.RemoteGitRepoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindGitRepoRepository(impl: RemoteGitRepoRepository): GitRepoRepository
}