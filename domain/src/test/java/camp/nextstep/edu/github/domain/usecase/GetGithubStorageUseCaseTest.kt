package camp.nextstep.edu.github.domain.usecase

import camp.nextstep.edu.github.domain.di.UseCaseInjector
import camp.nextstep.edu.github.domain.model.GithubStorage
import camp.nextstep.edu.github.domain.repository.GithubRepository
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
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
        getGithubStorageUseCase = UseCaseInjector.provideGetGithubStorageUseCase(githubRepository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun 유스케이스는_레포지토리의_getRepositories_메소드를_수행한다() = runTest {
        // given
        coEvery { githubRepository.getRepositories() } returns runCatching { listOf() }
        // when
        getGithubStorageUseCase.invoke()
        // then
        coVerify { githubRepository.getRepositories() }
    }

}