package camp.nextstep.edu.github.ui

sealed class UiStatus {

    object Loading : UiStatus()
    object Success : UiStatus()
    data class Failed(val message: String) : UiStatus()
}
