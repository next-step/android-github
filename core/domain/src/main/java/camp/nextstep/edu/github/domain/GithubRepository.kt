package camp.nextstep.edu.github.domain

import com.google.gson.annotations.SerializedName

data class GithubRepository(
    @SerializedName("full_name")
    val fullName: String,
    val description: String
)
