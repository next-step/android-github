package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.RepositoryVO
import com.google.common.truth.Truth.assertThat
import com.google.gson.GsonBuilder
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.io.FileReader

internal class GithubRepositoryImplTest {

    private lateinit var server: MockWebServer
    private lateinit var repo: GithubRepository

    @Before
    fun setUp() {
        val gson = GsonBuilder().setLenient().create()
        server = MockWebServer()
        server.start()
        val apiService = Retrofit.Builder()
            .baseUrl(server.url("/repositories/"))
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService::class.java)
        repo = GithubRepositoryImpl(apiService)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun `repositories path를 가진 api를 호출했을 때, 정상적으로 호출 후 응답이 내려온다`() = runBlocking {
        server.enqueue(
            MockResponse().setResponseCode(200).setBody(
                File("src/test/java/res/response-200.json").readText()
            )
        )
        val actual = repo.getRepositories().first()
        assertThat(actual).isEqualTo(
            RepositoryVO(
                "mojombo/grit",
                "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby."
            )
        )
    }
}