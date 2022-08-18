package camp.nextstep.edu.github.data.repository

import camp.nextstep.edu.github.data.datasource.GithubRemoteDataSource
import camp.nextstep.edu.github.domain.model.GithubStorage
import camp.nextstep.edu.github.domain.repository.GithubRepository
import javax.inject.Inject

internal class GithubRepositoryImpl @Inject constructor(
    private val githubRemoteDataSource: GithubRemoteDataSource
) : GithubRepository {
    override suspend fun getRepositories(): Result<List<GithubStorage>> =
        githubRemoteDataSource.getRepositories()
}