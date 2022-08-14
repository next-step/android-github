package camp.nextstep.edu.github.data.model

import camp.nextstep.edu.github.data.model.mapper.DataToDomainMapper
import camp.nextstep.edu.github.domain.model.GithubStorage
import com.google.gson.annotations.SerializedName

data class GithubStorageResponse(
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("description")
    val description: String?
) : DataToDomainMapper<GithubStorage> {
    override fun toDomain(): GithubStorage = GithubStorage(
        fullName = fullName,
        description = description
    )
}