package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepo
import com.google.gson.annotations.SerializedName

internal data class GithubRepoResponse(
    @SerializedName("full_name")
    val name: String,
    @SerializedName("description")
    val description: String?
): DataToDomainMapper<GithubRepo> {
    override fun toDomain(): GithubRepo = GithubRepo(name, description)
}
