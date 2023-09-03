/**
 * @author Daewon on 31,August,2023
 *
 */

package camp.nextstep.edu.github.data.network

import camp.nextstep.edu.github.data.retrofit.GithubService
import camp.nextstep.edu.github.data.toDomainModels
import camp.nextstep.edu.github.domain.model.RepositoryItem
import camp.nextstep.edu.github.domain.repository.GithubRepository
import javax.inject.Inject

internal class DefaultGithubRepository @Inject constructor(
    private val githubService: GithubService
) : GithubRepository {
    override suspend fun getRepositories(): Result<List<RepositoryItem>> =
        runCatching { githubService.getRepositories().toDomainModels() }

}
