package camp.nextstep.edu.github.data.repository

import camp.nextstep.edu.github.data.dto.GithubRepositoryDto
import camp.nextstep.edu.github.data.service.GithubService
import javax.inject.Inject

internal class GithubRepositoryImpl @Inject constructor(private val githubApi: GithubService) {
    suspend fun getRepositories(): List<GithubRepositoryDto> {
        return githubApi.getRepositories()
    }
}
