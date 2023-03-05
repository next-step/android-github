package camp.nextstep.edu.github.data.repository

import camp.nextstep.edu.github.data.api.GitHubSearchApi
import camp.nextstep.edu.github.domain.GithubSearchRepository
import camp.nextstep.edu.github.domain.model.Repository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitHubSearchRepositoryImpl @Inject constructor(
    private val api: GitHubSearchApi
) : GithubSearchRepository {
    override suspend fun searchGitHubs(): List<Repository> {
        return api.searchGithub().map { it.toDomain() }
    }
}
