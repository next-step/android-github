package camp.nextstep.edu.github

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import camp.nextstep.edu.github.domain.error.Error
import camp.nextstep.edu.github.domain.model.GitHubRepositoryData
import camp.nextstep.edu.github.domain.repository.GitHubRepository
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
internal class MainViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private val repository: GitHubRepository = mockk()
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `레포지터리를 정상적으로 조회하면 repositorySate 는 Sucess 가 된다`() {
        val list = listOf(
            GitHubRepositoryData("mojombo/grit", "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby."),
            GitHubRepositoryData("rubinius/rubinius", "The Rubinius Language Platform"),
        )
        coEvery { repository.getRepositories() } returns Result.success(list)

        val mainViewModel = MainViewModel(repository, testDispatcher)

        val actual = mainViewModel.repositorySate.getOrAwaitValue()
        assertThat(actual).isInstanceOf(RepositoriesState.Success::class.java)
    }

    @Test
    fun `레포지터리를 정상적으로 조회된 경우 repositorySate 의 Sucess 에 조회된 레포지터리 목록이 반환된다`() {
        val list = listOf(
            GitHubRepositoryData("mojombo/grit", "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby."),
            GitHubRepositoryData("rubinius/rubinius", "The Rubinius Language Platform"),
        )
        coEvery { repository.getRepositories() } returns Result.success(list)

        val mainViewModel = MainViewModel(repository, testDispatcher)

        val actual = mainViewModel.repositorySate.getOrAwaitValue() as RepositoriesState.Success
        assertThat(actual.repositories).containsExactly(
            GitHubRepositoryData("mojombo/grit", "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby."),
            GitHubRepositoryData("rubinius/rubinius", "The Rubinius Language Platform")
        )
    }

    @Test
    fun `레포지터리를 조회 시 오류가 발생하면 repositorySate 는 Failure 가 된다`() {
        coEvery { repository.getRepositories() } returns Result.failure(Error.NetworkUnavailable)

        val mainViewModel = MainViewModel(repository, testDispatcher)

        val actual = mainViewModel.repositorySate.getOrAwaitValue()
        assertThat(actual).isInstanceOf(RepositoriesState.Failure::class.java)
    }

    @Test
    fun `레포지터리를 조회 시 오류가 발생하면 repositorySate 의 Failure 에 발생한 예외가 반환된다`() {
        val error = Error.NetworkUnavailable
        coEvery { repository.getRepositories() } returns Result.failure(error)

        val mainViewModel = MainViewModel(repository, testDispatcher)

        val actual = mainViewModel.repositorySate.getOrAwaitValue() as RepositoriesState.Failure
        assertThat(actual.throwable).isEqualTo(Error.NetworkUnavailable)
    }

}