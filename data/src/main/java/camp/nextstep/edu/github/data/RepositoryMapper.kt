package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.Repository

internal class RepositoryMapper : Mapper<RepositoryEntity, Repository> {

    override fun toDomain(entity: RepositoryEntity): Repository =
        Repository(
            fullName = entity.fullName.orEmpty(),
            description = entity.description.orEmpty()
        )

    override fun toEntity(domain: Repository): RepositoryEntity =
        RepositoryEntity(
            fullName = domain.fullName,
            description = domain.description
        )
}
