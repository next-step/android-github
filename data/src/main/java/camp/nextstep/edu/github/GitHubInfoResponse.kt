package camp.nextstep.edu.github

import com.google.gson.annotations.SerializedName

internal data class GitHubInfoResponse(
    @SerializedName("full_name")
    val fullName: String?,

    @SerializedName("description")
    val description: String?
) {
    fun toDomainModel(): GitHubRepositoryInfo {
        return GitHubRepositoryInfo(
            fullName = fullName ?: "",
            description = description ?: ""
        )
    }

    companion object {
        fun GitHubRepositoryInfo.fromGitHubInfoResponse(): GitHubInfoResponse {
            return GitHubInfoResponse(
                fullName = fullName,
                description = description
            )
        }
    }
}
