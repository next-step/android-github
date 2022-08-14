package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.GithubApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun providesGithubApi(): GithubApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(provideMoshiConverterFactory())
        .build()
        .create(GithubApi::class.java)

    @Provides
    @Singleton
    fun provideMoshiConverterFactory(): MoshiConverterFactory = MoshiConverterFactory.create()

    private const val BASE_URL = "https://api.github.com"

}