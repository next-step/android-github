package camp.nextstep.edu.github.data.dto

import camp.nextstep.edu.github.domain.model.GithubRepositoryInfo
import com.google.gson.annotations.SerializedName

internal data class GithubRepositoryDto(
    @SerializedName("id") val id: Long?,
    @SerializedName("full_name") val fullName: String?,
    @SerializedName("description") val description: String?,
): DataToDomainMapper<GithubRepositoryInfo> {
    override fun toDomainModel(): GithubRepositoryInfo =
        GithubRepositoryInfo(
            id = id ?: 0,
            fullName = fullName ?: "",
            description = description ?: "",
        )
}
