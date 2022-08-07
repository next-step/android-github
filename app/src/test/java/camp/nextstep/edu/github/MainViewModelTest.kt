package camp.nextstep.edu.github

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import camp.nextstep.edu.github.domain.GetGithubDatasUseCase
import camp.nextstep.edu.github.domain.Github
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * 클래스에 대한 간단한 설명이나 참고 url을 남겨주세요.
 * Created by jeongjinhong on 2022. 08. 07..
 */

class MainViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private val getGithubDatasUseCase = mockk<GetGithubDatasUseCase>(relaxed = true)
    private lateinit var viewModel: MainViewModel

    @Before
    internal fun setUp() {
        viewModel = MainViewModel(getGithubDatasUseCase)
    }

    @Test
    fun `깃헙 데이터를 가져온다`() = runTest {
        // given
        val testDispatcher = UnconfinedTestDispatcher(testScheduler)
        Dispatchers.setMain(testDispatcher)
        val expected: List<Github> = listOf(mockk(relaxed = true))
        coEvery { getGithubDatasUseCase.execute() } returns (expected)

        try {
            // when
            viewModel.loadGithub()
            // then
            val actual = viewModel.updateGithubs.value
            assertThat(actual).isEqualTo(expected)
        } finally {
            Dispatchers.resetMain()
        }

    }
}