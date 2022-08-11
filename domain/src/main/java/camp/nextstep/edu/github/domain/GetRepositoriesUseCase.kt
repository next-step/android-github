package camp.nextstep.edu.github.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetRepositoriesUseCase @Inject constructor(
    private val githubRepository: GithubRepository
) {
    suspend operator fun invoke(): Flow<GithubRepositories> {
        return flow { emit(githubRepository.loadRepositories()) }
    }
}