package camp.nextstep.edu.github.domain.usecase

import camp.nextstep.edu.github.domain.model.GitHub
import camp.nextstep.edu.github.domain.repository.GitHubRepository
import javax.inject.Inject

class FetchGitHubUseCase @Inject constructor(
    private val gitHubRepository: GitHubRepository
) {

    suspend operator fun invoke(): Result<List<GitHub>> = runCatching {
        gitHubRepository.fetch()
    }
}
