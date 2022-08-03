package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.service.GithubService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkObject {
    private val okHttpClient: OkHttpClient
        = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build()

    val githubApi : GithubService by lazy {
        Retrofit
            .Builder()
            .baseUrl("http://api.github.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubService::class.java)
    }
}