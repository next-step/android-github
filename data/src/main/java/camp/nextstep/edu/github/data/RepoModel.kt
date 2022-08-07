package camp.nextstep.edu.github.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class RepoModel(
    @field:Json(name="id") val id: Int,
    @field:Json(name="full_name") val fullName: String,
    @field:Json(name="description") val description: String?
)