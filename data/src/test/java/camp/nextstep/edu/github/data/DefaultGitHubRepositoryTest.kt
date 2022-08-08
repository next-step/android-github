package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import java.io.File

@OptIn(ExperimentalCoroutinesApi::class)
class DefaultGitHubRepositoryTest {

    private lateinit var repository: GithubRepository
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        val baseUrl = server.url("")

        repository = DefaultGitHubRepository(DataModule.provideGitHubService(baseUrl.toString()))
    }

    @Test
    fun `서버로부터 git repo 목록들을 읽어올 수 있어야 한다`() = runTest {
        //given
        val response = MockResponse()
            .setBody(File("src/test/resources/repositories.json").readText())
            .setResponseCode(200)
        server.enqueue(response)
        val expected = "mojombo/grit"

        //when
        val actual = repository.loadRepositories().list().firstOrNull()?.fullName

        //then
        assertThat(actual).isEqualTo(expected)
    }
}