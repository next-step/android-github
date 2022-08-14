package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepositoryData

internal object GithubDataMapper {
    fun repositoryDTOtoRepositoryData(repositoryDTO: GithubRepositoryDTO) =
        GithubRepositoryData(repositoryDTO.fullName, repositoryDTO.description ?: "")
}