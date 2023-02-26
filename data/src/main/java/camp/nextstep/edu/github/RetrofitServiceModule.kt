package camp.nextstep.edu.github

import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@dagger.Module
internal object RetrofitServiceModule {

    @Provides
    fun provideGitHubService() : GithubService = RetrofitManager.githubService
}