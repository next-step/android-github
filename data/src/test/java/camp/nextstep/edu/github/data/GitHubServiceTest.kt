package camp.nextstep.edu.github.data

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class GitHubServiceTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var service: GitHubService

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitHubService::class.java)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `GitHub Repository 목록을 가져올 수 있어야 한다`() = runTest {
        // given
        val response =
            MockResponse().setBody(File("src/test/java/camp/nextstep/edu/github/data/gitHubRepository.json").readText())
        mockWebServer.enqueue(response)

        // when
        val actual = service.getGitHubRepositoryList()

        // then
        val expected = GitHubRepositoryResponse(
            fullName = "mojombo/grit",
            description = "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby."
        )
        assertThat(actual[0]).isEqualTo(expected)
    }
}