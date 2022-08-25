package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import com.google.gson.annotations.SerializedName

internal data class GithubRepositoryDTO(
    @SerializedName("full_name") val fullName: String,
    @SerializedName("description") val description: String?
) : MapperToDomain<GithubRepository> {
    override fun toDomain(): GithubRepository =
        GithubRepository(fullName, description ?: "")
}