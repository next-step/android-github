package camp.nextstep.edu.github

import camp.nextstep.edu.github.domain.GithubRepositories

sealed interface GithubRepositoriesUiState {
    data class LoadedGithubRepositories(val repositories: GithubRepositories) : GithubRepositoriesUiState
    object LoadError : GithubRepositoriesUiState
    object Empty : GithubRepositoriesUiState
}