package camp.nextstep.edu.github

import camp.nextstep.edu.github.domain.model.GithubStorage
import camp.nextstep.edu.github.domain.model.NetworkState
import camp.nextstep.edu.github.domain.usecase.GetGithubStorageUseCase
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var mainViewModel: MainViewModel
    private lateinit var getGithubStorageUseCase: GetGithubStorageUseCase

    @Test
    fun 데이터를_호출하면_NetworkState_Loading_데이터가_수신된다() = runTest {
        //given
        getGithubStorageUseCase = mockk(relaxed = true)
        mainViewModel = MainViewModel(getGithubStorageUseCase)
        //when
        mainViewModel.getGithubStorage()
        //then
        val actual = mainViewModel.uiState.first()
        assertThat(actual).isInstanceOf(NetworkState.Loading::class.java)
    }

    @Test
    fun 데이터를_불러오는데_성공하면_NetworkState_Success_데이터가_수신된다() = runTest {
        //given
        getGithubStorageUseCase = mockk()
        mainViewModel = MainViewModel(getGithubStorageUseCase)

        val repositories = listOf(
            GithubStorage(
                author = "Kim Sang Min",
                description = "my nickname is sangmee"
            )
        )

        coEvery { getGithubStorageUseCase() } returns NetworkState.Success(repositories)
        //when
        mainViewModel.getGithubStorage()
        advanceUntilIdle()
        //then
        val actual = mainViewModel.uiState.first()
        assertThat(actual).isInstanceOf(NetworkState.Success::class.java)
    }

    @Test
    fun 데이터를_불러오는데_실패하면_NetworkState_Success_데이터가_수신된다() = runTest {
        //given
        getGithubStorageUseCase = mockk()
        mainViewModel = MainViewModel(getGithubStorageUseCase)

        coEvery { getGithubStorageUseCase() } returns NetworkState.Error(Throwable())
        //when
        mainViewModel.getGithubStorage()
        advanceUntilIdle()
        //then
        val actual = mainViewModel.uiState.first()
        assertThat(actual).isInstanceOf(NetworkState.Error::class.java)
    }
}