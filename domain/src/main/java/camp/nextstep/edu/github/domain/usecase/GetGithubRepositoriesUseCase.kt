package camp.nextstep.edu.github.domain.usecase

import camp.nextstep.edu.github.domain.model.GithubRepositoryInfo
import camp.nextstep.edu.github.domain.repository.GithubRepository
import javax.inject.Inject

class GetGithubRepositoriesUseCase @Inject constructor(
    private val githubRepository: GithubRepository
) {
    suspend operator fun invoke(): List<GithubRepositoryInfo> = githubRepository.getRepositories()
}
