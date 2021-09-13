package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.remote.service.GithubService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

/**
 * Created By Malibin
 * on 9월 13, 2021
 */

@InstallIn(SingletonComponent::class)
@Module
internal object RetrofitModule {
    private const val BASE_URL = "https://api.github.com"

    @Provides
    @Singleton
    fun provideGithubService(): GithubService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}
