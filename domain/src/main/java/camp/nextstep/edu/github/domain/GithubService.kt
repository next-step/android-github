package camp.nextstep.edu.github.domain

import retrofit2.http.GET

interface GithubService {
    @GET("/repositories")
    suspend fun listRepos(): List<Repo>
}