package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.RealGithubRepoRepository
import camp.nextstep.edu.github.domain.repository.GithubRepoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created By Malibin
 * on 9월 13, 2021
 */

@InstallIn(SingletonComponent::class)
@Module
internal interface RepositoryModule {

    @Binds
    @Singleton
    fun bindGithubRepoRepository(repository: RealGithubRepoRepository): GithubRepoRepository
}
