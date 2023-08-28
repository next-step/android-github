package camp.nextstep.edu.github.ui.main

sealed class GithubMainSideEffect {
    data object Completed : GithubMainSideEffect()
}
