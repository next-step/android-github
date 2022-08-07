package camp.nextstep.edu.github

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import camp.nextstep.edu.github.domain.GetGithubDatasUseCase
import camp.nextstep.edu.github.domain.Github
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Rule
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * 클래스에 대한 간단한 설명이나 참고 url을 남겨주세요.
 * Created by jeongjinhong on 2022. 08. 07..
 */

class MainViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private val getGithubDatasUseCase = mockk<GetGithubDatasUseCase>(relaxed = true)
    private lateinit var viewModel: MainViewModel

    @BeforeEach
    internal fun setUp() {
        viewModel = MainViewModel(getGithubDatasUseCase)
    }

    @Test
    @DisplayName("")
    fun `깃헙 데이터를 가져온다`() = runTest {
        // given
        val testDispatcher = UnconfinedTestDispatcher(testScheduler)
        Dispatchers.setMain(testDispatcher)
        coEvery { getGithubDatasUseCase.execute() } returns (listOf(
            Github(
                "mojombo/grit",
                "description~"
            )
        ))

        try {
            // when
            viewModel.loadGithub()
            // then
            val actual = viewModel.updateGithubs.value
            Assertions.assertAll(
                { Assert.assertEquals(actual?.get(0)?.fullName, "mojombo/grit") },
                { Assert.assertEquals(actual?.get(0)?.description, "description~") }
            )
        } finally {
            Dispatchers.resetMain()
        }

    }
}