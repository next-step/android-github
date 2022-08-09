package camp.nextstep.edu.github.domain

import retrofit2.Call
import retrofit2.http.GET

interface GithubService {
    @GET("/repositories")
    fun listRepos(): Call<List<Repo>>
}