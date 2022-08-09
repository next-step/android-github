package camp.nextstep.edu.github.data.service

import camp.nextstep.edu.github.data.entity.RepositoryEntity
import retrofit2.http.GET

internal interface GithubService {

    @GET("repositories")
    suspend fun getRepositories(): List<RepositoryEntity>
}
