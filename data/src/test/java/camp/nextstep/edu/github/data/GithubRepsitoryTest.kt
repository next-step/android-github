package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.datasource.GithubRemoteDataSource
import camp.nextstep.edu.github.data.di.RepositoryInjector
import camp.nextstep.edu.github.domain.repository.GithubRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GithubRepsitoryTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var githubRemoteDataSource: GithubRemoteDataSource
    private lateinit var githubRepository: GithubRepository

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        githubRemoteDataSource = mockk()
        githubRepository = RepositoryInjector.provideRepositoryInjector(githubRemoteDataSource)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun 레포지토리_데이터소스의_getRepositories_메소드를_수행한다() = runTest {
        // given
        coEvery { githubRemoteDataSource.getRepositories() } returns runCatching { listOf() }
        // when
        githubRepository.getRepositories()
        // then
        coVerify { githubRepository.getRepositories() }
    }
}