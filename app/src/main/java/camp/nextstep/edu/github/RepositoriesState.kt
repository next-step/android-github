package camp.nextstep.edu.github

import camp.nextstep.edu.github.domain.model.GitHubRepositoryData

sealed class RepositoriesState  {
    object Loading: RepositoriesState()
    data class Success (val repositories: List<GitHubRepositoryData>): RepositoriesState()
    data class Failure (val throwable: Throwable): RepositoriesState()
}
