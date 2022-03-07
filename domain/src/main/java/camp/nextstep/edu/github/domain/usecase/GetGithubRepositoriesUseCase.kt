package camp.nextstep.edu.github.domain.usecase

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.model.Repositories
import kotlinx.coroutines.flow.Flow

class GetGithubRepositoriesUseCase(private val githubRepository: GithubRepository) {

    operator fun invoke(): Flow<Repositories> = githubRepository.getRepositories()
}