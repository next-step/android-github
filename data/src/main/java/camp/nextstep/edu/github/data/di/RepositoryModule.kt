package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.repository.DefaultMainRepository
import camp.nextstep.edu.github.domain.repository.MainRepository
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
    fun bindGithubRepository(repository: DefaultMainRepository): MainRepository
}
