package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.model.GitHubRepositoryEntity
import camp.nextstep.edu.github.domain.GitHubRepository

internal fun List<GitHubRepositoryEntity>.mapToGitHubRepositoryList() : List<GitHubRepository> = map {
    it.mapToGitHubRepository()
}

internal fun GitHubRepositoryEntity.mapToGitHubRepository() : GitHubRepository =
    GitHubRepository(
        id = this.id,
        fullName = this.fullName,
        description = this.description
    )
