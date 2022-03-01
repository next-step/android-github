package camp.nextstep.edu.github.data.model

import com.google.gson.annotations.SerializedName

data class GitResponse(
    @SerializedName("full_name")
    val fullName: String,

    @SerializedName("description")
    val description: String
)