package camp.nextstep.edu.github.data.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object APIClient {

    private const val GITHUB_BASE_URL = "https://api.github.com"

    val retrofit = Retrofit.Builder()
        .client(getOkHttpClient())
        .baseUrl(GITHUB_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /** okHttp Builder 생성  */
    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }
}