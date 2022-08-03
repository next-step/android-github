package camp.nextstep.edu.github.data.service

import camp.nextstep.edu.github.data.dto.GitRepoDto
import retrofit2.http.GET

interface GithubService {
    @GET("repositories")
    suspend fun getRepositories() : List<GitRepoDto>
}