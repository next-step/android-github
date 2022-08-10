package camp.nextstep.edu.github.data

import com.google.gson.annotations.SerializedName

data class RepositoryDTO(
    @SerializedName("full_name")
    val fullName: String?,
    @SerializedName("description")
    val description: String?
): DTO
