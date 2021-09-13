package camp.nextstep.edu.github.utils

import androidx.annotation.StringRes

/**
 * Created By Malibin
 * on 9월 13, 2021
 */

sealed class ToastMessage {
    class ResourceId(@StringRes val message: Int) : ToastMessage()
    class StringValue(val message: String) : ToastMessage()
}
