package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GitHubRepository
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GitHubRepositoryTest {
    private lateinit var service: GitHubService
    private lateinit var repository: GitHubRepository

    @Before
    fun setup() {
        service = mockk(relaxed = true)
        repository = GitHubRepositoryImpl(service)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `GitHub Repository 목록을 가져올 수 있어야 한다`() = runTest {
        // given
        val gitHubRepositoryResponse = GitHubRepositoryResponse("", "")
        coEvery {
            service.getGitHubRepositoryList().body()?.get(0)
        } returns gitHubRepositoryResponse

        // when
        val actual = repository.getGitHubRepositoryList()

        // then
        assertThat(actual.isSuccess).isTrue()
    }
}