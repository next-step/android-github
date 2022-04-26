package camp.nextstep.edu.github.mapper

import android.content.Context
import camp.nextstep.edu.github.R
import camp.nextstep.edu.github.domain.error.Error
import camp.nextstep.edu.github.model.ExceptionMessageModel

internal fun Throwable.toExceptionMessage(context: Context): ExceptionMessageModel {
    val message: String = when (this) {
        Error.NetworkUnavailable -> context.getString(R.string.network_unavailable_error)
        else ->
            if (this.message.isNullOrEmpty()) {
                context.getString(R.string.etc_error)
            } else {
                context.getString(R.string.etc_error).plus(": ${this.message}")
            }
    }
    return ExceptionMessageModel(message)
}