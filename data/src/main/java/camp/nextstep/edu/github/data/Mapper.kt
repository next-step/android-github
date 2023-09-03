/**
 * @author Daewon on 01,September,2023
 *
 */

package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.response.RepositoryItemResponse
import camp.nextstep.edu.github.domain.model.RepositoryItem

internal fun List<RepositoryItemResponse>.toDomainModels(): List<RepositoryItem> {
    return this.map { it.toDomainModel() }
}

internal fun RepositoryItemResponse.toDomainModel(): RepositoryItem {
    return RepositoryItem(
        fullName = fullName,
        description = description
    )
}
