package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.mapper.mapping
import camp.nextstep.edu.github.domain.model.Github
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.File

class GithubServiceTest {

    private lateinit var server: MockWebServer
    private lateinit var service: GithubService

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(server.url(""))
            .build()
            .create()
    }

    @Test
    fun `Github 레포지터리 리스트 요청`() = runBlocking {
        // given
        val response = MockResponse()
            .setBody(File("src/test/resources/repositories-200.json").readText())
        server.enqueue(response)

        val expected = listOf(
            Github(
                "mojombo/grit",
                "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby."
            ),
            Github(
                "wycats/merb-core",
                "Merb Core: All you need. None you don't."
            ),
            Github(
                "rubinius/rubinius",
                "The Rubinius Language Platform"
            )
        )

        // when
        val actual = service.getGithubRepositories().mapping()

        // then
        assertThat(actual, equalTo(expected))
    }
}
