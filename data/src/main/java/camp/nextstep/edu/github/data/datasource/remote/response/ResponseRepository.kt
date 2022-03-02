package camp.nextstep.edu.github.data.datasource.remote.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class ResponseRepository(

    @Json(name = "full_name")
    val fullName: String? = null,

    @Json(name = "description")
    val description: String? = null,
)