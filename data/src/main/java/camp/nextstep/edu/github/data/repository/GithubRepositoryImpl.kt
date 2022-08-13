package camp.nextstep.edu.github.data.repository

import camp.nextstep.edu.github.data.datasource.GithubRemoteDataSource
import camp.nextstep.edu.github.domain.model.GithubRemoteStorage
import camp.nextstep.edu.github.domain.repository.GithubRepository

internal class GithubRepositoryImpl(
    private val githubRemoteDataSource: GithubRemoteDataSource
) : GithubRepository {
    override suspend fun getRepositories(): List<GithubRemoteStorage> =
        githubRemoteDataSource.getRepositories()
}