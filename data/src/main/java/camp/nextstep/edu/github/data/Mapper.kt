/**
 * @author Daewon on 01,September,2023
 *
 */

package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.response.GithubRepositoryResponse
import camp.nextstep.edu.github.domain.model.GithubRepository

internal fun List<GithubRepositoryResponse>.toDomainModels(): List<GithubRepository> {
    return this.map { it.toDomainModel() }
}

internal fun GithubRepositoryResponse.toDomainModel(): GithubRepository {
    return GithubRepository(
        fullName = fullName,
        description = description
    )
}
