package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.remote.GitHubService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal class RemoteModule {

    @Provides
    @Singleton
    fun providesGitHubService(retrofit: Retrofit): GitHubService = retrofit
        .create(GitHubService::class.java)
}
