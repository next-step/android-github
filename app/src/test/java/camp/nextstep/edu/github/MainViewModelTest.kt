package camp.nextstep.edu.github

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import camp.nextstep.edu.github.domain.GetGithubRepositoryUsecase
import camp.nextstep.edu.github.domain.RepositoryVO
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.IOException

@RunWith(RobolectricTestRunner::class)
class MainViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    lateinit var viewModel: MainViewModel

    @RelaxedMockK
    lateinit var usecase: GetGithubRepositoryUsecase


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = MainViewModel(usecase)
    }

    @Test
    fun `도메인 interface을 통해 정상 응답 response를 받는다`() {
        //given
        every {
            runBlocking {
                usecase.invoke()
            }
        } returns Result.success(listOf())

        //when
        viewModel.getGitHubRepository()
        val actual = viewModel.items

        //then
        assertThat(actual).isEqualTo(listOf<RepositoryVO>())
    }

    @Test
    fun `도메인 interface을 통해 비정상 응답 response를 받는다`() {
        //given
        every {
            runBlocking {
                usecase.invoke()
            }
        } returns Result.failure(IOException())

        //when
        viewModel.getGitHubRepository()
        val actual = viewModel.errorMsg

        //then
        assertThat(actual).isEqualTo(ErrorEvent.NetworkError)
    }
}