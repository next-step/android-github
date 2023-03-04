package camp.nextstep.edu.github.data.repository

import camp.nextstep.edu.github.data.api.RetrofitInstance.api
import camp.nextstep.edu.github.domain.GithubSearchRepository
import camp.nextstep.edu.github.domain.model.Repository

internal class GitHubSearchRepositoryImpl : GithubSearchRepository {
    override suspend fun searchGitHubs(): List<Repository> {
        return api.searchGithub().map { it.toDomain() }
    }
}
