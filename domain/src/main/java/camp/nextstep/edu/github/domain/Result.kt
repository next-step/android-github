/**
 * @author Daewon on 22,April,2023
 *
 */

package camp.nextstep.edu.github.domain

sealed interface Result<out T> {
    data class Success<T>(val data: T) : Result<T>
    data class Error(val exception: Throwable? = null) : Result<Nothing>
}
