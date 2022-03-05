package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.remote.GitHubDataSource
import camp.nextstep.edu.github.data.remote.GitHubRepositoryImpl
import camp.nextstep.edu.github.domain.repository.GitHubRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RemoteModule {

    @Binds
    @Singleton
    fun bindsGitHubRepository(gitHubRepositoryImpl: GitHubRepositoryImpl): GitHubRepository

    companion object {
        @Provides
        @Singleton
        fun providesGitHubDataSource(retrofit: Retrofit): GitHubDataSource = retrofit
            .create(GitHubDataSource::class.java)
    }
}
