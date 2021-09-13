package camp.nextstep.edu.github.utils

import android.content.Context
import android.widget.Toast

/**
 * Created By Malibin
 * on 9월 13, 2021
 */

fun Context.showToast(toastMessage: ToastMessage) = when (toastMessage) {
    is ToastMessage.ResourceId ->
        Toast.makeText(this, toastMessage.message, Toast.LENGTH_SHORT).show()
    is ToastMessage.StringValue ->
        Toast.makeText(this, toastMessage.message, Toast.LENGTH_SHORT).show()
}
