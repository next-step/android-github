package camp.nextstep.edu.github

sealed class ErrorEvent {
    object NetworkError: ErrorEvent()
}
