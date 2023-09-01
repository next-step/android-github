/**
 * @author Daewon on 01,September,2023
 *
 */

package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.di.NetworkProvider
import camp.nextstep.edu.github.data.response.GithubRepositoryResponse
import camp.nextstep.edu.github.data.retrofit.GithubService
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import java.io.File


class GithubServiceTest {

    private lateinit var server: MockWebServer
    private lateinit var githubService: GithubService

    @Before
    fun setUp() {
        server = MockWebServer()
        githubService = NetworkProvider.provideGithubService(server.url("").toString())
    }

    @Test
    fun `HTTP_요청_파싱후_첫번째_아이템이_포함되어야_한다`() = runTest {
        // given
        val response = MockResponse().setBody(File("src/test/resources/repositories.json").readText())
        server.enqueue(response)

        // when
        val actual = githubService.getRepositories()

        // then
        val expected = GithubRepositoryResponse(
            fullName = "mojombo/grit",
            description = "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby."
        )
        assertThat(actual).contains(expected)
    }

    @Test
    fun `emptyList_응답`() = runTest {
        // given
        val response = MockResponse().setBody(File("src/test/resources/emptyList.json").readText())
        server.enqueue(response)

        // when
        val actual = githubService.getRepositories()

        // then
        assertThat(actual).isEmpty()
    }
}
