package camp.nextstep.edu.github.data.repository

import camp.nextstep.edu.github.data.service.GitHubService
import camp.nextstep.edu.github.data.toDomain
import camp.nextstep.edu.github.domain.model.GitHubRepos
import camp.nextstep.edu.github.domain.repository.MainRepository
import javax.inject.Inject

internal class DefaultMainRepository @Inject constructor(
    private val gitHubService: GitHubService
) : MainRepository {
    override suspend fun getGitHubRepositories() : GitHubRepos {
        return gitHubService.getRepositories().toDomain()
    }
}
