package camp.nextstep.edu.github.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

internal class GithubRetrofit(
    baseUrl: String = "https://api.github.com"
) {

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val githubService: GithubService = retrofit.create()
}
