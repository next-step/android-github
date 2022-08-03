package camp.nextstep.edu.github.data.service

import camp.nextstep.edu.github.data.dto.GithubRepositoryDto
import retrofit2.http.GET

interface GithubService {
    @GET("/repositories")
    fun getRepositories(): List<GithubRepositoryDto>
}
