package camp.nextstep.edu.github.domain.di

import camp.nextstep.edu.github.domain.repository.GithubRepository
import camp.nextstep.edu.github.domain.usecase.GetGithubRemoteStorageUseCase

object UseCaseInjector {
    fun provideGetGithubRemoteStorageUseCase(githubRepository: GithubRepository) =
        GetGithubRemoteStorageUseCase(githubRepository)
}