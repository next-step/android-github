package camp.nextstep.edu.github.data.repository

import camp.nextstep.edu.github.data.di.NetworkModule
import camp.nextstep.edu.github.data.mapToGitHubRepositoryList
import camp.nextstep.edu.github.domain.GitHubRepository
import camp.nextstep.edu.github.domain.MainRepository

internal class GitHubRepositoryImpl : MainRepository {
    override suspend fun getGitHubRepositories() : List<GitHubRepository> {
        val gitHubService = NetworkModule.provideGitHubService()
        return gitHubService.getRepositories().mapToGitHubRepositoryList()
    }
}
