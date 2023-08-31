package com.nextstep.edu.data.model

import com.nextstep.edu.domain.model.Repository

internal fun RepositoryResponse.toDomain(): Repository {
    return Repository(id = this.id, fullName = this.fullName, description = this.description)
}

internal fun List<RepositoryResponse>.toDomain(): List<Repository> {
    return this.map { data ->
        data.toDomain()
    }
}
