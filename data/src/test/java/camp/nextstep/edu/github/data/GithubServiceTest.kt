package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.model.GitResponse
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class GithubServiceTest {
    private lateinit var server: MockWebServer
    private lateinit var service: GithubService

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit
            .Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubService::class.java)
    }

    @Test
    fun `깃헙 repository 리스트를 불러온다`() = runBlocking {
        // given
        val json = File("src/test/resources/github_repository_response_success.json").readText()
        val mockResponse = MockResponse()
            .setBody(json)
        server.enqueue(mockResponse)

        // when
        val actual = service.getRepositories()
        val body = actual.body()

        // then
        val expected = listOf(
            GitResponse(
                fullName = "mojombo/grit",
                description = "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby."
            )
        )
        assertThat(body).isEqualTo(expected)
    }
}