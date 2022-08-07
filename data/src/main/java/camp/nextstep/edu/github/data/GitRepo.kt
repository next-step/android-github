package camp.nextstep.edu.github.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class GitRepo(
    @Json(name = "full_name")
    val fullName: String,
    @Json(name = "description")
    val description: String?
)