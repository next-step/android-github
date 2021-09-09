package camp.nextstep.edu.github.data.remote.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

internal interface GithubService {

    companion object {
        private const val BASE_URL = ""
        fun newInstance(): GithubService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}
