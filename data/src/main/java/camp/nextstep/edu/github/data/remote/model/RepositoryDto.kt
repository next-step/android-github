package camp.nextstep.edu.github.data.remote.model

import camp.nextstep.edu.github.domain.model.Repository
import com.google.gson.annotations.SerializedName

internal data class RepositoryDto(
    @SerializedName("full_name")
    val fullName: String?,
    @SerializedName("description")
    val description: String?
)

internal fun RepositoryDto.mapToDomain() = Repository(
    fullName = fullName ?: "",
    description = description ?: ""
)