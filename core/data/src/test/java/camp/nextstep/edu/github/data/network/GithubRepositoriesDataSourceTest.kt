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
import java.io.File
import java.util.concurrent.TimeUnit

class GithubRepositoriesDataSourceTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var api: GithubService
    private lateinit var dataSource: GithubRepositoriesDataSource

    private val client = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.SECONDS)
        .readTimeout(1, TimeUnit.SECONDS)
        .writeTimeout(1, TimeUnit.SECONDS)
        .build()

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `Github repository들을 불러옴`() = runTest {
        api = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubService::class.java)
        val body = File("src/test/resources/response.json").readText()
        val response = MockResponse().setBody(body).setResponseCode(200)
        mockWebServer.enqueue(response)
        dataSource = GithubRepositoriesDataSource(api)
        val actual = dataSource.fetchRepositories()[0]
        val expected = GithubRepository("nextStep", "android-github")
        assertThat(actual).isEqualTo(expected)
    }
}
