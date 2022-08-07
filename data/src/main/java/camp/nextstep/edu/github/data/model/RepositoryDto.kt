package camp.nextstep.edu.github.data.model

import com.google.gson.annotations.SerializedName

data class RepositoryDto(
    @SerializedName("full_name") val fullName: String = "",
    @SerializedName("description") val description: String? = null,
)
