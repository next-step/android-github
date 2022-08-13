package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepo
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class GithubRepositoryResponse(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "full_name") val fullName: String,
    @Json(name = "description") val description: String?
) : DataToDomainMapper<GithubRepo> {
    override fun toDomain(): GithubRepo = GithubRepo(id, name, fullName, description ?: "")
}