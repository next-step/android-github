package camp.nextstep.edu.github.model

internal data class ExceptionMessageModel(private val message: String) {
    override fun toString(): String {
        return message
    }
}