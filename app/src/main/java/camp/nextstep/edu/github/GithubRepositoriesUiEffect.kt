package camp.nextstep.edu.github

sealed interface GithubRepositoriesUiEffect {
    object Loading : GithubRepositoriesUiEffect
    object LoadingFinished : GithubRepositoriesUiEffect
}