package camp.nextstep.edu.github

import camp.nextstep.edu.github.domain.model.GithubStorage
import camp.nextstep.edu.github.domain.usecase.GetGithubStorageUseCase
import camp.nextstep.edu.github.model.UIState
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var mainViewModel: MainViewModel
    private lateinit var getGithubStorageUseCase: GetGithubStorageUseCase

    @Before
    fun setUp() {
        getGithubStorageUseCase = mockk()
        mainViewModel = MainViewModel(getGithubStorageUseCase)
    }

    @Test
    fun 데이터를_호출하면_NetworkState_Loading_데이터가_수신된다() = runTest {
        //when
        mainViewModel.loadGithubStorage()
        //then
        val actual = mainViewModel.uiState.first()
        assertThat(actual).isInstanceOf(UIState.Loading::class.java)
    }

    @Test
    fun 데이터를_불러오는데_성공하면_데이터가_수신된다() = runTest {
        //given
        val repositories = listOf(
            GithubStorage(
                author = "Kim Sang Min",
                description = "my nickname is sangmee"
            )
        )
        coEvery { getGithubStorageUseCase() } returns Result.success(repositories)
        //when
        mainViewModel.loadGithubStorage()
        advanceUntilIdle()
        //then
        val actual = mainViewModel.uiState.first() as UIState.Success<*>
        assertThat(actual.data).isEqualTo(repositories)
    }

    @Test
    fun 데이터를_불러오는데_실패하면_UIState_Error_데이터가_수신된다() = runTest {
        //given
        coEvery { getGithubStorageUseCase() } returns Result.failure(Throwable())
        //when
        mainViewModel.loadGithubStorage()
        advanceUntilIdle()
        //then
        val actual = mainViewModel.uiState.first()
        assertThat(actual).isInstanceOf(UIState.Error::class.java)
    }
}