package camp.nextstep.edu.github.model.mapper

import camp.nextstep.edu.github.domain.model.GithubStorage
import camp.nextstep.edu.github.model.GithubStorageModel

internal fun GithubStorage.toPresentation(): GithubStorageModel =
    GithubStorageModel(
        author = author,
        description = description,
    )

internal fun List<GithubStorage>.toPresentation(): List<GithubStorageModel> =
    map { it.toPresentation() }