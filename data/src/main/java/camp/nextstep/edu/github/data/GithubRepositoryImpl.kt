package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.RepositoryVO

internal class GithubRepositoryImpl(private val apiService: ApiService) : GithubRepository {
    override suspend fun getRepositories(): List<RepositoryVO> {
        val list: List<RepositoryDTO> = apiService.getRepositories()
        return list.map { RepositoryVO(it.fullName, it.description) }
    }
}
