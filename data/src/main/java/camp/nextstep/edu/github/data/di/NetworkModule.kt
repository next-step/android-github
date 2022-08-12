package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.service.GitHubService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class NetworkModule {
    @Provides
    @Singleton
    fun provideGitHubService(okHttpClient: OkHttpClient): GitHubService =
        Retrofit.Builder()
            .baseUrl(GitHubService.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(GitHubService::class.java)

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder().build()
}
