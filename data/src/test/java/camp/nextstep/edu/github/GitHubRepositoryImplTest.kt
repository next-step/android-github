package camp.nextstep.edu.github

import com.google.common.truth.Expect
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.File


class GitHubRepositoryImplTest {

    @get:Rule
    val expect: Expect = Expect.create()

    private lateinit var server: MockWebServer
    private lateinit var retrofitService: GithubService

    @Before
    fun setUp() {
        server = MockWebServer()

        val baseUrl = server.url("")

        retrofitService = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
            .create()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `GithubRepository 통신 테스트`() = runTest {
        // given
        server.successTest("1.json")

        val actual = retrofitService.getGitHubRepositories()
        val expected = listOf(GitHubInfoResponse(fullName = "퓨유울네임", description = "디이이이스크립숀"))

        expect.that(actual).isEqualTo(expected)
    }
}

fun MockWebServer.successTest(fileName: String) {
    val response = MockResponse()
    val json = readJson(fileName)

    response.setResponseCode(200)
    response.setBody(json)

    enqueue(response)
}

fun readJson(fileName: String): String {
    return File("src/test/java/camp/nextstep/edu/github/resources/tasks/$fileName").readText()
}