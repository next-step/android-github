package camp.nextstep.edu.github.data.model

import camp.nextstep.edu.github.domain.GitResponseData
import com.google.gson.annotations.SerializedName

data class GitResponse(
    @SerializedName("full_name")
    val fullName: String,

    @SerializedName("description")
    val description: String
)

fun List<GitResponse>.toModelList(): List<GitResponseData> {
    return this.map {
        GitResponseData(
            fullName = it.fullName,
            description = it.description
        )
    }
}