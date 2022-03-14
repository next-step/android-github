package camp.nextstep.edu.github.data.exception

internal class HttpResponseFailureException(statusCode: Int, message: String?) : Exception("statusCode : ${statusCode}, message: $message")