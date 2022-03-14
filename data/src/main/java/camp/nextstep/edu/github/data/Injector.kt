package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository

object Injector {
    fun provideGithubRepository(): GithubRepository {
        return GithubRepositoryImpl()
    }
}
