package camp.nextstep.edu.github

import camp.nextstep.edu.github.domain.Repository
import camp.nextstep.edu.github.domain.GetRepositoriesUseCase
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

internal class MainViewModelTest {

    @JvmField
    @RegisterExtension
    val instantTaskExecutorExtension = InstantTaskExecutorExtension()

    private lateinit var viewModel: MainViewModel
    private lateinit var getRepositoriesUseCase: GetRepositoriesUseCase

    @BeforeEach
    fun setUp() {
        getRepositoriesUseCase = mockk(relaxed = true)
        viewModel = MainViewModel(getRepositoriesUseCase)
    }

    @Test
    fun `Repository 리스트를 불러올 수 있다`() = runTest {
        // given
        val repositories =
            listOf(Repository(fullName = "wisemuji", description = "This is test description"))
        coEvery { getRepositoriesUseCase.invoke() } returns Result.success(repositories)

        // when
        viewModel.fetchRepositories()

        // then
        assertThat(viewModel.repositories.getOrAwaitValue()).isEqualTo(repositories)
        coVerify { getRepositoriesUseCase.invoke() }
    }

    @Test
    fun `Repository 리스트를 불러오는 것에 실패할 경우 뷰에 전파한다`() = runTest {
        // given
        coEvery { getRepositoriesUseCase.invoke() } returns Result.failure(Exception())

        // when
        viewModel.fetchRepositories()

        // then
        assertThat(viewModel.loadingFailed.getOrAwaitValue()).isEqualTo(true)
        coVerify { getRepositoriesUseCase.invoke() }
    }


    companion object {
        @OptIn(ExperimentalCoroutinesApi::class)
        @JvmField
        @RegisterExtension
        val coroutineExtension = MainCoroutineExtension()
    }
}
