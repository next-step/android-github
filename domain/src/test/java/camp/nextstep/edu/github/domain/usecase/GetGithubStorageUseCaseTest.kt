package camp.nextstep.edu.github.domain.usecase

import camp.nextstep.edu.github.domain.model.GithubStorage
import camp.nextstep.edu.github.domain.model.NetworkState
import camp.nextstep.edu.github.domain.repository.GithubRepository
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class GetGithubStorageUseCaseTest {


    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var getGithubStorageUseCase: GetGithubStorageUseCase
    private lateinit var githubRepository: GithubRepository

    @Before
    fun setUp() {
        githubRepository = mockk()
        getGithubStorageUseCase = GetGithubStorageUseCase(githubRepository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun 레포지토리의_getRepositories_메소드를_수행한다() = runTest {
        // given
        coEvery { githubRepository.getRepositories() } returns runCatching { listOf() }
        // when
        getGithubStorageUseCase()
        // then
        coVerify { githubRepository.getRepositories() }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun 레포지토리의_getRepositories_메소드가_오류를_발생하면_NetworkState의_Error를_반환한다() = runTest {
        // given
        coEvery { githubRepository.getRepositories() } returns Result.failure(Throwable())
        // when
        val actual = getGithubStorageUseCase()
        advanceUntilIdle()
        // then
        Truth.assertThat(actual).isInstanceOf(NetworkState.Error::class.java)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun 레포지토리의_getRepositories_메소드가_정상적으로_실행되면_NetworkState의_Success를_반환한다() = runTest {
        // given
        val githubStorages = mockk<List<GithubStorage>>()
        coEvery { githubRepository.getRepositories() } returns Result.success(githubStorages)
        // when
        val actual = getGithubStorageUseCase()
        advanceUntilIdle()
        // then
        Truth.assertThat(actual).isInstanceOf(NetworkState.Success::class.java)
    }

}