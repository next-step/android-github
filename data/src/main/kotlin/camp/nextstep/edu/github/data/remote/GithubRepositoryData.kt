package camp.nextstep.edu.github.data.remote

import camp.nextstep.edu.github.domain.model.GithubRepoModel
import com.google.gson.annotations.SerializedName

internal data class GithubRepositoryData(
    @SerializedName("full_name")
    val fullName: String?,
    @SerializedName("description")
    val description: String?
) {
    fun convertToDomain() : GithubRepoModel {
        return GithubRepoModel(
            fullName = fullName ?: "",
            description = description ?: ""
        )
    }
}