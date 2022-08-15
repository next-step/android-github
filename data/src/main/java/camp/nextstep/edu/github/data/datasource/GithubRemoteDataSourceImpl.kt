package camp.nextstep.edu.github.data.datasource

import camp.nextstep.edu.github.data.model.mapper.toDomain
import camp.nextstep.edu.github.data.service.GithubAPI
import camp.nextstep.edu.github.domain.model.GithubStorage

internal class GithubRemoteDataSourceImpl(
    private val githubAPI: GithubAPI
) : GithubRemoteDataSource {
    override suspend fun getRepositories(): List<GithubStorage> =
        githubAPI.getRepositories().toDomain()
}