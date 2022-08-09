package camp.nextstep.edu.github.data.model

import com.squareup.moshi.Json

internal data class GitHubRepositoryEntity(
    @field:Json(name="id") val id: Long,
    @field:Json(name="full_name") val fullName: String,
    @field:Json(name="description") val description: String
    )
