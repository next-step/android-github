package camp.nextstep.edu.github

sealed class UiState<out T> {

    object Loading : UiState<Nothing>()
    data class Success<T>(val data: T?) : UiState<T>()
    data class Error<T>(val throwable: Throwable?) : UiState<T>()

}