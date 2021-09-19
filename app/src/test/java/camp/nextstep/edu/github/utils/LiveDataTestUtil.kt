package camp.nextstep.edu.github.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

/**
 * Created By Malibin
 * on 8월 27, 2021
 */

fun <T> LiveData<T>.takeValue(): T? {
    var result: T? = null
    val countDownLatch = CountDownLatch(1)

    val observer = object : Observer<T> {
        override fun onChanged(t: T) {
            result = t
            countDownLatch.countDown()
            this@takeValue.removeObserver(this)
        }
    }
    this.observeForever(observer)
    countDownLatch.await(2000, TimeUnit.MILLISECONDS)
    return result
}
