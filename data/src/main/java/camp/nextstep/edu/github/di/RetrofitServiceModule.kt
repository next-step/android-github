package camp.nextstep.edu.github.di

import camp.nextstep.edu.github.GithubService
import camp.nextstep.edu.github.RetrofitManager
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@dagger.Module
internal object RetrofitServiceModule {

    @Provides
    fun provideGitHubService() : GithubService = RetrofitManager.githubService
}