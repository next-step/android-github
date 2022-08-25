package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepoRepository
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
                .create(GithubNetworkService::class.java)
        repository = GithubRepoRepositoryImpl(service)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun `mock서버 Repository의 첫번째 데이터는 예상 데이터와 같다`() = runTest {
        val response = MockResponse()
            .setBody(File("src/test/resources/repositories/result_200_size_100.json").readText())
            .setResponseCode(200)
        server.enqueue(response)
        val expectedSize = 100
        val actual = repository.getRepositories()
        val actualSuccess = actual.isSuccess
        val actualRepositorySize = actual.getOrNull()?.size ?: -1
        assertThat(actualSuccess).isTrue()

        assertThat(actualRepositorySize).isEqualTo(expectedSize)
    }
}
