package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepoRepository
import camp.nextstep.edu.github.domain.GithubRepositoryData
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

internal class GithubRepoRepositoryImplTest {
    private lateinit var server: MockWebServer
    private lateinit var repository: GithubRepoRepository

    @Before
    fun setUp() {
        server = MockWebServer()
        val service =
            Retrofit.Builder()
                .baseUrl(server.url(""))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService::class.java)
        repository = GithubRepoRepositoryImpl(service)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun `mock서버 Repository의 첫번째 데이터는 예상 데이터와 같다`() = runTest {
        val response =
            MockResponse()
                .setBody(File("src/test/resources/request_repositories_200.json").readText())
                .setResponseCode(200)
        server.enqueue(response)
        val expected = 100
        val actual = repository.getRepositories().size
        assertThat(actual).isEqualTo(expected)
    }
}
