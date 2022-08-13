package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by link.js on 2022. 08. 13..
 */
@Module
@InstallIn(SingletonComponent::class)
internal interface GithubRepositoryModule {
    @Binds
    @Singleton
    fun bindGithubRepository(repository: GithubRepositoryImpl): GithubRepository
}