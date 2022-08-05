package camp.nextstep.edu.github.data.dto

import camp.nextstep.edu.github.domain.model.GithubRepositoryInfo
import com.google.gson.annotations.SerializedName

internal data class GithubRepositoryDto(
    @SerializedName("full_name") val fullName: String,
    @SerializedName("description") val description: String,
) {
    fun toDomainModel(): GithubRepositoryInfo =
        GithubRepositoryInfo(fullName = fullName, description = description)
}
