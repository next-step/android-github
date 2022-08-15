package camp.nextstep.edu.github

import camp.nextstep.edu.github.domain.GithubRepositoryResponse

data class GithubRepositoryUiModel(val fullName: String, val description: String)

fun GithubRepositoryResponse.toUiModel(): GithubRepositoryUiModel =
    GithubRepositoryUiModel(fullName, description)
