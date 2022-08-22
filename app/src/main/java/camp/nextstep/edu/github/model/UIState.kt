package camp.nextstep.edu.github.model

sealed class UIState {
    object Loading : UIState()
    class Success<T>(val data: T) : UIState()
    class Error(val throwable: Throwable) : UIState()
}