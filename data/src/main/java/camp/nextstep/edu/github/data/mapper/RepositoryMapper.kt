package camp.nextstep.edu.github.data.mapper

import camp.nextstep.edu.github.data.network.response.RepositoriesItem
import camp.nextstep.edu.github.domain.model.GitHubRepositoryData

internal fun List<RepositoriesItem>.toDomain(): List<GitHubRepositoryData> =
    this.map { GitHubRepositoryData(it.full_name, it.description.orEmpty()) }