package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * 클래스에 대한 간단한 설명이나 참고 url을 남겨주세요.
 * Created by jeongjinhong on 2022. 08. 06..
 */

@Module
@InstallIn(SingletonComponent::class)
internal abstract class GithubRepositoryModule {
    @Binds
    @Singleton
    abstract fun provideGithubRepository(defaultGithubRepository: DefaultGithubRepository): GithubRepository
}

