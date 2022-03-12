package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepoModel
import com.google.gson.annotations.SerializedName

data class GithubRepoData(
    @SerializedName("full_name")
    val fullName: String? = null,

    @SerializedName("description")
    val description: String? = null
)

fun List<GithubRepoData>.toModelList(): List<GithubRepoModel> {
    return this.map {
        GithubRepoModel(
            fullName = it.fullName,
            description = it.description
        )
    }
}