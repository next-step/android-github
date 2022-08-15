package camp.nextstep.edu.github.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class GithubNetwork {
    @Provides
    @Singleton
    fun provideGithubService(): GithubNetworkService =
        Retrofit.Builder()
            .baseUrl(GITHUB_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubNetworkService::class.java)

    companion object {
        private const val GITHUB_BASE_URL = "https://api.github.com/"
    }
}