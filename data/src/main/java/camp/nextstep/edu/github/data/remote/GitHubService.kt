package camp.nextstep.edu.github.data.remote

import camp.nextstep.edu.github.data.dto.GitHubDto
import retrofit2.http.GET

internal interface GitHubService {

    @GET("repositories")
    suspend fun fetch(): List<GitHubDto>
}
