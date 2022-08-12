package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository

internal fun GithubRepositoryResponse.toDomain(): GithubRepository {
    return GithubRepository(this.fullName, this.description)
}