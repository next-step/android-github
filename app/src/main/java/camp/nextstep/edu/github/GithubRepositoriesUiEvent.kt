package camp.nextstep.edu.github

sealed interface GithubRepositoriesUiEvent {
    object LoadRepositoriesUi : GithubRepositoriesUiEvent
}