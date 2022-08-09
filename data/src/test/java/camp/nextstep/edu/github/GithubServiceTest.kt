package camp.nextstep.edu.github

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.GithubService
import camp.nextstep.edu.github.domain.Repo
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import okhttp3.HttpUrl
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.File

internal class GithubServiceTest {
//
//    private lateinit var server: MockWebServer
//    private lateinit var service: GithubRepository
//
//    @Before
//    fun setup() {
//        server = MockWebServer()
////        server.start()
//        val retrofit = createRetrofit(server.url("/"))
//        service = createGitRepoRepository(retrofit)
//    }
//
//    @Test
//    fun `Repository를 받아온다`() = runBlocking {
//        // given
//        val mockJsonString = getMockGetRepoJsonString()
//        server.enqueue(MockResponse().setBody(mockJsonString))
//
//        // when
////        val actual = service.getGithubService().listRepos()
//
//        // then
////        assertNotNull(actual.size)
//    }
//
//
////    private fun getMockFile(): File {
////        return File(javaClass.getResource("/repos.json").toURI())
////    }
//
//    private fun getMockGetRepoJsonString(): String {
//       return File("src/test/resources/repos.json").readText()
//    }
//
//    private fun createRetrofit(baseUrl: HttpUrl): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(baseUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//    private fun createGitRepoRepository(retrofit: Retrofit): GithubRepository {
//        return retrofit.create()
//    }


    private lateinit var server: MockWebServer
    private lateinit var service: GithubRepository

    @Before
    fun setUp() {
        server = MockWebServer()

//        service = Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl(server.url(""))
//            .build()
//            .create()

        service = DataInjector.provideGithubRepository()
    }

    @Test
    fun `foo 요청`() {
        // given
        val response = MockResponse()
            .setBody(File("src/test/resources/repos.json").readText())
        server.enqueue(response)

        // when
        val actual: List<Repo>? = service.listRepos().execute().body()

        // then
        val expected = Repo("mojombo/grit", "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby.")
        actual?.let {
            Truth.assertThat(actual[0]).isEqualTo(expected)
        }
    }

}
