package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.Repo

internal class RepoMapper {
    companion object {
        fun mapToDomain(model: RepoModel): Repo = Repo(model.id, model.fullName, model.description)
    }
}