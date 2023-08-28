package camp.nextstep.edu.github.data.network.di

import camp.nextstep.edu.github.data.network.GithubRepositoriesDataSource
import camp.nextstep.edu.github.data.network.GithubService
import camp.nextstep.edu.github.domain.network.GithubDataSource
import dagger.Binds
import dagger.hilt.InstallIn
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {

    @Binds
    internal abstract fun bindDataSource(dataSource: GithubRepositoriesDataSource): GithubDataSource

    companion object {
        private const val BASE_URL = "https://api.github2.com/"

        @Provides
        fun provideClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.SECONDS)
                .readTimeout(1, TimeUnit.SECONDS)
                .writeTimeout(1, TimeUnit.SECONDS)
                .build()
        }

        @Provides
        fun provideGithubService(client : OkHttpClient): GithubService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService::class.java)
        }
        @Provides
        fun provideGithubService(gitHubService: GithubService): GithubDataSource {
            return GithubRepositoriesDataSource(gitHubService)
        }

    }
}