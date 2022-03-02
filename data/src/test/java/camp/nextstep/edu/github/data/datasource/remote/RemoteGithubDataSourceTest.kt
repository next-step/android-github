package camp.nextstep.edu.github.data.datasource.remote

import app.cash.turbine.test
import camp.nextstep.edu.github.data.datasource.remote.response.ResponseRepository
import camp.nextstep.edu.github.data.datasource.remote.response.mappers.ResponseRepositoryMapper
import camp.nextstep.edu.github.data.datasource.remote.service.GithubService
import camp.nextstep.edu.github.domain.model.Repository
import com.google.common.truth.Truth.*
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class RemoteGithubDataSourceTest {

    private lateinit var githubService: GithubService
    private lateinit var responseRepositoryMapper: ResponseRepositoryMapper
    private lateinit var githubDataSource: RemoteGithubDataSource

    @BeforeEach
    internal fun setUp() {
        githubService = mockk(relaxed = true)
        responseRepositoryMapper = ResponseRepositoryMapper()
        githubDataSource = RemoteGithubDataSource(githubService, responseRepositoryMapper)
    }

    @Test
    internal fun `GithubDataSource를 통해 도메인 Repositories를 가져올 수 있다`() = runTest {
        // given
        val responseRepositoryList = listOf(
            ResponseRepository(fullName = "fullName", description = "description")
        )

        coEvery { githubService.getRepositories() } answers { responseRepositoryList }

        // when
       val actualFlow = githubDataSource.getReposotories()

        // then
        val expected = listOf(
            Repository("fullName", "description")
        )

        actualFlow.test {
            val actual = awaitItem()
            assertThat(actual).isEqualTo(expected)
            awaitComplete()
        }
    }
}