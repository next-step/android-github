package camp.nextstep.edu.github.data.remote

import camp.nextstep.edu.github.domain.model.GitHub
import camp.nextstep.edu.github.domain.repository.GitHubRepository
import javax.inject.Inject

internal class GitHubRepositoryImpl @Inject constructor(
    private val gitHubDataSource: GitHubDataSource
) : GitHubRepository {
    override suspend fun fetch(): List<GitHub> = gitHubDataSource
        .fetch()
        .map { it.toDomain() }
}
