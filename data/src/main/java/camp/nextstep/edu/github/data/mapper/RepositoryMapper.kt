package camp.nextstep.edu.github.data.mapper

import camp.nextstep.edu.github.data.model.RepositoryDto
import camp.nextstep.edu.github.domain.model.Repository

internal fun RepositoryDto.toDomain() = Repository(
    fullName = fullName,
    description = description,
)
