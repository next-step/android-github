package camp.nextstep.edu.github.data

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

/**
 * Created by link.js on 2022. 08. 05..
 */
class GithubServiceTest {
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
    fun `깃헙 데이터를 잘 읽는다`() = runTest {
        // given
        val response = MockResponse()
            .setBody(File("src/test/java/resources/githubRepositoriesTestData.json").readText())
        server.enqueue(response)

        // when
        val actual = service.getRepositories()

        // then
        val expected = RepositoryDto("mojombo/grit",
            "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby.")
        assertEquals(actual.first(), expected)
    }
}