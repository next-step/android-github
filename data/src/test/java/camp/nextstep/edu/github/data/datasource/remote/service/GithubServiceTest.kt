package camp.nextstep.edu.github.data.datasource.remote.service

import camp.nextstep.edu.github.data.datasource.remote.response.ResponseRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File

internal class GithubServiceTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var githubService: GithubService

    @BeforeEach
    internal fun setUp() {
        mockWebServer = MockWebServer()
        githubService = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(GithubService::class.java)
    }

    @Test
    internal fun `GithubService를 통해 Github Repository 목록을 가져올 수 있다`() = runTest {
        // given
        val responseJson = getJson("get_repositories_response_success.json")
        val response = MockResponse().setBody(responseJson)

        mockWebServer.enqueue(response)

        val expected = listOf(
            ResponseRepository(
                fullName = "mojombo/grit",
                description = "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby."
            )
        )

        // when
        val actual = githubService.getRepositories()

        // then
        assertThat(actual[0].fullName).isEqualTo(expected[0].fullName)
        assertThat(actual[0].description).isEqualTo(expected[0].description)
    }

    private fun getJson(filename: String): String {
        return File("src/test/resources/${filename}").readText()
    }
}