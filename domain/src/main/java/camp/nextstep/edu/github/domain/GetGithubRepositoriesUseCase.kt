package camp.nextstep.edu.github.domain

import camp.nextstep.edu.github.domain.model.Github

class GetGithubRepositoriesUseCase(private val githubRepository: GithubRepository) {
    suspend operator fun invoke(): Result<List<Github>> = runCatching {
        githubRepository.getGithubRepositories()
    }

    companion object {
        @Volatile
        private var instance: GetGithubRepositoriesUseCase? = null
        fun getInstance(githubRepository: GithubRepository): GetGithubRepositoriesUseCase =
            instance ?: synchronized(this) {
                instance ?: GetGithubRepositoriesUseCase(githubRepository).also { instance = it }
            }
    }
}
