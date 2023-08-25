package camp.nextstep.edu.github.data.network

import camp.nextstep.edu.github.domain.GithubRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class GithubRepositoriesDataSourceTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var api: GitHubService
    private lateinit var sut : GithubRepositoriesDataSource

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()

        val client = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .writeTimeout(1, TimeUnit.SECONDS)
            .build()

        api = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitHubService::class.java)

        sut = GithubRepositoriesDataSource(api)
    }
    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `GitHub repository들을 불러옴`() = runTest {
        val response = MockResponse().setBody("""
            [{
            	"full_name": "nextStep",
            	"description": "android-github"
            }]
        """.trimIndent()).setResponseCode(200)
        mockWebServer.enqueue(response)
        val actual = api.getRepositories()[0]
        val expected = GithubRepository("nextStep", "android-github")
        assertThat(actual).isEqualTo(expected)
    }
}