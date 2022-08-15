package camp.nextstep.edu.github

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import camp.nextstep.edu.github.domain.GitHubRepository
import camp.nextstep.edu.github.domain.GitHubRepositoryItem
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel
    private lateinit var repository: GitHubRepository

    @Before
    fun setUp() {
        repository = mockk(relaxed = true)
        viewModel = MainViewModel(repository)
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `GitHub Repository 리스트를 가져올 수 있다`() = runTest {
        // given
        val gitHubRepositoryItemList = listOf(
            GitHubRepositoryItem(fullName = "fullName", description = "description")
        )
        coEvery {
            repository.getGitHubRepositoryList().getOrNull()
        } returns gitHubRepositoryItemList

        // when
        viewModel.getGitHubRepositoryList()
        advanceUntilIdle()

        // then
        val actual = viewModel.gitHubRepositoryItemList.value
        assertThat(actual).isEqualTo(gitHubRepositoryItemList)
    }
}