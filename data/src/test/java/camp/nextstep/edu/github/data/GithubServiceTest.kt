package camp.nextstep.edu.github.data

import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class GithubServiceTest {
    private val mockServer = MockWebServer()
    private lateinit var service: GithubService

    @BeforeEach
    fun setUp() {
        service = Retrofit
            .Builder()
            .baseUrl(mockServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubService::class.java)
    }

    @Test
    fun `깃헙 레포지토리 리스트를 불러온다`() = runBlocking {
        // given
        val jsonResponse = MockResponse()
            .setBody(File("src/test/resources/github_response_200.json").readText())
        mockServer.enqueue(jsonResponse)

        // when
        val response = service.fetchGithubRepos()
        val actualData = response.body() as List<GithubRepoData>

        val expected = listOf(
            GithubRepoData(
                fullName = "mojombo/grit",
                description = "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby."
            ),
            GithubRepoData(
                fullName = null,
                description = "Merb Core: All you need. None you don't."
            )
        )

        // then
        assertEquals(expected, actualData)
    }
}