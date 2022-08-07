package camp.nextstep.edu.github.data

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File

class GithubServiceTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var service: GithubService

    @BeforeEach
    fun setUp() {
        mockWebServer = MockWebServer()
        service = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(mockWebServer.url(""))
            .build()
            .create(GithubService::class.java)
    }

    @Test
    fun `Github Repository 리스트를 받아올 수 있다`() = runBlocking {
        // given
        val response = MockResponse().setBody(File(JSON_FILE_PATH).readText())
        mockWebServer.enqueue(response)

        // when
        val actual = service.getRepositories()

        // then
        val expected = listOf(
            RepositoryEntity(
                fullName = "wisemuji",
                description = "This is test description"
            ),
        )
        assertThat(actual).isEqualTo(expected)
    }

    companion object {
        private const val JSON_FILE_PATH = "src/test/resources/get_repositories_response_success.json"
    }
}
