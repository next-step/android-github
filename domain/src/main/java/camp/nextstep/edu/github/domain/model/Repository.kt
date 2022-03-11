package camp.nextstep.edu.github.domain.model

import camp.nextstep.edu.github.domain.model.base.BaseEntity

data class Repositories(
    val items: List<Repository>
) : BaseEntity()

data class Repository(
    val fullName: String,
    val description: String
)
