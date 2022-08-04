package camp.nextstep.edu.github.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by link.js on 2022. 08. 05..
 */
object GithubServiceFactory {
    private const val BASE_URL = "https://api.github.com"

    private val okHttpClient: OkHttpClient =
        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build()

    val githubApi: GithubService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(GithubService::class.java)
}