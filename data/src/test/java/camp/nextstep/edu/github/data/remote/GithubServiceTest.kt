package camp.nextstep.edu.github.data.remote

import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class GithubApiServiceTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var service: GithubService

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        val gson = Gson()
        service = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(mockWebServer.url(""))
            .build()
            .create(GithubService::class.java)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `깃허브 API 요청을 하면 데이터를 수신한다`() = runTest {
        // given
        val response = MockResponse()
            .setBody(File("src/test/resource/repository_response.json").readText())
        mockWebServer.enqueue(response)

        // when
        val actual: List<GithubRepositoryData> = service.getRepositories()

        // then
        val expected = listOf(
            GithubRepositoryData(
                "mojombo/grit",
                "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby."
            ),
            GithubRepositoryData(
                "wycats/merb-core",
                "Merb Core: All you need. None you don't."
            )
        )
        assertThat(actual).isEqualTo(expected)

    }
}