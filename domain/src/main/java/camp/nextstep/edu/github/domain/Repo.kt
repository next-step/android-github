package camp.nextstep.edu.github.domain

import com.google.gson.annotations.SerializedName

data class Repo(
    @SerializedName("full_name") val fullName: String = "",
    @SerializedName("description") val description: String = ""
)
