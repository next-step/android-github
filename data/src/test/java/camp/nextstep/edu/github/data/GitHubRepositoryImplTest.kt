package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.error.Error
import camp.nextstep.edu.github.domain.model.GitHubRepositoryData
import camp.nextstep.edu.github.util.TestGitHubService
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.io.File

internal class GitHubRepositoryImplTest {
    lateinit var gitHubRepository: GitHubRepositoryImpl
    private lateinit var server: MockWebServer

    @BeforeEach
    fun setUp() {
        server = MockWebServer()
        gitHubRepository = GitHubRepositoryImpl(TestGitHubService.getGitHubService(server))
    }

    @DisplayName("정상적인(200) 응답이 있을 경우 Repository 리스트를 가지고 온다")
    @Test
    fun getRepositoriesTest(): Unit = runBlocking {
        val json = File("src/test/resources/repositories-200.json").readText()
        val response = MockResponse()
            .setBody(json)
        server.enqueue(response)

        val actual = gitHubRepository.getRepositories().getOrDefault(emptyList())

        val expected = listOf(
            GitHubRepositoryData("defunkt/starling", ""),
            GitHubRepositoryData("wycats/merb-more", "Merb More: The Full Stack. Take what you need; leave what you don't."),
        )
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("상태코드가 200 이 아닌 경우 Result 가 Failure 이다.")
    @ParameterizedTest()
    @ValueSource(ints = [400, 401, 404, 403, 500, 503])
    fun notOkResponseCodeFailureTest(responseCode: Int) = runBlocking {
        val response = MockResponse().setResponseCode(responseCode)
        server.enqueue(response)

        val actual = gitHubRepository.getRepositories()

        assertThat(actual.isFailure).isTrue()
    }

    @DisplayName("상태코드가 200 이 아닌 경우 NetworkUnavailable Error 가 Result 에 전달된다")
    @ParameterizedTest()
    @ValueSource(ints = [400, 401, 404, 403, 500, 503])
    fun notOkResponseCodeErrorTest(responseCode: Int) = runBlocking {
        val response = MockResponse().setResponseCode(responseCode)
        server.enqueue(response)

        val actual = gitHubRepository.getRepositories()

        assertThat(actual.exceptionOrNull()).isInstanceOf(Error.NetworkUnavailable.javaClass)
    }

}