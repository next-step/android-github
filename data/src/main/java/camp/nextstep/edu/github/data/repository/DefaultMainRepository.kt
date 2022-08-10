package camp.nextstep.edu.github.data.repository

import camp.nextstep.edu.github.data.service.GitHubService
import camp.nextstep.edu.github.data.toDomain
import camp.nextstep.edu.github.domain.GitHubRepos
import camp.nextstep.edu.github.domain.MainRepository

internal class DefaultMainRepository(
    private val gitHubService: GitHubService
) : MainRepository {
    override suspend fun getGitHubRepositories() : GitHubRepos {
        return gitHubService.getRepositories().toDomain()
    }
}
