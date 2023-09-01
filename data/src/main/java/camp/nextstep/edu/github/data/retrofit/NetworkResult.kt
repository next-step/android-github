/**
 * @author Daewon on 22,April,2023
 *
 */

package camp.nextstep.edu.github.data.retrofit

import camp.nextstep.edu.github.domain.Result

internal inline fun <T> networkResult(transform: () -> T): Result<T> = try {
    Result.Success(transform.invoke())
} catch (e: Exception) {
    Result.Error(e)
}
