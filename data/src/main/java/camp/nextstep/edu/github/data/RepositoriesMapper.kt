package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.Repositories


internal class RepositoriesMapper {
    companion object {
        fun mapToDomain(modelList: List<RepoModel>) = Repositories(modelList.map(RepoMapper::mapToDomain))
    }
}