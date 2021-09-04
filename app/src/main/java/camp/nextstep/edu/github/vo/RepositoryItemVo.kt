package camp.nextstep.edu.github.vo

import com.nextstep.edu.github.domain.dto.RepositoryItemDto

data class RepositoryItemVo(
    val fullName: String,
    val description: String
) {

    companion object {

        fun fromDto(dto: RepositoryItemDto): RepositoryItemVo = RepositoryItemVo(
            fullName = dto.fullName,
            description = dto.description
        )
    }
}
