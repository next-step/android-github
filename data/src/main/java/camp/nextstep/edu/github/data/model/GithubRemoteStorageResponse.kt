package camp.nextstep.edu.github.data.model

import camp.nextstep.edu.github.data.model.mapper.DataToDomainMapper
import camp.nextstep.edu.github.domain.model.GithubRemoteStorage
import com.google.gson.annotations.SerializedName

data class GithubRemoteStorageResponse(
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("description")
    val description: String?
) : DataToDomainMapper<GithubRemoteStorage> {
    override fun mapper(): GithubRemoteStorage = GithubRemoteStorage(
        fullName = fullName,
        description = description
    )
}