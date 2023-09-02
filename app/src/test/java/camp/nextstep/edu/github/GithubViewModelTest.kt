/**
 * @author Daewon on 02,September,2023
 *
 */

package camp.nextstep.edu.github

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import camp.nextstep.edu.github.domain.model.RepositoryItem
import camp.nextstep.edu.github.domain.repository.GithubRepository
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import org.junit.Rule
import org.junit.Test


class GithubViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: GithubViewModel
    private val githubRepository: GithubRepository = mockk(relaxed = true)

    @Test
    fun `GithubViewModel이 생성되면, 정상적으로 통신할 경우 GithubRepository를 가져온다`() {
        // given
        coEvery { githubRepository.getRepositories() } returns Result.success(
            listOf(
                RepositoryItem(
                    fullName = "KwonDae",
                    description = "KwonDae's repository",
                )
            )
        )

        // when
        viewModel = GithubViewModel(githubRepository)

        // then
        coVerify { githubRepository.getRepositories() }
        assertThat(viewModel.uiState.value).isEqualTo(
            UiState.Success(
                listOf(
                    RepositoryItem(
                        fullName = "KwonDae",
                        description = "KwonDae's repository",
                    )
                )
            )
        )
    }

    @Test
    fun `GithubViewModel이 생성되고, 정상적으로 통신했으나 빈값인 경우, 빈화면이 노출되어야 한다`() {
        // given
        coEvery { githubRepository.getRepositories() } returns Result.success(emptyList())

        // when
        viewModel = GithubViewModel(githubRepository)

        // then
        coVerify { githubRepository.getRepositories() }
        assertThat(viewModel.uiState.value).isEqualTo(
            UiState.Success(emptyList())
        )
    }

    @Test
    fun `GithubViewModel이 생성되고, 통신이 실패하면, 에러메시지를 가져온다`() {
        // given
        val errorMessage = "통신에 실패하였습니다."
        coEvery { githubRepository.getRepositories() } returns Result.failure(
            Throwable(errorMessage)
        )

        // when
        viewModel = GithubViewModel(githubRepository)

        // then
        coVerify { githubRepository.getRepositories() }
        assertThat(viewModel.uiState.value).isEqualTo(
            UiState.Error(errorMessage)
        )
    }

}
