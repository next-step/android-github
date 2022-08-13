package camp.nextstep.edu.github

import camp.nextstep.edu.github.domain.GetRepositoriesUseCase
import camp.nextstep.edu.github.domain.GithubRepo
import camp.nextstep.edu.github.domain.GithubRepositories
import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@DelicateCoroutinesApi
class GithubRepositoriesViewModelTest {
    private lateinit var viewModel: GithubRepositoriesViewModel
    private lateinit var useCase: GetRepositoriesUseCase

    @Before
    fun setUp() {
        useCase = mockk(relaxed = true)
        viewModel = GithubRepositoriesViewModel(useCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `Github Repo 목록 로딩 이벤트가 발생하면 목록을 가져올 수 있어야 한다`() {
        //given
        every { useCase.invoke() } returns flow {
            emit(GithubRepositories(listOf(GithubRepo(fullName = "next-step", name = "nextstep", description = "next step git", id = 1))))
        }
        val expected = "next-step"

        //when
        viewModel.onEvent(GithubRepositoriesUiEvent.LoadRepositories)
        val actual = (viewModel.uiState as GithubRepositoriesUiState.LoadedGithubRepositories).repositories.list().firstOrNull()?.fullName

        //then
        assertThat(actual).isEqualTo(expected)
    }
}