package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.network.GitHubService
import camp.nextstep.edu.github.domain.model.GitHubRepositoryData
import camp.nextstep.edu.github.domain.repository.GitHubRepository
import java.lang.Exception

internal class GitHubRepositoryImpl(private val gitHubService: GitHubService) : GitHubRepository {
    companion object {
        private const val EMPTY = ""
    }

    override suspend fun getRepositories(): List<GitHubRepositoryData>? {
        return try {
            val response = gitHubService.getRepositories()
            response.body()?.let {
                it.map { repo -> GitHubRepositoryData(repo.full_name, repo.description ?: EMPTY) }
            }
        } catch(e: Exception) {
            null
        }
    }
}