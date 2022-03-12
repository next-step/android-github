package camp.nextstep.edu.github.data

import com.google.common.truth.Truth.assertThat
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
            .setBody(File("src/test/resources/github_fetch_repos_200.json").readText())
        mockServer.enqueue(jsonResponse)

        // when
        val response = service.fetchGithubRepos()
        val actualData = response.body()

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
        assertThat(actualData).isEqualTo(expected)
    }

    @Test
    internal fun `깃헙 레포지토리 리스트를 호출했지만 응답값이 비어있다`() = runBlocking {
        // given
        val jsonResponse = MockResponse()
            .setBody(File("src/test/resources/github_fetch_repos_200_empty.json").readText())
        mockServer.enqueue(jsonResponse)

        // when
        val response = service.fetchGithubRepos()
        val actualData = response.body()

        val expected = listOf<GithubRepoData>()

        // then
        assertThat(actualData).isEqualTo(expected)
    }

    @Test
    internal fun `깃헙 레포지토리 리스트를 호출했지만 응답 에러가 발생한다`() = runBlocking {
        // given
        val jsonResponse = MockResponse()
            .setBody(File("src/test/resources/github_fetch_repos_404.json").readText())
            .setResponseCode(404)
        mockServer.enqueue(jsonResponse)

        // when
        val actualResponse = service.fetchGithubRepos()

        // then
        assertThat(actualResponse.isSuccessful).isFalse()
    }
}