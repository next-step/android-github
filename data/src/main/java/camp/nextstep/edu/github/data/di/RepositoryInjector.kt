package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.GithubRepositoryImpl
import camp.nextstep.edu.github.data.GithubService
import camp.nextstep.edu.github.domain.GetGithubRepositoriesUseCase

object Injector {
    fun providesGithubUseCase(): GetGithubRepositoriesUseCase {
        val retrofit = NetworkInjector.providerRetrofit().create(GithubService::class.java)
        val githubRepository = GithubRepositoryImpl.getInstance(retrofit)
        return GetGithubRepositoriesUseCase.getInstance(githubRepository)
    }
}
