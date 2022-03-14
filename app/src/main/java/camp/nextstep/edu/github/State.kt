package camp.nextstep.edu.github

sealed class State  {
    object Loading: State()
    data class Success <T> (val t: T): State()
    data class Failure <R> (val t: R): State()
}
