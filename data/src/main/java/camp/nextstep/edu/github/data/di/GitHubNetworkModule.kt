package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.network.GitHubService
import camp.nextstep.edu.github.data.util.GsonConverter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object GitHubNetworkModule {
    private const val GIT_HUB_BASE_URL = "https://api.github.com"

    @Provides
    @Singleton
    fun provideGitHubService(): GitHubService {
        return getRetrofit().create(GitHubService::class.java)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(GIT_HUB_BASE_URL)
            .addConverterFactory(GsonConverter.getConverterFactory())
            .build()
    }
}