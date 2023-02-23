package camp.nextstep.edu.github

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object RetrofitManager {
    private const val BASE_URL = "https://api.github.com"
    private val gson = GsonBuilder().setLenient().create()

    val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(BASE_URL)
        .build()
}