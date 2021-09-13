package camp.nextstep.edu.github.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext

/**
 * @author Malibin
 *
 * Created on 2021 02 18
 * Updated on 2021 02 18
 *
 * @sample
 * companion object {
 *     @JvmField
 *     @RegisterExtension
 *     val coroutineExtension = MainCoroutineExtension()
 * }
 *
 *     @Test
 *     @DisplayName("Awesome suspend Test")
 *     fun test_suspend_things() = coroutineExtension.runBlockingTest {
 *         ...
 *         val actualFoo = somethingSuspendMethod()
 *         ...
 *     }
 *
 * Coroutine Test 중 객체 내부와 테스트 로직에서 실행되는 Coroutine Context를
 * 서로 맞춰 테스트를 원할하게 진행하기 위한 유틸 클래스입니다.
 *
 * *Junit5 버전*
 *
 */

@ExperimentalCoroutinesApi
class MainCoroutineExtension(
    val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher(),
) : BeforeEachCallback, AfterEachCallback,
    TestCoroutineScope by TestCoroutineScope(testDispatcher) {

    fun runBlockingTest(
        block: suspend TestCoroutineScope.() -> Unit
    ) = testDispatcher.runBlockingTest(block)

    override fun beforeEach(context: ExtensionContext?) {
        Dispatchers.setMain(testDispatcher)
    }

    override fun afterEach(context: ExtensionContext?) {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}
