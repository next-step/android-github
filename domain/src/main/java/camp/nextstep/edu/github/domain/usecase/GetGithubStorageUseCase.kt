package camp.nextstep.edu.github.domain.usecase

import camp.nextstep.edu.github.domain.model.GithubStorage
import camp.nextstep.edu.github.domain.repository.GithubRepository

class GetGithubStorageUseCase(
    private val githubRepository: GithubRepository
) {
    suspend fun invoke(): List<GithubStorage> = githubRepository.getRepositories()
}