package camp.nextstep.edu.github.data

import retrofit2.http.GET

internal interface GithubService {

    @GET("repositories")
    suspend fun getRepositories(): List<RepositoryDto>
}
