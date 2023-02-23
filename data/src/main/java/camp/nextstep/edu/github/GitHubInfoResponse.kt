package camp.nextstep.edu.github

import com.google.gson.annotations.SerializedName

data class GitHubInfoResponse(
    @SerializedName("full_name")
    val fullName: String,

    @SerializedName("description")
    val description: String
) {
    fun fromGitHubInfoModel(): GitHubInfoModel {
        return GitHubInfoModel(
            fullName = fullName,
            description = description
        )
    }

    companion object {
        fun GitHubInfoModel.toGitHubInfoResponse(): GitHubInfoResponse {
            return GitHubInfoResponse(
                fullName = fullName,
                description = description
            )
        }
    }
}
