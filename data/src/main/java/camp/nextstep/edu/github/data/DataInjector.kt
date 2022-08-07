package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository

object DataInjector {
    fun provideGithubRepository() : GithubRepository {
        return GithubRepositoryImpl()
    }
}