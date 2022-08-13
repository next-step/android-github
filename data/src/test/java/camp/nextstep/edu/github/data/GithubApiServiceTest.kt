package camp.nextstep.edu.github.data

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.assertAll
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.File

@ExperimentalCoroutinesApi
class GithubApiServiceTest {

    private lateinit var server: MockWebServer
    private lateinit var apiService: GithubApiService

    @Before
    fun setUp() {
        server = MockWebServer()
        apiService = Retrofit.Builder()
            .baseUrl(server.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @Test
    fun apiService에서_요청시_저장소를_불러올_수_있어야_한다() = runTest {
        //given
        val jsonPath = javaClass.getResource("/repository-200.json").path
        val response = MockResponse()
            .setBody(File(jsonPath).readText())
            .setResponseCode(200)

        server.enqueue(response)

        val expected = GithubRepoResponse(
            name = "mojombo/grit",
            description = "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby."
        )

        //when
        val actual = apiService.repositories().first()

        //then
        assertThat(actual).isEqualTo(expected)
    }
}