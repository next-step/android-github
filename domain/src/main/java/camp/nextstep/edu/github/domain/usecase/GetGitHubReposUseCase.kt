package camp.nextstep.edu.github.domain.usecase

import camp.nextstep.edu.github.domain.model.GitHubRepos
import camp.nextstep.edu.github.domain.repository.MainRepository
import javax.inject.Inject

class GetGitHubReposUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    suspend fun invoke() : GitHubRepos  = mainRepository.getGitHubRepositories()
}
