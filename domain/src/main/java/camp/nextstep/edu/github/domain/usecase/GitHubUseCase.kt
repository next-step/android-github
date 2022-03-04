package camp.nextstep.edu.github.domain.usecase

import camp.nextstep.edu.github.domain.model.GitHub
import camp.nextstep.edu.github.domain.repository.GitHubRepository
import javax.inject.Inject

class GitHubUseCase @Inject constructor(
    private val gitHubRepository: GitHubRepository
) {

    suspend fun fetch(): Result<List<GitHub>> = runCatching {
        gitHubRepository.fetch()
    }
}
