package camp.nextstep.edu.github.data.remote.response

import camp.nextstep.edu.github.domain.entity.GithubRepo

data class GithubRepoResponse(
    val id: Long,
    val name: String,
    val full_name: String,
    val description: String?,
) {
    fun toGithubRepo(): GithubRepo = GithubRepo(
        id = id,
        fullName = full_name,
        description = description.orEmpty()
    )
}
