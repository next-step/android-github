package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.model.GitResponse
import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.File

class GitRepositoryTest {
    private lateinit var server: MockWebServer
    private lateinit var service: GitService

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .baseUrl(server.url(""))
            .build()
            .create()
    }

    @Test
    fun `GitService 의 getRepositories API 을 호출하면 GitResponse 항목을 받아올 수 있다`() {
        // given
        val json = File("src/test/resources/response_test.json").readText()
        val mockResponse = MockResponse()
            .setBody(json)
        server.enqueue(mockResponse)

        // when
        val actual = service.getRepositories().execute().body()

        // then
        val expected = GitResponse(
            "mojombo/grit",
            "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby."
        )
        assertThat(actual?.get(0)).isEqualTo(expected)
    }


}