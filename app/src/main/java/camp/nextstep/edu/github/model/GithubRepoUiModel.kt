package camp.nextstep.edu.github.model

import camp.nextstep.edu.github.domain.model.GithubRepositoryInfo

data class GithubRepoUiModel(
    val id: Long,
    val fullName: String,
    val description: String,
)

fun GithubRepositoryInfo.toUiModel(): GithubRepoUiModel {
    return GithubRepoUiModel(
        id = this.id,
        fullName = this.fullName,
        description = this.description,
    )
}
