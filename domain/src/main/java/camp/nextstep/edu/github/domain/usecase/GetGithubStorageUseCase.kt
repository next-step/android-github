package camp.nextstep.edu.github.domain.usecase

import camp.nextstep.edu.github.domain.model.GithubStorage
import camp.nextstep.edu.github.domain.repository.GithubRepository
import javax.inject.Inject

class GetGithubStorageUseCase @Inject constructor(
    private val githubRepository: GithubRepository,
) {
    suspend operator fun invoke(): Result<List<GithubStorage>> = githubRepository.getRepositories()
}