package camp.nextstep.edu.github.domain.usecase

import camp.nextstep.edu.github.domain.model.GithubStorage
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

}