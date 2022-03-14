package data

import com.github.dodobest.data.retrofit.GithubApiService
import com.github.dodobest.data.retrofit.GithubDataResponse
import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class GithubApiServiceTest {
    private lateinit var server: MockWebServer
    private lateinit var service: GithubApiService

    @Before
    fun setUp() {
        server = MockWebServer()
        val gson = Gson()
        service = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(server.url(""))
            .build()
            .create(GithubApiService::class.java)
    }

    @Test
    fun `깃허브 API 요청을 하면 데이터를 수신한다`() {
        // given
        val response = MockResponse()
            .setBody(File("src/test/resources/githubResponseJson.json").readText())
        server.enqueue(response)

        // when
        val actual: List<GithubDataResponse> = service.getRepositories().execute().body()!!
        val actualOne = actual[0]
        val actualTwo = actual[1]
        val actualThree = actual[2]
        val actualFour = actual[3]

        // then
        val expectedOne = GithubDataResponse("one", "this is one")
        val expectedTwo = GithubDataResponse("two", null)
        val expectedThree = GithubDataResponse(null, "this is null")
        val expectedFour = GithubDataResponse(null, null)

        assertThat(actualOne).isEqualTo(expectedOne)
        assertThat(actualTwo).isEqualTo(expectedTwo)
        assertThat(actualThree).isEqualTo(expectedThree)
        assertThat(actualFour).isEqualTo(expectedFour)
    }
}