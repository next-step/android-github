package camp.nextstep.edu.github.domain.di

import camp.nextstep.edu.github.domain.repository.GithubRepository
import camp.nextstep.edu.github.domain.usecase.GetGithubStorageUseCase

object UseCaseInjector {
    fun provideGetGithubStorageUseCase(githubRepository: GithubRepository) =
        GetGithubStorageUseCase(githubRepository)
}