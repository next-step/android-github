package camp.nextstep.edu.github.data.retrofit

import camp.nextstep.edu.github.data.model.RepositoryDto
import retrofit2.http.GET

interface GithubService {

    @GET("/repositories")
    suspend fun fetchRepositoryList(): List<RepositoryDto>
}
