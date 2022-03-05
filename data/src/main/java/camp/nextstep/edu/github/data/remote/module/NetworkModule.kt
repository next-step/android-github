package camp.nextstep.edu.github.data.remote.module

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object NetworkModule {

    private const val baseUrl = "https://api.github.com/"

    internal fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(getOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun getOkHttpClient() = OkHttpClient.Builder().build()
}
