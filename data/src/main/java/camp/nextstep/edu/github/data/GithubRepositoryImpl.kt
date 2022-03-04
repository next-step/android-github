package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.mapper.mapping
import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.model.Github

internal class GithubRepositoryImpl(
    private val githubService: GithubService,
) : GithubRepository {
    override suspend fun getGithubRepositories(): List<Github> =
        githubService.getGithubRepositories().mapping()

    companion object {
        @Volatile
        private var instance: GithubRepositoryImpl? = null
        fun getInstance(githubService: GithubService): GithubRepositoryImpl =
            instance ?: synchronized(this) {
                instance ?: GithubRepositoryImpl(githubService).also { instance = it }
            }
    }
}
