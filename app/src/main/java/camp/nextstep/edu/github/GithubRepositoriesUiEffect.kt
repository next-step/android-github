package camp.nextstep.edu.github

sealed interface GithubRepositoriesUiEffect {
    object Loading : GithubRepositoriesUiEffect
    object NotLoading : GithubRepositoriesUiEffect
}