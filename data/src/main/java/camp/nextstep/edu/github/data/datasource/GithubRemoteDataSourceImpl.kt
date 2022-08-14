package camp.nextstep.edu.github.data.datasource

import camp.nextstep.edu.github.data.model.mapper.toDomain
import camp.nextstep.edu.github.data.service.GithubService
import camp.nextstep.edu.github.domain.model.GithubRemoteStorage

internal class GithubRemoteDataSourceImpl(
    private val githubService: GithubService
) : GithubRemoteDataSource {
    override suspend fun getRepositories(): List<GithubRemoteStorage> =
        githubService.getRepositories().toDomain()
}