package camp.nextstep.edu.github.data.network

import camp.nextstep.edu.github.domain.GithubRepository
import retrofit2.http.GET

interface GithubService {
    @GET("repositories")
    suspend fun getRepositories(): List<GithubRepository>
}
