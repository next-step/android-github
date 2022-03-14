package camp.nextstep.edu.github.data.model

import camp.nextstep.edu.github.domain.Github
import com.google.gson.annotations.SerializedName

data class GitResponse(
    @SerializedName("full_name")
    val fullName: String,

    @SerializedName("description")
    val description: String
)

fun List<GitResponse>.toModelList(): List<Github> {
    return this.map {
        Github(
            fullName = it.fullName,
            description = it.description
        )
    }
}