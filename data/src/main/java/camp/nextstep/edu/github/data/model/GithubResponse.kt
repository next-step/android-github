package camp.nextstep.edu.github.data.model

import camp.nextstep.edu.github.data.mapper.DataToDomainMapper
import camp.nextstep.edu.github.domain.model.Github
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
internal data class GithubResponse(
    @SerializedName("full_name")
    val fullName: String? = null,
    val description: String? = null,
) : DataToDomainMapper<Github> {
    override fun mapper() = Github(
        fullName = fullName ?: "",
        description = description ?: ""
    )
}
