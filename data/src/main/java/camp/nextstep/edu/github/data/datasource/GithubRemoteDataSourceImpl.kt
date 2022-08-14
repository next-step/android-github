package camp.nextstep.edu.github.data.datasource

import camp.nextstep.edu.github.data.model.mapper.toDomain
import camp.nextstep.edu.github.data.service.GithubService
import camp.nextstep.edu.github.domain.model.GithubStorage

internal class GithubRemoteDataSourceImpl(
    private val githubService: GithubService
) : GithubRemoteDataSource {
    override suspend fun getRepositories(): List<GithubStorage> =
        githubService.getRepositories().toDomain()
}