/**
 * @author Daewon on 31,August,2023
 *
 */

package camp.nextstep.edu.github.domain.repository

import camp.nextstep.edu.github.domain.model.GithubRepository


interface NetworkRepository {
    suspend fun getRepositories(): Result<List<GithubRepository>>
}
