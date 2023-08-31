package camp.nextstep.edu.github.data.response

import com.squareup.moshi.Json

data class GithubRepositoryResponse(
    @Json(name = "full_name")
    val fullName: String,
    @Json(name = "description")
    val description: String?
)
