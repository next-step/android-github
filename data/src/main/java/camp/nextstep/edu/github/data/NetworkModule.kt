package camp.nextstep.edu.github.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal object NetworkModule {

    private const val baseUrl = "https://api.github.com/"

    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(provideOkHttpClient())
        .addConverterFactory(provideMoshiConverterFactory())
        .build()

    private fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .build()

    private fun provideMoshiConverterFactory(): MoshiConverterFactory = MoshiConverterFactory
        .create()
}
