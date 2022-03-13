package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.network.GitHubService
import camp.nextstep.edu.github.data.network.response.RepositoriesItem
import camp.nextstep.edu.github.util.TestGitHubService
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.File

class GitHubServiceTest {
    private lateinit var server: MockWebServer
    private lateinit var service: GitHubService

    @BeforeEach
    fun setUp() {
        server = MockWebServer()
        service = TestGitHubService.getGitHubService(server)
    }

    @DisplayName("Repository 리스트를 가지고 온다")
    @Test
    fun getRepositoriesTest(): Unit = runBlocking {
        val json =  File("src/test/resources/repositories.json").readText()
        val response = MockResponse()
            .setBody(json)
        server.enqueue(response)

        val actual: List<RepositoriesItem>? = service.getRepositories().body()

        val expected = listOf(
            RepositoriesItem("defunkt/starling", null),
            RepositoriesItem("wycats/merb-more", "Merb More: The Full Stack. Take what you need; leave what you don't."),
        )
        assertThat(actual).isEqualTo(expected)
    }
}