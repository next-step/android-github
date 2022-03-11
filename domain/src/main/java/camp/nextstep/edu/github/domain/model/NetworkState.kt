package camp.nextstep.edu.github.domain.model

sealed class NetworkState {
    object Loading : NetworkState()
    data class Success<T>(val data: T) : NetworkState()
    data class Error(val error: Throwable?) : NetworkState()
}
