package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.GithubRepositoryImpl
import camp.nextstep.edu.github.domain.GithubRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {

    @Binds
    @Singleton
    fun bindsGithubRepository(impl: GithubRepositoryImpl): GithubRepository
}