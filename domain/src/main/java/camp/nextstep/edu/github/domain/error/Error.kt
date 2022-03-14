package camp.nextstep.edu.github.domain.error

sealed class Error(
    override val message: String? = null,
    override val cause: Throwable? = null
): Exception(message, cause) {
    object NetworkUnavailable: Error()
}