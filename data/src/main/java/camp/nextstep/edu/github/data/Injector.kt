package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.network.GitHubNetwork
import camp.nextstep.edu.github.domain.repository.GitHubRepository

object Injector {
    private var instance: GitHubRepository? = null
    fun getGitHubRepository(): GitHubRepository {
        return instance ?: GitHubRepositoryImpl(GitHubNetwork.getGitHubService()).also { instance = it }
    }
}