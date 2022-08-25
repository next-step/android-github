package camp.nextstep.edu.github

import camp.nextstep.edu.github.domain.GithubRepository

data class GithubRepositoryUiModel(val fullName: String, val description: String)

fun GithubRepository.toUiModel(): GithubRepositoryUiModel =
    GithubRepositoryUiModel(fullName, description)
