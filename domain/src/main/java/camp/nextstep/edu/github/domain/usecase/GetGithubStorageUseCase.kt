package camp.nextstep.edu.github.domain.usecase

import camp.nextstep.edu.github.domain.model.NetworkState
import camp.nextstep.edu.github.domain.repository.GithubRepository
import javax.inject.Inject

class GetGithubStorageUseCase @Inject constructor(
    private val githubRepository: GithubRepository
) {
    suspend fun invoke() = githubRepository.getRepositories()
        .fold(
            onSuccess = { storages -> NetworkState.Success(storages) },
            onFailure = { throwable -> NetworkState.Error(throwable) }
        )
}