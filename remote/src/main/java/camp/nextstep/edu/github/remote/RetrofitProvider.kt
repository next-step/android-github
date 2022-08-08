package camp.nextstep.edu.github.remote

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

internal object RetrofitProvider {
    private val retrofit = Retrofit.Builder()
        .client(OkHttpClientProvider.get())
        .baseUrl("https://api.github.com")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    fun get(): Retrofit {
        return retrofit
    }

    fun getGithubService(): GithubService {
        return retrofit.create()
    }
}