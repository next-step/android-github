package camp.nextstep.edu.github.data.di

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object NetworkInjector {
    private const val BASE_URL = "https://api.github.com/"
    fun providerRetrofit(): Retrofit {
        val okHttpClient = OkHttpClient
            .Builder()
            .build()

        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}