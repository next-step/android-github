package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.model.GitHubRepositoryEntity
import camp.nextstep.edu.github.domain.GitHubRepo

internal fun List<GitHubRepositoryEntity>.toDomain() : List<GitHubRepo> = map {
    it.toDomain()
}

internal fun GitHubRepositoryEntity.toDomain() : GitHubRepo =
    GitHubRepo(
        id = this.id,
        fullName = this.fullName,
        description = this.description
    )
