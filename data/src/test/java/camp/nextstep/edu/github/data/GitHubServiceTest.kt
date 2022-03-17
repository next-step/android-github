package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.exception.HttpResponseFailureException
import camp.nextstep.edu.github.data.network.GitHubService
import camp.nextstep.edu.github.data.network.response.RepositoriesItem
import camp.nextstep.edu.github.util.TestGitHubService
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
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
        val json = File("src/test/resources/repositories-200.json").readText()
        val response = MockResponse()
            .setResponseCode(200)
            .setBody(json)
        server.enqueue(response)

        val actual: List<RepositoriesItem>? = service.getRepositories().body()

        assertThat(actual).containsExactly(
            RepositoriesItem("defunkt/starling", null),
            RepositoriesItem("wycats/merb-more", "Merb More: The Full Stack. Take what you need; leave what you don't."),
        )
    }

    @DisplayName("응답코드 200 에 리스트가 없을 때 Repository 빈 리스트를 가지고 온다")
    @Test
    fun getEmptyRepositoriesTest(): Unit = runBlocking {
        val response = MockResponse()
            .setResponseCode(200)
            .setBody("[]")
        server.enqueue(response)

        val actual: List<RepositoriesItem>? = service.getRepositories().body()

        assertThat(actual).isEmpty()
    }



    @DisplayName("상태코드가 200 이 아닐 때 Response 테스트(isSuccessful - false, body - null, code 와 errorBody 는 statusCode, body 파라메터가 나올 것)")
    @ParameterizedTest(name = "상태코드: {0}, errorBody: {1}")
    @CsvSource(
        value = [
            "400 | {\"message\": \"Problems parsing JSON\"}",
            "401 | {\"message\": \"Bad credentials\", \"documentation_url\": \"https://docs.github.com/rest\"}",
            "404 | {\"message\": \"Not Found\", \"documentation_url\": \"https://docs.github.com/rest\"}",
            "403 | {\"message\": \"Maximum number of login attempts exceeded. Please try again later.\", \"documentation_url\": \"https://docs.github.com/rest\"}",
            "500 | Internal Server Error",
            "503 | Service Unavailable",
            "507 | "
        ],
        delimiter = '|'
    )
    fun statusCodeTest(statusCode: Int, body: String?) = runBlocking {
        val errorBody = body.orEmpty()
        val response = MockResponse()
            .setResponseCode(statusCode)
            .setBody(errorBody)
        server.enqueue(response)

        val result = service.getRepositories()

        assertThat(result.isSuccessful).isFalse()
        assertThat(result.code()).isEqualTo(statusCode)
        assertThat(result.body()).isEqualTo(null)
        assertThat(result.errorBody()?.string()).isEqualTo(errorBody)
    }

    @DisplayName("Http Response Status 가 200 이외의 응답이 오면 HttpResponseFailureException 이 발생한다")
    @ParameterizedTest
    @CsvSource(
        "400",
        "401",
        "404",
        "403",
        "500",
        "503",
        "507"
    )
    fun getResponseExtensionFunctionTest(statusCode: Int) = runBlocking {
        val serviceResponse = MockResponse()
            .setResponseCode(statusCode)
        server.enqueue(serviceResponse)

        val response = service.getRepositories()

        val actual = Assertions.assertThrows(HttpResponseFailureException::class.java) {
            response.getResponse()
        }
        assertThat(actual).isInstanceOf(HttpResponseFailureException::class.java)
    }
}

