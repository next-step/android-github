package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.dto.GitRepoDto
import camp.nextstep.edu.github.data.service.GithubService
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

@ExperimentalCoroutinesApi
class GithubServiceTest {
    private val dispatcher = StandardTestDispatcher()
    private val scope = TestScope(dispatcher)

    private lateinit var server: MockWebServer
    private lateinit var service: GithubService

    @BeforeEach
    fun setup() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(server.url(""))
            .build()
            .create(GithubService::class.java)
    }

    @Test
    fun `Github Repositories 호출`() = scope.runTest {
        // given
        val response = MockResponse()
            .setBody(File("src/test/resources/githubRepo.json").readText())
        server.enqueue(response)

        // when
        val actualValue = service.getRepositories()

        // then
        val expectedValue = GitRepoDto("mojombo/grit", "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby.")
        assertThat(actualValue[0]).isEqualTo(expectedValue)
    }
}