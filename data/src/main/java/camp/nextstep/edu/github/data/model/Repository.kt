package camp.nextstep.edu.github.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class Repository(
    @field:Json(name = "full_name")
    val fullName: String,
    @field:Json(name = "description")
    val description: String?
)
