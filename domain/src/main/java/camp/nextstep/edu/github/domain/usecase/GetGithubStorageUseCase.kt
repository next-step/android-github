package camp.nextstep.edu.github.domain.usecase

import camp.nextstep.edu.github.domain.repository.GithubRepository

class GetGithubStorageUseCase(
    private val githubRepository: GithubRepository
) {
    suspend fun invoke(): Unit {
        val githubStorages = githubRepository.getRepositories()
        return githubStorages
            .fold(
                onSuccess = { storages -> println("getGithubStorageUseCase $storages") },
                onFailure = { throwable -> println("getGithubStorageUseCase: ${throwable.message}") }
            )
    }
}