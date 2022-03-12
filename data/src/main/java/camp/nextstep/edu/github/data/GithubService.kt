package camp.nextstep.edu.github.data

import retrofit2.Response
import retrofit2.http.GET

interface GithubService {

    @GET("repositories")
    suspend fun fetchGithubRepos(): Response<List<GithubRepoData>>
}