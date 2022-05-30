package camp.nextstep.edu.github.domain.usecase

import camp.nextstep.edu.github.domain.model.GithubRepoModel
import camp.nextstep.edu.github.domain.repository.GithubRepository
import javax.inject.Inject

class GithubRepositoryUseCase @Inject constructor(
    private val githubRepository: GithubRepository
    ) {
    suspend operator fun invoke(): Result<List<GithubRepoModel>> = runCatching {
        githubRepository.getRepositories()
    }
}