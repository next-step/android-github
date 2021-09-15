package camp.nextstep.edu.github.data.remote.network

import com.google.common.truth.Expect
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.File

class GithubServiceTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var githubService: GithubService

    @get:Rule
    val expect: Expect = Expect.create()

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        githubService = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(mockWebServer.url(""))
            .build()
            .create()
    }

    @Test
    fun `Repository 목록을 가져온다`() = runBlocking {
        // given
        val responseJson = File("src/test/resources/reposResponse.json").readText()
        val response = MockResponse().setBody(responseJson)
        mockWebServer.enqueue(response)

        // when
        val resultList = githubService.loadRepos()

        // then
        expect.that(resultList).isNotEmpty()
        resultList.forEach {
            expect.that(it.id).isNotNull()
        }
    }
}
