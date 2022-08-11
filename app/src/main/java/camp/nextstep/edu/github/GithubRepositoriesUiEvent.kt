package camp.nextstep.edu.github

sealed interface GithubRepositoriesUiEvent {
    object LoadRepositories : GithubRepositoriesUiEvent
}