package camp.nextstep.edu.github.data.model

import camp.nextstep.edu.github.domain.model.Repository
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RepositoryEntity(
    @field:Json(name = "full_name")
    val fullName: String,
    @field:Json(name = "description")
    val description: String?
) {
    fun toDomain(): Repository = Repository(
        fullName = fullName,
        description = description,
    )

    companion object {
        fun from(repository: Repository): RepositoryEntity = RepositoryEntity(
            fullName = repository.fullName,
            description = repository.description,
        )
    }
}
