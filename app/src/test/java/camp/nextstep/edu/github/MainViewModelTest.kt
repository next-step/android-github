package camp.nextstep.edu.github

import camp.nextstep.edu.github.data.DataException
import camp.nextstep.edu.github.data.GitRepo
import camp.nextstep.edu.github.data.GitRepoRepository
import com.google.common.truth.Truth
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

internal class MainViewModelTest {

    @JvmField
    @RegisterExtension
    val instantTaskExecutorExtension = InstantTaskExecutorExtension()

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    private lateinit var viewModel: MainViewModel
    private lateinit var gitRepoRepository: GitRepoRepository

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)

        gitRepoRepository = mockk()
        viewModel = MainViewModel(gitRepoRepository)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `Repository에서 반환하는 리스트를 그대로 노출한다`() = runBlocking {
        // given
        val repos = listOf(GitRepo("next-step", "hello"))
        coEvery { gitRepoRepository.getGitRepos() } returns repos

        // when
        viewModel.fetchGitRepos()

        // then
        val actual = viewModel.repos.getOrAwaitValue()
        assertThat(actual).isEqualTo(repos)
    }

    @Test
    fun `Repository에서 에러가 발생할 경우 이벤트 발생`() {
        // given
        coEvery { gitRepoRepository.getGitRepos() } throws DataException("wtf")

        // when
        viewModel.fetchGitRepos()

        // then
        val actual = viewModel.viewEvent.getOrAwaitValue()
        assertThat(actual).isInstanceOf(MainViewModel.ViewEvent.GitRepoLoadingFailure::class.java)
    }

}