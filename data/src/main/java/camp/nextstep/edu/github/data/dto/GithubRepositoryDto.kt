package camp.nextstep.edu.github.data.dto

import com.google.gson.annotations.SerializedName

internal data class GithubRepositoryDto(
    @SerializedName("full_name") val fullName: String,
    @SerializedName("description") val description: String,
)
