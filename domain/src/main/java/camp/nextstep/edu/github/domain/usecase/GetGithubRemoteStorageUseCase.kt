package camp.nextstep.edu.github.domain.usecase

import camp.nextstep.edu.github.domain.model.GithubRemoteStorage
import camp.nextstep.edu.github.domain.repository.GithubRepository

class GetGithubRemoteStorageUseCase(
    private val githubRepository: GithubRepository
) {
    suspend fun invoke(): List<GithubRemoteStorage> = githubRepository.getRepositories()
}