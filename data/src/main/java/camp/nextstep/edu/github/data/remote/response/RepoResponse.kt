package camp.nextstep.edu.github.data.remote.response

import camp.nextstep.edu.github.domain.Repo
import com.google.gson.annotations.SerializedName

data class RepoResponse(
    @SerializedName("id")
    val id: Long? = null,
    @SerializedName("full_name")
    val fullName: String? = null,
    @SerializedName("description")
    val description: String? = null,
) {
    fun toEntity() = Repo(
        id = id ?: -1,
        fullName = fullName ?: "",
        description = description ?: "",
    )
}