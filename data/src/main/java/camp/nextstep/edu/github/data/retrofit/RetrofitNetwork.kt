package camp.nextstep.edu.github.data.retrofit

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val BASE_URL = "https://api.github.com/"

internal object RetrofitNetwork {

    private fun createOkhttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor())
        }.build()
    }

    private fun createJsonAdapterFactory(): Converter.Factory =
        MoshiConverterFactory.create(
            Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        )

    fun create(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .client(createOkhttpClient())
            .baseUrl(baseUrl)
            .addConverterFactory(createJsonAdapterFactory())
            .build()
    }
}
