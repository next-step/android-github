package camp.nextstep.edu.github.domain.usecase

import camp.nextstep.edu.github.domain.Resource
import camp.nextstep.edu.github.domain.model.Repositories
import camp.nextstep.edu.github.domain.repository.GithubRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GithubRepositoryUseCase(
    private val githubRepository: GithubRepository
) {
    operator fun invoke(): Flow<Resource<Repositories>> {
        return flow {
            try {
                emit(Resource.Loading<Repositories>())
                val result = githubRepository.getRepositories()
                emit(Resource.Success(result))
            } catch (e: Exception) {
                emit(Resource.Error<Repositories>(e))
            }
        }
    }
}