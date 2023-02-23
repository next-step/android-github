package camp.nextstep.edu.github

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET(URL.repositories)
    fun getGitHubRepository(): Call<GitHubInfoResponse>
}