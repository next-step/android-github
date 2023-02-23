package camp.nextstep.edu.github

import com.google.common.truth.Expect
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

    // soft assertion {실패 한 경우 모든 케이스 출력 ??}
    @get:Rule
    val expect: Expect = Expect.create()

    private lateinit var server: MockWebServer
    private lateinit var retrofitService: RetrofitService

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

    @Test
    fun `목웹서버 테스트`() {
        // given
        server.successTest("1.json")

        val actual = retrofitService.getGitHubRepository().execute().body()
        val expected = GitHubInfoResponse(fullName = "퓨유울네임", description = "디이이이스크립숀")

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