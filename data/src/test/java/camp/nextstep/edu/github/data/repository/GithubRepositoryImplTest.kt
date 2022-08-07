package camp.nextstep.edu.github.data.repository

import camp.nextstep.edu.github.data.retrofit.GithubRetrofit
import camp.nextstep.edu.github.domain.model.Repository
import camp.nextstep.edu.github.domain.repository.GithubRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import java.io.File

class GithubRepositoryImplTest {

    private lateinit var mockServer: MockWebServer
    private lateinit var githubRepository: GithubRepository

    @Before
    fun setUp() {
        mockServer = MockWebServer()
        githubRepository = GithubRepositoryImpl(
            GithubRetrofit(mockServer.url("").toString()).githubService
        )
    }

    @Test
    fun `목록을 요청하면 성공적으로 목록이 반환된다`() = runTest {
        // given
        val response = MockResponse()
            .setResponseCode(200)
            .setBody(File("src/test/resources/RepositoryList.json").readText())
        mockServer.enqueue(response)

        val expected = listOf(
            Repository(
                fullName = "mojombo/grit",
                description = "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby."
            ),
            Repository(
                fullName = "wycats/merb-core",
                description = null
            ),
        )

        // when
        val actual = githubRepository.fetchRepositoryList().getOrNull()

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `빈 목록을 요청하면 성공적으로 빈 목록이 반환된다`() = runTest {
        // given
        val response = MockResponse()
            .setResponseCode(200)
            .setBody("[]")
        mockServer.enqueue(response)

        // when
        val actual = githubRepository.fetchRepositoryList().getOrNull()

        // then
        assertThat(actual).isEqualTo(emptyList<Repository>())
    }
}
