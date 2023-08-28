package camp.nextstep.edu.github.ui

sealed class UiStatus {

    data object Loading : UiStatus()
    data object Success : UiStatus()
    data class Failed(val message: String) : UiStatus()
}
