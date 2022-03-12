package camp.nextstep.edu.github.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object NetworkModule {
    private const val BASE_URL = "https://api.github.com/"

    private fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    val githubService: GithubService get() {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(provideOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubService::class.java)
    }
}