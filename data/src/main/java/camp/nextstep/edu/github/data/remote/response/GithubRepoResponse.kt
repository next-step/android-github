package camp.nextstep.edu.github.data.remote.response

import camp.nextstep.edu.github.domain.entity.GithubRepo
import com.google.gson.annotations.SerializedName

internal data class GithubRepoResponse(
    val id: Long,
    val name: String,
    @SerializedName("full_name")
    val fullName: String,
    val description: String?,
) {
    fun toGithubRepo(): GithubRepo = GithubRepo(
        id = id,
        fullName = fullName,
        description = description.orEmpty()
    )
}
