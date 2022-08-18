package camp.nextstep.edu.github.domain.model

sealed class NetworkState {
    object Loading : NetworkState()
    class Success<T>(val data: T) : NetworkState()
    class Error(val throwable: Throwable) : NetworkState()
}