package camp.nextstep.edu.github

import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import io.mockk.*
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
@Config(application = HiltTestApplication::class)
class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = mockk()
    }

    @Test
    fun `깃허브 레포지토리 데이터 가져오기 테스트`() = runTest {
        // when
        coEvery { viewModel.getGithubRepositoryInfo() } just runs

        viewModel.getGithubRepositoryInfo()

        // then
        coVerify { viewModel.getGithubRepositoryInfo() }
    }
}