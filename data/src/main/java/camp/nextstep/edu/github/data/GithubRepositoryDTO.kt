package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepositoryData
import com.google.gson.annotations.SerializedName

internal data class GithubRepositoryDTO(
    @SerializedName("full_name") val fullName: String,
    @SerializedName("description") val description: String?
) : MapperToDomain<GithubRepositoryData> {
    override fun toDomain(): GithubRepositoryData =
        GithubRepositoryData(fullName, description ?: "")
}