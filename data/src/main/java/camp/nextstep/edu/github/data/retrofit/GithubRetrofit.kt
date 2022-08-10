package camp.nextstep.edu.github.data.retrofit

import camp.nextstep.edu.github.data.model.BaseUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Inject

internal class GithubRetrofit @Inject constructor(
    baseUrl: BaseUrl
) {

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl.toString())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val githubService: GithubService = retrofit.create()
}
