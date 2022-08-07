package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.Repository

internal class RepositoryMapper : Mapper<RepositoryDto, Repository> {

    override fun toDomain(entity: RepositoryDto): Repository =
        Repository(
            fullName = entity.fullName,
            description = entity.description
        )

    override fun toEntity(domain: Repository): RepositoryDto =
        RepositoryDto(
            fullName = domain.fullName,
            description = domain.description
        )
}
