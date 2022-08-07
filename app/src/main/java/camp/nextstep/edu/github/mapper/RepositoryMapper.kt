package camp.nextstep.edu.github.mapper

import camp.nextstep.edu.github.domain.model.Repository
import camp.nextstep.edu.github.model.RepositoryItem

internal fun Repository.toItem() = RepositoryItem(
    fullName = fullName,
    description = description ?: "null"
)
