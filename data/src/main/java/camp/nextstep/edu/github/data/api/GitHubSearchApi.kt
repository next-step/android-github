package camp.nextstep.edu.github.data.api

import camp.nextstep.edu.github.data.model.RepositoryEntity
import retrofit2.http.GET

interface GitHubSearchApi {
    @GET("repositories")
    suspend fun searchGithub(): List<RepositoryEntity>

}
