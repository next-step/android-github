/**
 * @author Daewon on 31,August,2023
 *
 */

package camp.nextstep.edu.github.data.network

import camp.nextstep.edu.github.data.retrofit.GithubService
import camp.nextstep.edu.github.data.toDomainModels
import camp.nextstep.edu.github.domain.model.GithubRepository
import camp.nextstep.edu.github.domain.repository.NetworkRepository


internal class DefaultNetworkRepository(
    private val githubService: GithubService
) : NetworkRepository {
    override suspend fun getRepositories(): Result<List<GithubRepository>> =
        runCatching { githubService.getRepositories().toDomainModels() }

}
