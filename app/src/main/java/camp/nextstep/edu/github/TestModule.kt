package camp.nextstep.edu.github

import camp.nextstep.edu.github.data.DefaultGithubRepository
import camp.nextstep.edu.github.domain.GithubRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * 클래스에 대한 간단한 설명이나 참고 url을 남겨주세요.
 * Created by jeongjinhong on 2022. 08. 06..
 */

@Module
@InstallIn(ViewModelComponent::class)
abstract class TestModule {
    @Binds
    abstract fun bindRepository(defaultGithubRepository: DefaultGithubRepository): GithubRepository
}

