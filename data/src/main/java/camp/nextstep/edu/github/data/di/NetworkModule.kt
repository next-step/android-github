package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.service.GitHubService
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@InstallIn(SingletonComponent::class)
@Module
internal object NetworkModule {
    fun provideGitHubService(): GitHubService =
        Retrofit.Builder()
            .baseUrl(GitHubService.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(GitHubService::class.java)
}
