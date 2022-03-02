package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.datasource.remote.service.GithubService.Companion.BASE_ENDPOINT
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal object NetworkModule {

    val retrofit = provideRetrofit(provideOkHttpClient())

    private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_ENDPOINT)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    private fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }
}