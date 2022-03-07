package camp.nextstep.edu.github.data.remote.module

import camp.nextstep.edu.github.data.repository.GithubRepositoryImpl
import camp.nextstep.edu.github.domain.repository.GithubRepository

object RepositoryModule {

    fun getGithubRepository(): GithubRepository = GithubRepositoryImpl(
        ServiceModule.getGithubService(
            NetworkModule.getRetrofit()
        )
    )
}
