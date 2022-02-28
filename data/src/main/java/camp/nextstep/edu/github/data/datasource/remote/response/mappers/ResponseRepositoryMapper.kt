package camp.nextstep.edu.github.data.datasource.remote.response.mappers

import camp.nextstep.edu.github.data.datasource.remote.response.ResponseRepository
import camp.nextstep.edu.github.domain.model.Repository

internal class ResponseRepositoryMapper : ResponseMapper<ResponseRepository, Repository> {

    override fun mapToDomain(response: ResponseRepository) = Repository(
        fullName = response.fullName.orEmpty(),
        descriptions = response.description.orEmpty()
    )
}