package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepoRepository

object Injector {
    fun provideGithubRepository(): GithubRepoRepository {
        return GithubRepoRepositoryImpl(GithubNetwork.getGithubService())
    }
}