package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.model.GitResponse
import retrofit2.Call
import retrofit2.http.GET

internal interface GitService {

    @GET("repositories")
    fun getRepositories(): Call<List<GitResponse>>

}