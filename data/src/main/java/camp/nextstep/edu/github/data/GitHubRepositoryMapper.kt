package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GitHubRepositoryItem

internal fun GitHubRepositoryResponse.toGitHubRepositoryItem() =
    GitHubRepositoryItem(fullName.orEmpty(), description.orEmpty())