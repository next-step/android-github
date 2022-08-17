package camp.nextstep.edu.github

import camp.nextstep.edu.github.domain.NetworkRepository
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

    private lateinit var networkRepository: NetworkRepository
    private lateinit var mainViewModel: MainViewModel

    @BeforeEach
    fun setUp() {
        networkRepository = mockk(relaxed = true)
        mainViewModel = MainViewModel(networkRepository)
    }

    @Test
    fun `저장소 리스트를 불러오는 데 성공한다`() = runTest {
        // given
        coEvery { networkRepository.getGithubRepositories() } returns Result.success(listOf())

        // when
        mainViewModel.fetchRepositories()

        // then
        assertThat(mainViewModel.repositories.value).isInstanceOf(UiState.Success::class.java)
        coVerify { networkRepository.getGithubRepositories() }
    }

    @Test
    fun `저장소 목록을 불러오는 데 실패하여 뷰에 알린다`() = runTest {
        // given
        coEvery { networkRepository.getGithubRepositories() } returns Result.failure(Exception())

        // when
        mainViewModel.fetchRepositories()

        // then
        assertThat(mainViewModel.repositories.value).isInstanceOf(UiState.Error::class.java)
        coEvery { networkRepository.getGithubRepositories() }
    }

    companion object {
        @OptIn(ExperimentalCoroutinesApi::class)
        @JvmField
        @RegisterExtension
        val coroutineExtension = CoroutineExtension()
    }

}