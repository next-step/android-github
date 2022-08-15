package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GitHubRepository
import camp.nextstep.edu.github.domain.GitHubRepositoryItem
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertAll
import retrofit2.Response

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
        val gitHubRepositoryResponse = listOf(
            GitHubRepositoryResponse(fullName = "fullName", description = "description")
        )
        val response = Response.success(200, gitHubRepositoryResponse)
        coEvery { service.getGitHubRepositoryList() } returns response

        val expected = listOf(
            GitHubRepositoryItem(fullName = "fullName", description = "description")
        )

        // when
        val result = repository.getGitHubRepositoryList()

        // then
        assertAll(
            { assertThat(result.isSuccess).isTrue() },
            { assertThat(result.getOrThrow()).containsExactlyElementsIn(expected) },
        )
    }
}