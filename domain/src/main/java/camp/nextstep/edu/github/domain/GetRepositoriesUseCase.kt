package camp.nextstep.edu.github.domain

import camp.nextstep.edu.github.domain.repository.GithubRepository
import camp.nextstep.edu.github.domain.repository.Repository
import javax.inject.Inject

class GetRepositoriesUseCase @Inject constructor(
    private val repository: GithubRepository
) {

    suspend operator fun invoke(): Result<List<Repository>> =
        kotlin.runCatching { repository.getRepositories() }
}
