package camp.nextstep.edu.github.model

sealed class UIState<out T> {
    object Loading : UIState<Nothing>()
    class Success<T>(val data: T) : UIState<T>()
    class Error(val throwable: Throwable) : UIState<Nothing>()
}