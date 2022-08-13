package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.DefaultGitHubRepository
import camp.nextstep.edu.github.data.GithubService
import camp.nextstep.edu.github.domain.GithubRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DataModule {
    @Provides
    @Singleton
    fun provideGithubService(): GithubService = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(GithubService::class.java)
}

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindGithubRepository(impl: DefaultGitHubRepository): GithubRepository
}
