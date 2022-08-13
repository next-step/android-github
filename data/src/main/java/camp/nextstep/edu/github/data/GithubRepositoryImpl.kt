package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.RepositoryVO
import javax.inject.Inject

internal class GithubRepositoryImpl @Inject constructor(private val apiService: ApiService) : GithubRepository {
    override suspend fun getRepositories(): List<RepositoryVO> {
        val repositories: List<RepositoryDTO> = apiService.getRepositories()
        return repositories.map { RepositoryVO(it.fullName, it.description) }
    }
}
