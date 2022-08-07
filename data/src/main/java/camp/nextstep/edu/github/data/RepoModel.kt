package camp.nextstep.edu.github.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class RepoModel(
    @Json(name="id") val id: Int,
    @Json(name="full_name") val fullName: String,
    @Json(name="description") val description: String?
)