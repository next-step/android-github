package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.model.GitResponse
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

internal class GitRepository {
    fun getRepository(): List<GitResponse> {
        val service: GitService = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .baseUrl("https://api.github.com/")
            .build()
            .create()
        return service.getRepositories().execute().body()!!
    }
}