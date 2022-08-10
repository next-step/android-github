package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.model.BaseUrl
import camp.nextstep.edu.github.data.repository.GithubRepositoryImpl
import camp.nextstep.edu.github.data.retrofit.GithubRetrofit
import camp.nextstep.edu.github.data.retrofit.GithubService
import camp.nextstep.edu.github.domain.repository.GithubRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataModule {

    @Binds
    abstract fun bindGithubRepository(
        impl: GithubRepositoryImpl
    ): GithubRepository

    companion object {

        @Provides
        fun provideBaseUrl(): BaseUrl = BaseUrl("https://api.github.com")

        @Provides
        fun provideGithubService(
            githubRetrofit: GithubRetrofit
        ): GithubService = githubRetrofit.githubService
    }
}
