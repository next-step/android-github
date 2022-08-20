package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepoRepository
import camp.nextstep.edu.github.domain.GithubRepository
import javax.inject.Inject

internal class GithubRepoRepositoryImpl @Inject constructor(private val githubNetworkService: GithubNetworkService) :
    GithubRepoRepository {

    override suspend fun getRepositories(): Result<List<GithubRepository>> = runCatching {
        githubNetworkService.getRepositories().map(GithubRepositoryDTO::toDomain)
    }
}