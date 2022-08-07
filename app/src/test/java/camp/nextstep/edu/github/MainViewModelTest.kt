package camp.nextstep.edu.github

import camp.nextstep.edu.github.domain.Repository
import camp.nextstep.edu.github.domain.RepositoryUseCase
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
    private lateinit var repositoryUseCase: RepositoryUseCase

    @BeforeEach
    fun setUp() {
        repositoryUseCase = mockk(relaxed = true)
        viewModel = MainViewModel(repositoryUseCase)
    }

    @Test
    fun `Repository 리스트를 불러올 수 있다`() = runTest {
        // given
        val repositories =
            listOf(Repository(fullName = "wisemuji", description = "This is test description"))
        coEvery { repositoryUseCase.invoke() } returns Result.success(repositories)

        // when
        viewModel.fetchRepositories()

        // then
        assertThat(viewModel.repositories.getOrAwaitValue()).isEqualTo(repositories)
        coVerify { repositoryUseCase.invoke() }
    }


    companion object {
        @OptIn(ExperimentalCoroutinesApi::class)
        @JvmField
        @RegisterExtension
        val coroutineExtension = MainCoroutineExtension()
    }
}
