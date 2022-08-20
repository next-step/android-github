package camp.nextstep.edu.github

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import camp.nextstep.edu.github.domain.GithubRepoRepository
import camp.nextstep.edu.github.domain.GithubRepository
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class MainViewModelTest {
    lateinit var viewModel: MainViewModel

    @get: Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun `RepositoryUiModel를 받아 올 수 있다`() = runTest {
        //given ViewModel로 부터
        val mockRepository = mockk<GithubRepoRepository>()
        viewModel = MainViewModel(mockRepository)
        val firstResponse =
            GithubRepository(fullName = "first", description = "firstDescription")
        coEvery { mockRepository.getRepositories() } returns Result.success(
            listOf(firstResponse)
        )

        //when RepositoryResponse를 요청하면
        viewModel.loadRepositoryResponse()

        //then UiModel을 받을 수 있다.
        val expected = firstResponse.toUiModel()
        val actual = viewModel.repositoryResponseList.getOrAwaitValue().firstOrNull()
        assertThat(actual).isEqualTo(expected)
    }
}