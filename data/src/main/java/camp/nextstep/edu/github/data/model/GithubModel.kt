package camp.nextstep.edu.github.data.model

import camp.nextstep.edu.github.domain.Github
import com.google.gson.annotations.SerializedName

internal data class GithubModel(
    @SerializedName("full_name")
    val fullName: String,

    @SerializedName("description")
    val description: String
)

internal fun List<GithubModel>.toModelList(): List<Github> {
    return this.map {
        Github(
            fullName = it.fullName,
            description = it.description
        )
    }
}