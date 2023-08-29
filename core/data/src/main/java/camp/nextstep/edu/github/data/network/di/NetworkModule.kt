package camp.nextstep.edu.github.data.network.di

import camp.nextstep.edu.github.data.network.GithubService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@InstallIn(SingletonComponent::class)
@Module
abstract class NetworkModule {

    companion object {
        private const val BASE_URL = "https://api.github.com/"

        @Provides
        fun provideClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.SECONDS)
                .readTimeout(1, TimeUnit.SECONDS)
                .writeTimeout(1, TimeUnit.SECONDS)
                .build()
        }

        @Provides
        fun provideGithubService(retrofit: Retrofit): GithubService {
            return retrofit.create(GithubService::class.java)
        }

        @Provides
        fun provideRetrofit(client: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
